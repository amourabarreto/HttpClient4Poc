package com.httpclient.httpclient4poc.service;


import com.httpclient.httpclient4poc.config.FeignConfig;
import com.httpclient.httpclient4poc.dto.AvaliacaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url="${url.ambienteApiAvaliacao}", name = "avaliacao", configuration = FeignConfig.class)
public interface AvaliacaoService {

    @PostMapping(value = "/formulario")
    ResponseEntity<Object> saveAvaliacao(@RequestBody
                                            @Valid AvaliacaoDTO avaliacaoDTO);

}
