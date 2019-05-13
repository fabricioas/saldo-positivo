package br.com.saldo.positivo.swagger.model;

import java.util.Objects;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponseLancamentos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LancamentosMesResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-13T12:56:36.475-03:00[America/Sao_Paulo]")
public class LancamentosMesResponse   {
  @JsonProperty("nmMes")
  private String nmMes = null;

  @JsonProperty("mes")
  private Integer mes = null;

  @JsonProperty("ano")
  private Integer ano = null;

  @JsonProperty("valorDespesa")
  private Float valorDespesa = null;

  @JsonProperty("valorReceita")
  private Float valorReceita = null;

  @JsonProperty("valorSobra")
  private Float valorSobra = null;

  @JsonProperty("lancamentos")
  @Valid
  private List<LancamentosMesResponseLancamentos> lancamentos = null;

  public LancamentosMesResponse nmMes(String nmMes) {
    this.nmMes = nmMes;
    return this;
  }

  /**
   * Get nmMes
   * @return nmMes
  **/
  @ApiModelProperty(value = "")

  public String getNmMes() {
    return nmMes;
  }

  public void setNmMes(String nmMes) {
    this.nmMes = nmMes;
  }

  public LancamentosMesResponse mes(Integer mes) {
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

  public LancamentosMesResponse ano(Integer ano) {
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

  public LancamentosMesResponse valorDespesa(Float valorDespesa) {
    this.valorDespesa = valorDespesa;
    return this;
  }

  /**
   * Get valorDespesa
   * @return valorDespesa
  **/
  @ApiModelProperty(value = "")

  public Float getValorDespesa() {
    return valorDespesa;
  }

  public void setValorDespesa(Float valorDespesa) {
    this.valorDespesa = valorDespesa;
  }

  public LancamentosMesResponse valorReceita(Float valorReceita) {
    this.valorReceita = valorReceita;
    return this;
  }

  /**
   * Get valorReceita
   * @return valorReceita
  **/
  @ApiModelProperty(value = "")

  public Float getValorReceita() {
    return valorReceita;
  }

  public void setValorReceita(Float valorReceita) {
    this.valorReceita = valorReceita;
  }

  public LancamentosMesResponse valorSobra(Float valorSobra) {
    this.valorSobra = valorSobra;
    return this;
  }

  /**
   * Get valorSobra
   * @return valorSobra
  **/
  @ApiModelProperty(value = "")

  public Float getValorSobra() {
    return valorSobra;
  }

  public void setValorSobra(Float valorSobra) {
    this.valorSobra = valorSobra;
  }

  public LancamentosMesResponse lancamentos(List<LancamentosMesResponseLancamentos> lancamentos) {
    this.lancamentos = lancamentos;
    return this;
  }

  public LancamentosMesResponse addLancamentosItem(LancamentosMesResponseLancamentos lancamentosItem) {
    if (this.lancamentos == null) {
      this.lancamentos = new ArrayList<>();
    }
    this.lancamentos.add(lancamentosItem);
    return this;
  }

  /**
   * Get lancamentos
   * @return lancamentos
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<LancamentosMesResponseLancamentos> getLancamentos() {
    return lancamentos;
  }

  public void setLancamentos(List<LancamentosMesResponseLancamentos> lancamentos) {
    this.lancamentos = lancamentos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LancamentosMesResponse lancamentosMesResponse = (LancamentosMesResponse) o;
    return Objects.equals(this.nmMes, lancamentosMesResponse.nmMes) &&
        Objects.equals(this.mes, lancamentosMesResponse.mes) &&
        Objects.equals(this.ano, lancamentosMesResponse.ano) &&
        Objects.equals(this.valorDespesa, lancamentosMesResponse.valorDespesa) &&
        Objects.equals(this.valorReceita, lancamentosMesResponse.valorReceita) &&
        Objects.equals(this.valorSobra, lancamentosMesResponse.valorSobra) &&
        Objects.equals(this.lancamentos, lancamentosMesResponse.lancamentos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nmMes, mes, ano, valorDespesa, valorReceita, valorSobra, lancamentos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LancamentosMesResponse {\n");
    
    sb.append("    nmMes: ").append(toIndentedString(nmMes)).append("\n");
    sb.append("    mes: ").append(toIndentedString(mes)).append("\n");
    sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
    sb.append("    valorDespesa: ").append(toIndentedString(valorDespesa)).append("\n");
    sb.append("    valorReceita: ").append(toIndentedString(valorReceita)).append("\n");
    sb.append("    valorSobra: ").append(toIndentedString(valorSobra)).append("\n");
    sb.append("    lancamentos: ").append(toIndentedString(lancamentos)).append("\n");
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
