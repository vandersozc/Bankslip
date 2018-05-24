package com.vandersoncamp.bankslip.model;import javax.persistence.*;@Entity@Table(name = "boletos")@SequenceGenerator(name = "seq_boletos", sequenceName = "seq_boletos", initialValue = 1, allocationSize = 1)public class Boleto implements EntityID {    @Id    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_boletos")    private Long id;    @Column(name = "descricao", length = 255, nullable = false)    private String descricao;    @Override    public Long getId() {        return id;    }    public String getDescricao() {        return descricao;    }    public void setDescricao(String descricao) {        this.descricao = descricao;    }}