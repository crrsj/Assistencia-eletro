package br.com.assistencia.entity;

import br.com.assistencia.enums.Aparelho;
import br.com.assistencia.enums.StatusServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Entity
@Table(name = "tb_eletro")
@Data
public class EletroDomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private Integer ordemServico = new Random().nextInt(9000) + 1000;
    @Enumerated(EnumType.STRING)
    private Aparelho aparelho;
    private String marca;
    private String modelo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private LocalDate dataEntrega;
    private Double total;
    @Enumerated(EnumType.STRING)
    private StatusServico status;
    @JsonIgnore
    @JoinColumn(name = "clienteId")
    @ManyToOne
    private Cliente cliente;

}
