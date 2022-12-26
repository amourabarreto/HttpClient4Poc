package com.httpclient.httpclient4poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcompanhamentoDTO {

    public interface AcompanhamentoView {
        public static interface RegistrationPost {
        }
    }

    @NotBlank(groups = AcompanhamentoView.RegistrationPost.class)
    @JsonView(AcompanhamentoView.RegistrationPost.class)
    private String cpfCidadao;

    private String dataEtapa;

    private String dataSituacaoEtapa;


    private String etapa="Protocolo";


    private String orgao="382";


    @NotBlank(groups = AcompanhamentoView.RegistrationPost.class)
    @JsonView(AcompanhamentoView.RegistrationPost.class)
    private String protocolo;

    @NotBlank(groups = AcompanhamentoView.RegistrationPost.class)
    @JsonView(AcompanhamentoView.RegistrationPost.class)
    private String servico;


    private String situacaoEtapa="Protocolo eletrônico";

    @Override
    public String toString() {
        return "{" +
                    "\"servico\": \""+ getServico() +  "\"," +
                    "\"protocolo\": \"" + getProtocolo() +  "\"," +
                    "\"etapa\": \""+ getEtapa() +"\"," +
                    "\"dataEtapa\": \""+ getDataEtapa() +"\"," +
                    "\"situacaoEtapa\": \""+ getSituacaoEtapa() +"\"," +
                    "\"dataSituacaoEtapa\": \""+getDataSituacaoEtapa() +"\"," +
                    "\"orgao\": \""+ getOrgao()+"\"," +
                    "\"cpfCidadao\": \""+getCpfCidadao()+"\"" +
                "}";
    }
}
