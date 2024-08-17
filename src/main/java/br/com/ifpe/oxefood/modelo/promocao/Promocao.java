package br.com.ifpe.oxefood.modelo.promocao;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Promocao")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promocao extends EntidadeAuditavel {
 
 @Column   
 private String titulo;

 @Column
 private LocalDateTime dataInicio;

 @Column
 private LocalDateTime dataFim;

 @Column
 private String regra;

 @Column
 private Double valorDesconto;
}