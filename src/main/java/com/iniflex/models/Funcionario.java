package com.iniflex.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

  public static final Long serivalVersionUid = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal salario;
  private String funcao;

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return this.salario;
  }

  public String getFuncao() {
    return this.funcao;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }
  
}
