import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { LancamentoTituloService } from '../lancamento-titulo/LancamentoTitulo.service';
import {PagamentoTitulo} from "./PagamentoTitulo"
import { FormGroup, Validators,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-pagamento-titulo',
  templateUrl: './pagamento-titulo.component.html',
  styleUrls: ['./pagamento-titulo.component.css']
})
export class PagamentoTituloComponent implements OnInit {
  pagamentoGroup: FormGroup;
  descricaoCategoria;
  nmLancamento: string;
  valorTitulo: string;
  private categoriaLancamento;


  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<PagamentoTituloComponent>,
    private service: LancamentoTituloService,
    private formBuilder: FormBuilder) {
      this.categoriaLancamento = data.categoria;
      this.pagamentoGroup = this.formBuilder.group({
        valorPago: ['',[Validators.required, Validators.maxLength(100)]],
        dataPagamento: ['',[Validators.required, Validators.maxLength(8)]],
      });
    }

    ngOnInit() {
      this.nmLancamento = this.data.nmLancamento;
      this.valorTitulo = this.data.valorTitulo;
      this.pagamentoGroup.get("dataPagamento").setValue(this.data.dataPagamento);
      this.pagamentoGroup.get("valorPago").setValue(this.data.valorPago);
    }

    pagar(){
      if( this.pagamentoGroup.valid){
        let pagamentoTitulo: PagamentoTitulo = {
          id: this.data.id,
          dataPagamento: this.pagamentoGroup.get("dataPagamento").value,
          valorPago: this.pagamentoGroup.get("valorPago").value,
          valorTitulo: null
        }
        this.service.pagar(pagamentoTitulo).subscribe( data => {
          this.dialogRef.close(true);
        } );
      }

    }

}
