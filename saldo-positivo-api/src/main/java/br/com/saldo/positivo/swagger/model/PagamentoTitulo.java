package br.com.saldo.positivo.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PagamentoTitulo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-11T10:58:41.180673-03:00[America/Sao_Paulo]")
public class PagamentoTitulo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("dataPagamento")
  private LocalDate dataPagamento = null;

  @JsonProperty("valorPago")
  private BigDecimal valorPago = null;

  @JsonProperty("valorTitulo")
  private BigDecimal valorTitulo = null;

  public PagamentoTitulo id(String id) {
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

  public PagamentoTitulo dataPagamento(LocalDate dataPagamento) {
    this.dataPagamento = dataPagamento;
    return this;
  }

  /**
   * Get dataPagamento
   * @return dataPagamento
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(LocalDate dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public PagamentoTitulo valorPago(BigDecimal valorPago) {
    this.valorPago = valorPago;
    return this;
  }

  /**
   * Get valorPago
   * @return valorPago
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorPago() {
    return valorPago;
  }

  public void setValorPago(BigDecimal valorPago) {
    this.valorPago = valorPago;
  }

  public PagamentoTitulo valorTitulo(BigDecimal valorTitulo) {
    this.valorTitulo = valorTitulo;
    return this;
  }

  /**
   * Get valorTitulo
   * @return valorTitulo
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorTitulo() {
    return valorTitulo;
  }

  public void setValorTitulo(BigDecimal valorTitulo) {
    this.valorTitulo = valorTitulo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagamentoTitulo pagamentoTitulo = (PagamentoTitulo) o;
    return Objects.equals(this.id, pagamentoTitulo.id) &&
        Objects.equals(this.dataPagamento, pagamentoTitulo.dataPagamento) &&
        Objects.equals(this.valorPago, pagamentoTitulo.valorPago) &&
        Objects.equals(this.valorTitulo, pagamentoTitulo.valorTitulo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataPagamento, valorPago, valorTitulo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagamentoTitulo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dataPagamento: ").append(toIndentedString(dataPagamento)).append("\n");
    sb.append("    valorPago: ").append(toIndentedString(valorPago)).append("\n");
    sb.append("    valorTitulo: ").append(toIndentedString(valorTitulo)).append("\n");
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
