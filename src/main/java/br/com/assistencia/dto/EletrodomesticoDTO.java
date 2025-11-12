package br.com.assistencia.dto;

import br.com.assistencia.entity.Cliente;
import br.com.assistencia.enums.Aparelho;
import br.com.assistencia.enums.StatusServico;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
public class EletrodomesticoDTO {
    private Long id;
    private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private Integer ordemServico = new Random().nextInt(9000) + 1000;
    private Aparelho aparelho;
    @NotBlank(message = "não pode estar em branco !")
    private String marca;
    @NotBlank(message = "não pode estar em branco !")
    private String modelo;
    private String descricao;
    private LocalDate dataEntrega;
    private Double total;
    @Pattern(regexp = "ORCAMENTO|CONTRATADO", message = "O status inicial deve ser ORCAMENTO ou CONTRATADO.")
    private StatusServico status;
    private Cliente cliente;
}
