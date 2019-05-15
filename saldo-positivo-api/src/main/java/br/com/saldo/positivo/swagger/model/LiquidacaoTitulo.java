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
 * LiquidacaoTitulo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-15T09:42:07.118-03:00[America/Sao_Paulo]")
public class LiquidacaoTitulo   {
  @JsonProperty("dataLiquidacao")
  private LocalDate dataLiquidacao = null;

  @JsonProperty("valorTitulo")
  private BigDecimal valorTitulo = null;

  @JsonProperty("valorPago")
  private BigDecimal valorPago = null;

  public LiquidacaoTitulo dataLiquidacao(LocalDate dataLiquidacao) {
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

  public LiquidacaoTitulo valorTitulo(BigDecimal valorTitulo) {
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

  public LiquidacaoTitulo valorPago(BigDecimal valorPago) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiquidacaoTitulo liquidacaoTitulo = (LiquidacaoTitulo) o;
    return Objects.equals(this.dataLiquidacao, liquidacaoTitulo.dataLiquidacao) &&
        Objects.equals(this.valorTitulo, liquidacaoTitulo.valorTitulo) &&
        Objects.equals(this.valorPago, liquidacaoTitulo.valorPago);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataLiquidacao, valorTitulo, valorPago);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiquidacaoTitulo {\n");
    
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
