package br.com.assistencia.service;

import br.com.assistencia.dto.AtualizarEletroDTO;
import br.com.assistencia.enums.StatusServico;
import br.com.assistencia.repository.EletroDomesticoRepository;
import br.com.assistencia.dto.EletrodomesticoDTO;
import br.com.assistencia.entity.EletroDomestico;
import br.com.assistencia.exceptions.ClienteNaoEncontrado;
import br.com.assistencia.exceptions.EletroNaoEncontrado;
import br.com.assistencia.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EletroDomesticoService {

    private final ClienteRepository clienteRepository;
    private final EletroDomesticoRepository eletroDomesticoRepository;
    private final ModelMapper modelMapper;

    public EletrodomesticoDTO salvarEletro(Long clienteId,EletrodomesticoDTO eletrodomesticoDTO){
        var cliente = clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontrado::new);
        var eletro  = modelMapper.map(eletrodomesticoDTO, EletroDomestico.class);
        eletro.setCliente(cliente);
        var eletroSalvo = eletroDomesticoRepository.save(eletro);
        return modelMapper.map(eletroSalvo, EletrodomesticoDTO.class);
    }

    public Page<EletrodomesticoDTO> listarEletro(Pageable pageable){
        return eletroDomesticoRepository.findAll(pageable)
                .map(eletro->modelMapper
                 .map(eletro, EletrodomesticoDTO.class));
    }

    public EletrodomesticoDTO buscarPorOs(Integer ordemServico){
        var buscar = eletroDomesticoRepository.findByOrdemServico(ordemServico).orElseThrow(EletroNaoEncontrado::new);
        return modelMapper.map(buscar, EletrodomesticoDTO.class);
    }

    public EletrodomesticoDTO buscarPorId(Long id){
        var buscarEletro = eletroDomesticoRepository.findById(id).orElseThrow(EletroNaoEncontrado::new);
        return modelMapper.map(buscarEletro, EletrodomesticoDTO.class);
    }

    @Transactional
    public AtualizarEletroDTO atualizarEletro(Long id, AtualizarEletroDTO atualizarEletroDTO){
        var buscarEletro = eletroDomesticoRepository.findById(id).orElseThrow(EletroNaoEncontrado::new);
        modelMapper.map(atualizarEletroDTO,buscarEletro);
        var eletroSalvo = eletroDomesticoRepository.save(buscarEletro);
        return modelMapper.map(eletroSalvo, AtualizarEletroDTO.class);
    }

    public void excluirEletro(Long id){
        var eletro = eletroDomesticoRepository.findById(id).orElseThrow(EletroNaoEncontrado::new);
        eletroDomesticoRepository.delete(eletro);
    }

    public void cancelarServico(Long id){
        var cancelar = eletroDomesticoRepository.findById(id).orElseThrow(EletroNaoEncontrado::new);
        cancelar.setStatus(StatusServico.CANCELADO);
        eletroDomesticoRepository.save(cancelar);

    }
}
