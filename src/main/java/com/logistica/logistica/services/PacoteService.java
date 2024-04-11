package com.logistica.logistica.services;

import com.logistica.logistica.dto.PacoteDTO;
import com.logistica.logistica.dto.PagamentoPacotesDTO;
import com.logistica.logistica.enums.TipoPagamento;
import com.logistica.logistica.enums.TipoZona;
import com.logistica.logistica.models.Destinatario;
import com.logistica.logistica.models.Pacote;
import com.logistica.logistica.models.Zona;
import com.logistica.logistica.repositories.IDestinatarioRepository;
import com.logistica.logistica.repositories.IPacoteRepository;
import com.logistica.logistica.repositories.IZonaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class PacoteService {
    @Autowired
    private IPacoteRepository pacoteRepository;

    @Autowired
    private IZonaRepository zonaRepository;

    @Autowired
    private IDestinatarioRepository destinatarioRepository;

    public Pacote inserir(PacoteDTO dto) {
        var pacote = new Pacote();
        BeanUtils.copyProperties(dto, pacote);
        associarDestinatario(dto.fkDestinatario(), pacote);
        associarZona(pacote);
        return pacoteRepository.save(pacote);
    }

    public Pacote atualizar(Pacote pacote){
        return pacoteRepository.save(pacote);
    }

    public Page<Pacote> listarTodos(Pageable pageable){
        return pacoteRepository.findAll(pageable);
    }

    public Optional<Pacote> listarPorId(UUID idPacote){
        return pacoteRepository.findById(idPacote);
    }

    public void deletarPorId(UUID id){
        pacoteRepository.deleteById(id);
    }

    private void associarZona(Pacote pacote) {
        int cep = Integer.parseInt(pacote.getDestinatario().getCepDestinatario().substring(0, 5));
        Zona zona = zonaRepository.findByCep(cep);
        pacote.setZona(zona);
    }

    private void associarDestinatario(UUID idDestinatario, Pacote pacote){
        Optional<Destinatario> destinatarioOpt = destinatarioRepository.findById(idDestinatario);
        if(destinatarioOpt.isEmpty()) return;
        var destinatario = destinatarioOpt.get();
        pacote.setDestinatario(destinatario);
    }

    public List<Pacote> listarPacotesParaPagar(PagamentoPacotesDTO pagamento){
        List<Pacote> pacotesEntregues = pacoteRepository.findPackagesForPayment(pagamento.fkFuncionario());
        TipoPagamento tipoPagamento = TipoPagamento.valueOf(pagamento.idTipoPagamento());
        confirmarPagamentoEntregas(pacotesEntregues);

        return pacotesEntregues.stream()
                    .filter(tipoPagamento == TipoPagamento.ZONA_NOVA
                            ? pacote -> pacote.getZona().getTipoZona() == TipoZona.ZONA_NOVA
                            : pacote -> pacote.getZona().getTipoZona() == TipoZona.ZONA_NORMAL)
                    .toList();
    }


    public void confirmarPagamentoEntregas(List<Pacote> pacotes) {
        for(Pacote pacote : pacotes){
            pacote.setPagamentoFeito(true);
            pacoteRepository.save(pacote);
        }
    }
}
