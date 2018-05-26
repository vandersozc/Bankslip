package com.vandersoncamp.bankslip.business.validate;import com.vandersoncamp.bankslip.model.Boleto;import com.vandersoncamp.bankslip.util.exception.BusinessException;import javax.enterprise.context.RequestScoped;@RequestScopedpublic class BoletoValidate {    public void validate(Boleto boleto) {        if (boleto.getDue_date() == null) {            throw new BusinessException("Não foi informada a data de vencimento do boleto");        }        if (boleto.getTotal_in_cents() == null) {            throw new BusinessException("Não foi informado valor para o boleto");        }        if (boleto.getCustomer() == null) {            throw new BusinessException("Não foi informado o pagador do boleto");        }        if (boleto.getStatus() == null) {            throw new BusinessException("Não foi informada a situação do boleto");        }        if (boleto.getId() == null) {            throw new BusinessException("Identificador do boleto não pode ser nulo");        }        if (boleto.getId().length() != 36) {            throw new BusinessException("Identificador do boleto incorreto");        }    }}