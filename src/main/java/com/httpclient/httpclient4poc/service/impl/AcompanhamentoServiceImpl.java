package com.httpclient.httpclient4poc.service.impl;

import com.httpclient.httpclient4poc.dto.AcompanhamentoDTO;
import com.httpclient.httpclient4poc.exception.NegocioException;
import com.httpclient.httpclient4poc.service.AcompanhamentoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    @Value("${url.ambienteApiAcompanhamento}")
    String URL;

    @Autowired
    private HttpPost httpPost;

    @Override
    public void saveAcompanhamento(AcompanhamentoDTO acompanhamentoDTO) throws NegocioException {
        try {
            httpPost.setURI(new URI(URL));
            httpPost.setEntity(new StringEntity(acompanhamentoDTO.toString(), ContentType.APPLICATION_JSON));
            HttpClient instance =
                    HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
            HttpResponse response = instance.execute(httpPost);

            String retorno = EntityUtils.toString(response.getEntity());

            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                log.debug(response.getStatusLine().getStatusCode() + " \"Não foi possível cadastrar o acompanhamento!\"");
                throw new NegocioException("Não foi possível cadastrar o acompanhamento! " + retorno);
            }

        } catch (IOException | URISyntaxException e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
