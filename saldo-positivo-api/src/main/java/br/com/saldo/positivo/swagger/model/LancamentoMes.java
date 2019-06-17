package br.com.saldo.positivo.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LancamentoMes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-16T21:10:59.863-03:00[America/Sao_Paulo]")
public class LancamentoMes   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nmLancamento")
  private String nmLancamento = null;

  @JsonProperty("diaVencimento")
  private Integer diaVencimento = null;

  @JsonProperty("valorPlanejado")
  private BigDecimal valorPlanejado = null;

  @JsonProperty("valorEfetivo")
  private BigDecimal valorEfetivo = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDENTE("PENDENTE"),
    
    PAGO("PAGO"),
    
    ATRASADO("ATRASADO");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  public LancamentoMes id(String id) {
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

  public LancamentoMes nmLancamento(String nmLancamento) {
    this.nmLancamento = nmLancamento;
    return this;
  }

  /**
   * Get nmLancamento
   * @return nmLancamento
  **/
  @ApiModelProperty(value = "")

  public String getNmLancamento() {
    return nmLancamento;
  }

  public void setNmLancamento(String nmLancamento) {
    this.nmLancamento = nmLancamento;
  }

  public LancamentoMes diaVencimento(Integer diaVencimento) {
    this.diaVencimento = diaVencimento;
    return this;
  }

  /**
   * Get diaVencimento
   * @return diaVencimento
  **/
  @ApiModelProperty(value = "")

  public Integer getDiaVencimento() {
    return diaVencimento;
  }

  public void setDiaVencimento(Integer diaVencimento) {
    this.diaVencimento = diaVencimento;
  }

  public LancamentoMes valorPlanejado(BigDecimal valorPlanejado) {
    this.valorPlanejado = valorPlanejado;
    return this;
  }

  /**
   * Get valorPlanejado
   * @return valorPlanejado
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorPlanejado() {
    return valorPlanejado;
  }

  public void setValorPlanejado(BigDecimal valorPlanejado) {
    this.valorPlanejado = valorPlanejado;
  }

  public LancamentoMes valorEfetivo(BigDecimal valorEfetivo) {
    this.valorEfetivo = valorEfetivo;
    return this;
  }

  /**
   * Get valorEfetivo
   * @return valorEfetivo
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorEfetivo() {
    return valorEfetivo;
  }

  public void setValorEfetivo(BigDecimal valorEfetivo) {
    this.valorEfetivo = valorEfetivo;
  }

  public LancamentoMes status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LancamentoMes lancamentoMes = (LancamentoMes) o;
    return Objects.equals(this.id, lancamentoMes.id) &&
        Objects.equals(this.nmLancamento, lancamentoMes.nmLancamento) &&
        Objects.equals(this.diaVencimento, lancamentoMes.diaVencimento) &&
        Objects.equals(this.valorPlanejado, lancamentoMes.valorPlanejado) &&
        Objects.equals(this.valorEfetivo, lancamentoMes.valorEfetivo) &&
        Objects.equals(this.status, lancamentoMes.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nmLancamento, diaVencimento, valorPlanejado, valorEfetivo, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LancamentoMes {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nmLancamento: ").append(toIndentedString(nmLancamento)).append("\n");
    sb.append("    diaVencimento: ").append(toIndentedString(diaVencimento)).append("\n");
    sb.append("    valorPlanejado: ").append(toIndentedString(valorPlanejado)).append("\n");
    sb.append("    valorEfetivo: ").append(toIndentedString(valorEfetivo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
