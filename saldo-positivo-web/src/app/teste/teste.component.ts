import { Component, OnInit } from '@angular/core';
import {OrcamentoFamiliarService} from '../OrcamentoFamiliar.service';

@Component({
  selector: 'app-teste',
  templateUrl: './teste.component.html',
  styleUrls: ['./teste.component.css']
})
export class TesteComponent implements OnInit {
  recebimentoDataSet;
  mes="Maio";
  ano="2019";
  displayedColumns = ["diaVencimento","nmLancamento","valorPlanejado","valorPago"];
  constructor(private service : OrcamentoFamiliarService) {}
  ngOnInit() {
    this.service.getTitulos(1,2019).subscribe( result => {
      this.recebimentoDataSet = result;
    });    
  }

  getTotalPlanejado() {
    if( this.recebimentoDataSet){
      return this.recebimentoDataSet.map(t => t.valorPlanejado).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }

  getTotalPago() {
    if( this.recebimentoDataSet){
      return this.recebimentoDataSet.map(t => t.valorPago).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }
}
