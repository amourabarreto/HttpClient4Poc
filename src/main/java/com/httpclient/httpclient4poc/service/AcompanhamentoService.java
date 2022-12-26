package com.httpclient.httpclient4poc.service;

import com.httpclient.httpclient4poc.dto.AcompanhamentoDTO;
import com.httpclient.httpclient4poc.exception.NegocioException;

public interface AcompanhamentoService {
    void saveAcompanhamento(AcompanhamentoDTO acompanhamentoDTO) throws NegocioException;
}
