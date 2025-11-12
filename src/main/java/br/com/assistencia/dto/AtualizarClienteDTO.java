package br.com.assistencia.dto;


import br.com.assistencia.entity.EletroDomestico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AtualizarClienteDTO {

    private Long id;
    private String nome;
    private String telefone;

}
