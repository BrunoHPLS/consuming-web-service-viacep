package com.example.consumingrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Localizacao {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Long ibge;
    private String gia;
    private Integer ddd;
    private Integer siafi;

    public Localizacao(){}

    @Override
    public String toString() {
        return String.format("\nLocalização={cep: %s,logradouro: %s,complemento: %s,bairro: %s,localidade: %s,uf: %s,ibge: %d,gia: %s,ddd: %d,siafi: %d}\n",
                cep,logradouro,complemento,bairro,localidade,uf,ibge,gia,ddd,siafi);
    }
}
