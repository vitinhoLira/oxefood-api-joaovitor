package br.com.ifpe.oxefood.modelo.promocao;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocaoService {

    @Autowired
    private PromocaoRepository repository;

    @Transactional
    public void delete(Long id) {
        Promocao promocao = repository.findById(id).get();
        promocao.setHabilitado(Boolean.FALSE);
        promocao.setVersao(promocao.getVersao() + 1);
        repository.save(promocao);
    }

    @Transactional

    public List<Promocao> listarTodos() {

        return repository.findAll();
    }

    public Promocao obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Promocao promocaoAlterado) {
        Promocao promocao = repository.findById(id).get();
        promocao.setTitulo(promocaoAlterado.getTitulo());
        promocao.setDataInicio(promocaoAlterado.getDataInicio());
        promocao.setDataFim(promocaoAlterado.getDataFim());
        promocao.setRegra(promocaoAlterado.getRegra());
        promocao.setValorDesconto(promocaoAlterado.getValorDesconto());

        promocao.setVersao(promocao.getVersao() + 1);
        repository.save(promocao);
    }

    public Promocao save(Promocao promocao) {

        promocao.setHabilitado(Boolean.TRUE);
        promocao.setVersao(1L);
        promocao.setDataCriacao(LocalDate.now());

        return repository.save(promocao);

    }
}
