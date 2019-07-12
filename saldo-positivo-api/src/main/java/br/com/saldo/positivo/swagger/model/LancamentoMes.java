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
 * LancamentoMes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-11T10:58:41.180673-03:00[America/Sao_Paulo]")
public class LancamentoMes   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("categoriaLancamento")
  private Integer categoriaLancamento = null;

  @JsonProperty("classeLancamento")
  private Integer classeLancamento = null;

  @JsonProperty("nmLancamento")
  private String nmLancamento = null;

  @JsonProperty("diaVencimento")
  private Integer diaVencimento = null;

  @JsonProperty("mesVencimento")
  private Integer mesVencimento = null;

  @JsonProperty("anoVencimento")
  private Integer anoVencimento = null;

  @JsonProperty("dataPagamento")
  private LocalDate dataPagamento = null;

  @JsonProperty("valorPlanejado")
  private BigDecimal valorPlanejado = null;

  @JsonProperty("valorEfetivo")
  private BigDecimal valorEfetivo = null;

  /**
   * Gets or Sets statusLancamento
   */
  public enum StatusLancamentoEnum {
    PENDENTE("PENDENTE"),
    
    PAGO("PAGO"),
    
    ATRASADO("ATRASADO");

    private String value;

    StatusLancamentoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusLancamentoEnum fromValue(String text) {
      for (StatusLancamentoEnum b : StatusLancamentoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("statusLancamento")
  private StatusLancamentoEnum statusLancamento = null;

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

  public LancamentoMes categoriaLancamento(Integer categoriaLancamento) {
    this.categoriaLancamento = categoriaLancamento;
    return this;
  }

  /**
   * Get categoriaLancamento
   * @return categoriaLancamento
  **/
  @ApiModelProperty(value = "")

  public Integer getCategoriaLancamento() {
    return categoriaLancamento;
  }

  public void setCategoriaLancamento(Integer categoriaLancamento) {
    this.categoriaLancamento = categoriaLancamento;
  }

  public LancamentoMes classeLancamento(Integer classeLancamento) {
    this.classeLancamento = classeLancamento;
    return this;
  }

  /**
   * Get classeLancamento
   * @return classeLancamento
  **/
  @ApiModelProperty(value = "")

  public Integer getClasseLancamento() {
    return classeLancamento;
  }

  public void setClasseLancamento(Integer classeLancamento) {
    this.classeLancamento = classeLancamento;
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

  public LancamentoMes mesVencimento(Integer mesVencimento) {
    this.mesVencimento = mesVencimento;
    return this;
  }

  /**
   * Get mesVencimento
   * @return mesVencimento
  **/
  @ApiModelProperty(value = "")

  public Integer getMesVencimento() {
    return mesVencimento;
  }

  public void setMesVencimento(Integer mesVencimento) {
    this.mesVencimento = mesVencimento;
  }

  public LancamentoMes anoVencimento(Integer anoVencimento) {
    this.anoVencimento = anoVencimento;
    return this;
  }

  /**
   * Get anoVencimento
   * @return anoVencimento
  **/
  @ApiModelProperty(value = "")

  public Integer getAnoVencimento() {
    return anoVencimento;
  }

  public void setAnoVencimento(Integer anoVencimento) {
    this.anoVencimento = anoVencimento;
  }

  public LancamentoMes dataPagamento(LocalDate dataPagamento) {
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

  public LancamentoMes statusLancamento(StatusLancamentoEnum statusLancamento) {
    this.statusLancamento = statusLancamento;
    return this;
  }

  /**
   * Get statusLancamento
   * @return statusLancamento
  **/
  @ApiModelProperty(value = "")

  public StatusLancamentoEnum getStatusLancamento() {
    return statusLancamento;
  }

  public void setStatusLancamento(StatusLancamentoEnum statusLancamento) {
    this.statusLancamento = statusLancamento;
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
        Objects.equals(this.categoriaLancamento, lancamentoMes.categoriaLancamento) &&
        Objects.equals(this.classeLancamento, lancamentoMes.classeLancamento) &&
        Objects.equals(this.nmLancamento, lancamentoMes.nmLancamento) &&
        Objects.equals(this.diaVencimento, lancamentoMes.diaVencimento) &&
        Objects.equals(this.mesVencimento, lancamentoMes.mesVencimento) &&
        Objects.equals(this.anoVencimento, lancamentoMes.anoVencimento) &&
        Objects.equals(this.dataPagamento, lancamentoMes.dataPagamento) &&
        Objects.equals(this.valorPlanejado, lancamentoMes.valorPlanejado) &&
        Objects.equals(this.valorEfetivo, lancamentoMes.valorEfetivo) &&
        Objects.equals(this.statusLancamento, lancamentoMes.statusLancamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoriaLancamento, classeLancamento, nmLancamento, diaVencimento, mesVencimento, anoVencimento, dataPagamento, valorPlanejado, valorEfetivo, statusLancamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LancamentoMes {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    categoriaLancamento: ").append(toIndentedString(categoriaLancamento)).append("\n");
    sb.append("    classeLancamento: ").append(toIndentedString(classeLancamento)).append("\n");
    sb.append("    nmLancamento: ").append(toIndentedString(nmLancamento)).append("\n");
    sb.append("    diaVencimento: ").append(toIndentedString(diaVencimento)).append("\n");
    sb.append("    mesVencimento: ").append(toIndentedString(mesVencimento)).append("\n");
    sb.append("    anoVencimento: ").append(toIndentedString(anoVencimento)).append("\n");
    sb.append("    dataPagamento: ").append(toIndentedString(dataPagamento)).append("\n");
    sb.append("    valorPlanejado: ").append(toIndentedString(valorPlanejado)).append("\n");
    sb.append("    valorEfetivo: ").append(toIndentedString(valorEfetivo)).append("\n");
    sb.append("    statusLancamento: ").append(toIndentedString(statusLancamento)).append("\n");
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
