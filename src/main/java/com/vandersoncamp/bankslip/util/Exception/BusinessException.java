package com.vandersoncamp.bankslip.util.Exception;import javax.ejb.ApplicationException;import javax.ws.rs.WebApplicationException;import javax.xml.bind.annotation.XmlRootElement;@XmlRootElement(name = "BusinessException")@ApplicationException(rollback = true)public class BusinessException extends WebApplicationException {    private static final long serialVersionUID = 1L;    public BusinessException(String message) {        super(message, 422);    }}