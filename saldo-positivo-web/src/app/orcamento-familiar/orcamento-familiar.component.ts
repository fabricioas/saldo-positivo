import { Component, OnInit } from '@angular/core';
import {OrcamentoFamiliarService} from '../OrcamentoFamiliar.service';
import {MatDialog} from '@angular/material/dialog';
import {LancamentoTituloComponent} from '../lancamento-titulo/lancamento-titulo.component';
@Component({
  selector: 'app-orcamento-familiar',
  templateUrl: './orcamento-familiar.component.html',
  styleUrls: ['./orcamento-familiar.component.css']
})

export class OrcamentoFamiliarComponent implements OnInit {
  recebimentoDataSet;
  gastosFixosDataSet;
  gastosPeriodicosDataSet;
  mes="Maio";
  ano="2019";
 
  constructor(private service : OrcamentoFamiliarService, private dialog: MatDialog) {}
  ngOnInit() {
    this.service.getTitulosRecebimento(1,2019).subscribe( data =>{
      this.recebimentoDataSet = data;    
    })
    this.gastosFixosDataSet = this.service.getTitulosGastosFixos(1,2019);    
    this.gastosPeriodicosDataSet = this.service.getTitulosGastosPeriodicos(1,2019);    
  }

  getTotalPlanejado() {
    if( this.recebimentoDataSet){
      return this.recebimentoDataSet.map(t => t.valorPlanejado).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }

  getTotalPago() {
    if( this.recebimentoDataSet){
      return this.recebimentoDataSet.map(t => t.valorEfetivo).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }

  openLancamentos(): void {
    const dialogRef = this.dialog.open(LancamentoTituloComponent, {
      width: '500px',
      data: {}
    });

  }

}

