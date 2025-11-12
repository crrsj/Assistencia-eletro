package br.com.assistencia.service;

import br.com.assistencia.dto.AtualizarClienteDTO;
import br.com.assistencia.dto.BuscarClienteDTO;
import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.entity.Cliente;
import br.com.assistencia.exceptions.ClienteNaoEncontrado;
import br.com.assistencia.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;


    public ClienteDTO salvarCliente(ClienteDTO clienteDTO){
     var salvar = modelMapper.map(clienteDTO, Cliente.class);
     var clienteSalvo = clienteRepository.save(salvar);
     return modelMapper.map(clienteSalvo, ClienteDTO.class);
    }
    public Page<BuscarClienteDTO> listarClientes(Pageable pageable){
        return clienteRepository.findAll(pageable)
                .map(cliente-> modelMapper
                .map(cliente, BuscarClienteDTO.class));
    }

    public BuscarClienteDTO buscarPorId(Long id){
        var buscar =  clienteRepository.findById(id).orElseThrow(ClienteNaoEncontrado::new);
        return modelMapper.map(buscar, BuscarClienteDTO.class);
    }

    public BuscarClienteDTO buscarPorCpf(String cpf){
     var buscarCliente = clienteRepository.findByCpf(cpf)
             .orElseThrow(ClienteNaoEncontrado::new);
     return modelMapper.map(buscarCliente, BuscarClienteDTO.class);
    }

    @Transactional
    public AtualizarClienteDTO atualizarCliente(Long id, AtualizarClienteDTO clienteDTO){
        var cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoEncontrado::new);
        modelMapper.map(clienteDTO,cliente);
        var clienteAtualizado = clienteRepository.save(cliente);
        return modelMapper.map(clienteAtualizado, AtualizarClienteDTO.class);

    }

    public void excluirCliente(Long id){
        var cliente = clienteRepository.findById(id)
                .orElseThrow(ClienteNaoEncontrado::new);
        clienteRepository.delete(cliente);
    }
}
