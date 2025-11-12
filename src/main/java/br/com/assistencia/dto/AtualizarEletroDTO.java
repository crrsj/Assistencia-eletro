package br.com.assistencia.dto;

import br.com.assistencia.entity.Cliente;
import br.com.assistencia.enums.Aparelho;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
public class AtualizarEletroDTO {
    private Long id;
    private Aparelho aparelho;
    private String marca;
    private String modelo;
    private String descricao;
    private LocalDate dataEntrega;
    private Double total;

}
