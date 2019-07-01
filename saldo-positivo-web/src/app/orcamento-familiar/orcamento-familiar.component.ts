import { Component, OnInit } from '@angular/core';
import { OrcamentoFamiliarService } from '../OrcamentoFamiliar.service';
import { MatDialog } from '@angular/material/dialog';
import { LancamentoTituloComponent } from '../lancamento-titulo/lancamento-titulo.component';

class ItemSelected {
  html: HTMLElement;
  item: any;
}

@Component({
  selector: 'app-orcamento-familiar',
  templateUrl: './orcamento-familiar.component.html',
  styleUrls: ['./orcamento-familiar.component.css']
})

export class OrcamentoFamiliarComponent implements OnInit {
  recebimentoDataSet;
  gastosFixosDataSet;
  gastosPeriodicosDataSet;
  mes = "Maio";
  ano = "2019";
  private itemSelected: ItemSelected;

  constructor(private service: OrcamentoFamiliarService, private dialog: MatDialog) { }
  ngOnInit() {
    this.service.getTitulosRecebimento(2019, 6).subscribe(data => {
      this.recebimentoDataSet = data;
    })
    this.gastosFixosDataSet = this.service.getTitulosGastosFixos(1, 2019);
    this.gastosPeriodicosDataSet = this.service.getTitulosGastosPeriodicos(1, 2019);
  }

  getTotalPlanejado() {
    if (this.recebimentoDataSet) {
      return this.recebimentoDataSet.map(t => t.valorPlanejado).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }

  getTotalPago() {
    if (this.recebimentoDataSet) {
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

  onSelect(event: Event, item: any) {
    if (this.itemSelected) {
      this.selectClear(this.itemSelected);
    }else{
      this.itemSelected = new ItemSelected();
    }
    if (this.itemSelected.html != <HTMLElement>event.currentTarget) {
      this.itemSelected = { html: <HTMLElement>event.currentTarget, item: item };
      this.select(this.itemSelected.html);
    }else{
      this.itemSelected = new ItemSelected();
    }
  }

  select(tr: HTMLElement) {
    tr.setAttribute("selected", "");
  }

  selectClear(item: ItemSelected) {
    if( item.html ){
      item.html.removeAttribute("selected");
    }
  }
}

