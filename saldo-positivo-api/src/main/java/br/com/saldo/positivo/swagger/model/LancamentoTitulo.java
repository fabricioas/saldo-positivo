package br.com.saldo.positivo.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LancamentoTitulo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-13T12:56:36.475-03:00[America/Sao_Paulo]")
public class LancamentoTitulo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("descricao")
  private String descricao = null;

  @JsonProperty("tipo")
  private String tipo = null;

  @JsonProperty("mes")
  private Integer mes = null;

  @JsonProperty("ano")
  private Integer ano = null;

  @JsonProperty("dataVencimento")
  private LocalDate dataVencimento = null;

  @JsonProperty("dataLiquidacao")
  private LocalDate dataLiquidacao = null;

  @JsonProperty("valorTitulo")
  private Float valorTitulo = null;

  @JsonProperty("valorPago")
  private Float valorPago = null;

  public LancamentoTitulo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LancamentoTitulo descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
  **/
  @ApiModelProperty(value = "")

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LancamentoTitulo tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  @ApiModelProperty(value = "")

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public LancamentoTitulo mes(Integer mes) {
    this.mes = mes;
    return this;
  }

  /**
   * Get mes
   * @return mes
  **/
  @ApiModelProperty(value = "")

  public Integer getMes() {
    return mes;
  }

  public void setMes(Integer mes) {
    this.mes = mes;
  }

  public LancamentoTitulo ano(Integer ano) {
    this.ano = ano;
    return this;
  }

  /**
   * Get ano
   * @return ano
  **/
  @ApiModelProperty(value = "")

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public LancamentoTitulo dataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
    return this;
  }

  /**
   * Get dataVencimento
   * @return dataVencimento
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public LancamentoTitulo dataLiquidacao(LocalDate dataLiquidacao) {
    this.dataLiquidacao = dataLiquidacao;
    return this;
  }

  /**
   * Get dataLiquidacao
   * @return dataLiquidacao
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getDataLiquidacao() {
    return dataLiquidacao;
  }

  public void setDataLiquidacao(LocalDate dataLiquidacao) {
    this.dataLiquidacao = dataLiquidacao;
  }

  public LancamentoTitulo valorTitulo(Float valorTitulo) {
    this.valorTitulo = valorTitulo;
    return this;
  }

  /**
   * Get valorTitulo
   * @return valorTitulo
  **/
  @ApiModelProperty(value = "")

  public Float getValorTitulo() {
    return valorTitulo;
  }

  public void setValorTitulo(Float valorTitulo) {
    this.valorTitulo = valorTitulo;
  }

  public LancamentoTitulo valorPago(Float valorPago) {
    this.valorPago = valorPago;
    return this;
  }

  /**
   * Get valorPago
   * @return valorPago
  **/
  @ApiModelProperty(value = "")

  public Float getValorPago() {
    return valorPago;
  }

  public void setValorPago(Float valorPago) {
    this.valorPago = valorPago;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LancamentoTitulo lancamentoTitulo = (LancamentoTitulo) o;
    return Objects.equals(this.id, lancamentoTitulo.id) &&
        Objects.equals(this.descricao, lancamentoTitulo.descricao) &&
        Objects.equals(this.tipo, lancamentoTitulo.tipo) &&
        Objects.equals(this.mes, lancamentoTitulo.mes) &&
        Objects.equals(this.ano, lancamentoTitulo.ano) &&
        Objects.equals(this.dataVencimento, lancamentoTitulo.dataVencimento) &&
        Objects.equals(this.dataLiquidacao, lancamentoTitulo.dataLiquidacao) &&
        Objects.equals(this.valorTitulo, lancamentoTitulo.valorTitulo) &&
        Objects.equals(this.valorPago, lancamentoTitulo.valorPago);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, descricao, tipo, mes, ano, dataVencimento, dataLiquidacao, valorTitulo, valorPago);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LancamentoTitulo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    mes: ").append(toIndentedString(mes)).append("\n");
    sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
    sb.append("    dataVencimento: ").append(toIndentedString(dataVencimento)).append("\n");
    sb.append("    dataLiquidacao: ").append(toIndentedString(dataLiquidacao)).append("\n");
    sb.append("    valorTitulo: ").append(toIndentedString(valorTitulo)).append("\n");
    sb.append("    valorPago: ").append(toIndentedString(valorPago)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
