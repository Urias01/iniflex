package com.iniflex.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

  public Funcionario() {
      super();
  }

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

  public int getIdade() {
    return Period.between(getDataNascimento(), LocalDate.now()).getYears();
  }

  public static String formatBirthidate(LocalDate dataAniversario) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String formattedDate = dataAniversario.format(formatter).toString();

    return formattedDate;
  }

  public static String formatBigDecimal(BigDecimal salario) {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
    symbols.setGroupingSeparator('.');
    symbols.setDecimalSeparator(',');

    DecimalFormat formatSalary = new DecimalFormat("#,##0.00", symbols);

    String formattedSalary = formatSalary.format(salario);

    return formattedSalary;
  }

  @Override
  public String toString() {
    return "Funcionario: {" +
            "id=" + id +
            " nome='" + getNome() + '\'' +
            " data nascimento='" + formatBirthidate(getDataNascimento()) + '\'' +
            " salario='" + formatBigDecimal(salario) + '\'' +
            " funcao='" + funcao + '\'' +
            '}';
  }
}
