package br.com.assistencia.dto;

import br.com.assistencia.entity.EletroDomestico;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuscarClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private List<EletroDomestico> eletroDomestico = new ArrayList<>();
}
