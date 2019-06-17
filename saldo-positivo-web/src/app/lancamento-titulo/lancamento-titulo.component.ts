import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { LancamentoTitulo } from './LancamentoTitulo';
import { LancamentoTituloService } from './LancamentoTitulo.service';
;
@Component({
  selector: 'app-lancamento-titulo',
  templateUrl: './lancamento-titulo.component.html',
  styleUrls: ['./lancamento-titulo.component.css']
})
export class LancamentoTituloComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: LancamentoTitulo,
    public dialogRef: MatDialogRef<LancamentoTituloComponent>,
    private service: LancamentoTituloService) {}

    ngOnInit() {
    }

    salvar(){
      this.service.salvar(this.data).subscribe( data => {
        this.dialogRef.close();
      } );
    }
}