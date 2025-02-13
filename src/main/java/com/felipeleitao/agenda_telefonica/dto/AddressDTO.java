package com.felipeleitao.agenda_telefonica.dto;

import com.felipeleitao.agenda_telefonica.models.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String observacao;
    private String tipo;

    public AddressDTO(Address address){
        this.logradouro = address.getLogradouro();
        this.numero = address.getNumero();
        this.complemento = address.getComplemento();
        this.bairro = address.getBairro();
        this.cidade = address.getCidade();
        this.estado = address.getEstado();
        this.pais = address.getPais();
        this.cep = address.getCep();
        this.observacao = address.getObservacao();
        this.tipo = address.getTipo();
    }
}