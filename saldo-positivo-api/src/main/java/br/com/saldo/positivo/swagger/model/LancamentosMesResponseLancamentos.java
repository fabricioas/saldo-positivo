package br.com.saldo.positivo.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LancamentosMesResponseLancamentos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-15T09:42:07.118-03:00[America/Sao_Paulo]")
public class LancamentosMesResponseLancamentos   {
  @JsonProperty("id")
  private String id = null;

  /**
   * Gets or Sets tipeLancamento
   */
  public enum TipeLancamentoEnum {
    RECEITA("RECEITA"),
    
    DESPESA("DESPESA");

    private String value;

    TipeLancamentoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipeLancamentoEnum fromValue(String text) {
      for (TipeLancamentoEnum b : TipeLancamentoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("tipeLancamento")
  private TipeLancamentoEnum tipeLancamento = null;

  @JsonProperty("nmLancamento")
  private String nmLancamento = null;

  @JsonProperty("dataVencimento")
  private LocalDate dataVencimento = null;

  @JsonProperty("dataLiquidacao")
  private LocalDate dataLiquidacao = null;

  @JsonProperty("valorLancamento")
  private BigDecimal valorLancamento = null;

  @JsonProperty("valorSaldo")
  private BigDecimal valorSaldo = null;

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

  public LancamentosMesResponseLancamentos id(String id) {
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

  public LancamentosMesResponseLancamentos tipeLancamento(TipeLancamentoEnum tipeLancamento) {
    this.tipeLancamento = tipeLancamento;
    return this;
  }

  /**
   * Get tipeLancamento
   * @return tipeLancamento
  **/
  @ApiModelProperty(value = "")

  public TipeLancamentoEnum getTipeLancamento() {
    return tipeLancamento;
  }

  public void setTipeLancamento(TipeLancamentoEnum tipeLancamento) {
    this.tipeLancamento = tipeLancamento;
  }

  public LancamentosMesResponseLancamentos nmLancamento(String nmLancamento) {
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

  public LancamentosMesResponseLancamentos dataVencimento(LocalDate dataVencimento) {
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

  public LancamentosMesResponseLancamentos dataLiquidacao(LocalDate dataLiquidacao) {
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

  public LancamentosMesResponseLancamentos valorLancamento(BigDecimal valorLancamento) {
    this.valorLancamento = valorLancamento;
    return this;
  }

  /**
   * Get valorLancamento
   * @return valorLancamento
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorLancamento() {
    return valorLancamento;
  }

  public void setValorLancamento(BigDecimal valorLancamento) {
    this.valorLancamento = valorLancamento;
  }

  public LancamentosMesResponseLancamentos valorSaldo(BigDecimal valorSaldo) {
    this.valorSaldo = valorSaldo;
    return this;
  }

  /**
   * Get valorSaldo
   * @return valorSaldo
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getValorSaldo() {
    return valorSaldo;
  }

  public void setValorSaldo(BigDecimal valorSaldo) {
    this.valorSaldo = valorSaldo;
  }

  public LancamentosMesResponseLancamentos status(StatusEnum status) {
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
    LancamentosMesResponseLancamentos lancamentosMesResponseLancamentos = (LancamentosMesResponseLancamentos) o;
    return Objects.equals(this.id, lancamentosMesResponseLancamentos.id) &&
        Objects.equals(this.tipeLancamento, lancamentosMesResponseLancamentos.tipeLancamento) &&
        Objects.equals(this.nmLancamento, lancamentosMesResponseLancamentos.nmLancamento) &&
        Objects.equals(this.dataVencimento, lancamentosMesResponseLancamentos.dataVencimento) &&
        Objects.equals(this.dataLiquidacao, lancamentosMesResponseLancamentos.dataLiquidacao) &&
        Objects.equals(this.valorLancamento, lancamentosMesResponseLancamentos.valorLancamento) &&
        Objects.equals(this.valorSaldo, lancamentosMesResponseLancamentos.valorSaldo) &&
        Objects.equals(this.status, lancamentosMesResponseLancamentos.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipeLancamento, nmLancamento, dataVencimento, dataLiquidacao, valorLancamento, valorSaldo, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LancamentosMesResponseLancamentos {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipeLancamento: ").append(toIndentedString(tipeLancamento)).append("\n");
    sb.append("    nmLancamento: ").append(toIndentedString(nmLancamento)).append("\n");
    sb.append("    dataVencimento: ").append(toIndentedString(dataVencimento)).append("\n");
    sb.append("    dataLiquidacao: ").append(toIndentedString(dataLiquidacao)).append("\n");
    sb.append("    valorLancamento: ").append(toIndentedString(valorLancamento)).append("\n");
    sb.append("    valorSaldo: ").append(toIndentedString(valorSaldo)).append("\n");
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
