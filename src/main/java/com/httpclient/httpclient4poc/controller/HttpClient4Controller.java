package com.httpclient.httpclient4poc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.httpclient.httpclient4poc.dto.AcompanhamentoDTO;
import com.httpclient.httpclient4poc.dto.AvaliacaoDTO;
import com.httpclient.httpclient4poc.exception.NegocioException;
import com.httpclient.httpclient4poc.service.AcompanhamentoService;
import com.httpclient.httpclient4poc.service.AvaliacaoService;
import com.httpclient.httpclient4poc.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/httpClient4")
public class HttpClient4Controller {

    @Autowired
    AcompanhamentoService acompanhamentoService;

    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody
                                           @Validated(AcompanhamentoDTO.AcompanhamentoView.RegistrationPost.class)
                                           @JsonView(AcompanhamentoDTO.AcompanhamentoView.RegistrationPost.class)
                                           AcompanhamentoDTO acompanhamentoDTO){
            acompanhamentoDTO.setDataEtapa(DateUtil.getDataAtualAsString());
            acompanhamentoDTO.setDataSituacaoEtapa(DateUtil.getDataAtualAsString());
            try {
                acompanhamentoService.saveAcompanhamento(acompanhamentoDTO);
            }catch (NegocioException nex){
                log.error("Ocorreu um erro: ",nex);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nex.getMessage());
            }
            ResponseEntity<Object>  responseEntity = saveAvaliacao(acompanhamentoDTO);

       return responseEntity;

    }

    private ResponseEntity<Object> saveAvaliacao(AcompanhamentoDTO acompanhamentoDTO) {
        ResponseEntity<Object> responseEntity = avaliacaoService.saveAvaliacao(AvaliacaoDTO.builder()
                .cpfCidadao(acompanhamentoDTO.getCpfCidadao())
                .protocolo(acompanhamentoDTO.getProtocolo())
                .servico(acompanhamentoDTO.getServico())
                .build());
        return Optional.ofNullable(responseEntity).get();
    }

}
