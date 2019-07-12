import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { LancamentoTitulo } from './LancamentoTitulo';
import { LancamentoTituloService } from './LancamentoTitulo.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';

const RECEBIMENTO = [
  { value: 1, name: "Recebimento" },
]

const PAGAMENTO = [
  { value: 2, name: "Gasto Fixo" },
  { value: 3, name: "Gasto Periódico" },
  { value: 4, name: "Cartão de Credito" },
]

const INVESTIMENTO = [
  { value: 5, name: "Aporte" },
  { value: 6, name: "Resgate" },
  { value: 7, name: "Desembolso" },
]

@Component({
  selector: 'app-lancamento-titulo',
  templateUrl: './lancamento-titulo.component.html',
  styleUrls: ['./lancamento-titulo.component.css']
})
export class LancamentoTituloComponent implements OnInit {
  lancamentoGroup: FormGroup;
  tiposLancamentos;
  descricaoCategoria;
  private categoriaLancamento;
  private titulo: LancamentoTitulo;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<LancamentoTituloComponent>,
    private service: LancamentoTituloService,
    private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.lancamentoGroup = this.formBuilder.group({
      classeLancamento: ['', Validators.required],
      nmLancamento: ['', [Validators.required, Validators.maxLength(100)]],
      diaVencimento: ['', [Validators.required, Validators.maxLength(2)]],
      valorPlanejado: ['', [Validators.required, Validators.maxLength(10)]],
      valorEfetivo: ['', [Validators.maxLength(10)]],
    });
    if (this.data.categoriaLancamento == 1) {
      this.tiposLancamentos = RECEBIMENTO;
      this.descricaoCategoria = "Recebimento";
    } else if (this.data.categoriaLancamento == 2) {
      this.tiposLancamentos = PAGAMENTO;
      this.descricaoCategoria = "Pagamento";
    } else if (this.data.categoriaLancamento == 3) {
      this.tiposLancamentos = INVESTIMENTO;
      this.descricaoCategoria = "Investimento";
    }
    this.lancamentoGroup.get("classeLancamento").setValue(this.data.classeLancamento);
    this.lancamentoGroup.get("nmLancamento").setValue(this.data.nmLancamento);
    this.lancamentoGroup.get("diaVencimento").setValue(this.data.diaVencimento);
    this.lancamentoGroup.get("valorPlanejado").setValue(this.data.valorPlanejado);
    this.lancamentoGroup.get("valorEfetivo").setValue(this.data.valorEfetivo);
  }

  salvar() {
    if (this.lancamentoGroup.valid) {
      let titulo: LancamentoTitulo = {
        id: this.data.id,
        categoriaLancamento: this.data.categoriaLancamento,
        classeLancamento: this.lancamentoGroup.get("classeLancamento").value,
        nmLancamento: this.lancamentoGroup.get("nmLancamento").value,
        valorPlanejado: this.lancamentoGroup.get("valorPlanejado").value,
        valorEfetivo: this.lancamentoGroup.get("valorEfetivo").value,
        diaVencimento: this.lancamentoGroup.get("diaVencimento").value,
        mesVencimento: this.data.mesVencimento,
        anoVencimento: this.data.anoVencimento,
        dataPagamento: this.data.dataPagamento,
        statusLancamento: this.data.statusLancamento
      }
      this.service.salvar(titulo).subscribe(data => {
        this.dialogRef.close(true);
      });
    }

  }
}