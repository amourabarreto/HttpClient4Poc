package com.httpclient.httpclient4poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvaliacaoDTO {

    private String canalAvaliacao="8";

    private String canalPrestacao="1";

    private String etapa="Protocolo";

    @NotBlank
    private String protocolo;

    @NotBlank
    private String servico;

    private String orgao="382";

    @NotBlank
    private String cpfCidadao;
}
