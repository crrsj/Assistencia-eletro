package br.com.assistencia.dto;

import br.com.assistencia.entity.EletroDomestico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteDTO {

    private Long id;
    @NotBlank(message = "não pode estar em branco !")
    private String nome;
    private String cpf;
    @NotBlank(message = "não pode estar em branco !")
    private String telefone;
    private List<EletroDomestico> eletroDomestico = new ArrayList<>();
}
