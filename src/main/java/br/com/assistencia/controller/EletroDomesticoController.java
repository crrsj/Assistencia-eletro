package br.com.assistencia.controller;

import br.com.assistencia.dto.AtualizarEletroDTO;
import br.com.assistencia.dto.EletrodomesticoDTO;
import br.com.assistencia.service.EletroDomesticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/eletrodomesticos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EletroDomesticoController {

    private final EletroDomesticoService servico;

    @PostMapping("/{clienteId}")
    @Operation(summary = "endpoint responsável por cadastrar eletro.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<EletrodomesticoDTO>salvarEletro(@PathVariable Long clienteId, @RequestBody EletrodomesticoDTO dto){
        var salvar = servico.salvarEletro(clienteId,dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
             .path("/{id}").buildAndExpand(salvar.getId()).toUri();
        return ResponseEntity.created(uri).body(salvar);
    }

    @GetMapping
    @Operation(summary = "endpoint responsável por listar eletros.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Page<EletrodomesticoDTO>>listarEletros(Pageable pageable){
        Page<EletrodomesticoDTO> buscar = servico.listarEletro(pageable);
        return ResponseEntity.ok(buscar);
    }

    @PutMapping("/{id}")
    @Operation(summary = "endpoint responsável por atualizar eletro.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AtualizarEletroDTO> atualizarEletro(@PathVariable Long id, @RequestBody AtualizarEletroDTO atualizarEletroDTO){
        return ResponseEntity.ok(servico.atualizarEletro(id,atualizarEletroDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "endpoint responsável por buscar eletro pelo id.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<EletrodomesticoDTO>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(servico.buscarPorId(id));
    }

    @GetMapping("/buscarOrdem")
    @Operation(summary = "endpoint responsável por buscar eletro por ordem de serviço.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<EletrodomesticoDTO>buscarOrdemServico(@RequestParam Integer ordemServico){
        return ResponseEntity.ok(servico.buscarPorOs(ordemServico));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "endpoint responsável por atualizar status do serviço.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>cancelarServico(@PathVariable Long id ){
        servico.cancelarServico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsável por excluir eletro pelo id.")
    @ApiResponse(responseCode = "204", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirEletro(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
