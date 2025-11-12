package br.com.assistencia.controller;

import br.com.assistencia.dto.AtualizarClienteDTO;
import br.com.assistencia.dto.BuscarClienteDTO;
import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "endpoint responsável por cdastrar cliente.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ClienteDTO>salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        var cliente = clienteService.salvarCliente(clienteDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    @Operation(summary = "endpoint responsável por listar clientes.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Page<BuscarClienteDTO>>buscarClientes(Pageable pageable){
        Page<BuscarClienteDTO>cliente = clienteService.listarClientes(pageable);
        return ResponseEntity.ok(cliente);
    }


    @GetMapping("/buscarCpf")
    @Operation(summary = "endpoint responsável por buscar clientes por cpf.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<BuscarClienteDTO>buscarPorCpf(@RequestParam String cpf){
        return  ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }


    @GetMapping("/{id}")
    @Operation(summary = "endpoint responsável por buscar cliente pelo id.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<BuscarClienteDTO>buscarClienteId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    @Operation(summary = "endpoint responsável por atualizar cliente.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AtualizarClienteDTO>atualizar(@PathVariable Long id,@RequestBody AtualizarClienteDTO dto){
        return ResponseEntity.ok(clienteService.atualizarCliente(id,dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsável por excluir cliente.")
    @ApiResponse(responseCode = "204", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
