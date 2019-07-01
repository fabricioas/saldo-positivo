import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { LancamentoTitulo } from './LancamentoTitulo';
import { LancamentoTituloService } from './LancamentoTitulo.service';
import { FormControl, FormGroup, Validators,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-lancamento-titulo',
  templateUrl: './lancamento-titulo.component.html',
  styleUrls: ['./lancamento-titulo.component.css']
})
export class LancamentoTituloComponent implements OnInit {
  lancamentoGroup: FormGroup;
 
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: LancamentoTitulo,
    public dialogRef: MatDialogRef<LancamentoTituloComponent>,
    private service: LancamentoTituloService,
    private formBuilder: FormBuilder) {}

    ngOnInit() {
      this.lancamentoGroup = this.formBuilder.group({
        nmLancamento: ['', [Validators.required, Validators.maxLength(100)]],
        valorPlanejado: ['', [Validators.required, Validators.maxLength(10)]],
        valorEfetivo: ['', [Validators.required, Validators.maxLength(10)]],
        diaVencimento: ['', [Validators.required, Validators.maxLength(2)]],
        mesVencimento: ['', [Validators.required, Validators.maxLength(2)]],
        anoVencimento: ['', [Validators.required, Validators.maxLength(4)]],
      });
    }

    salvar(){
      this.lancamentoGroup.get("diaVencimento").setValue(10);
      this.lancamentoGroup.get("mesVencimento").setValue(6);
      this.lancamentoGroup.get("anoVencimento").setValue(2019);
      if( this.lancamentoGroup.valid){
        this.service.salvar(this.lancamentoGroup.value).subscribe( data => {
          this.dialogRef.close();
        } );
      }

    }
}