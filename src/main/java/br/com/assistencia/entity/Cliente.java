package br.com.assistencia.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @CPF
    @Column(unique = true)
    private String cpf;
    private String telefone;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<EletroDomestico>eletroDomestico = new ArrayList<>();
}
