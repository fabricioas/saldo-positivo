import { Component, OnInit } from '@angular/core';
import { OrcamentoFamiliarService } from '../OrcamentoFamiliar.service';
import { MatDialog } from '@angular/material/dialog';
import { LancamentoTituloComponent } from '../lancamento-titulo/lancamento-titulo.component';
import { PagamentoTituloComponent } from '../pagamento-titulo/pagamento-titulo.component';
import { MessageService } from '../Message.service';
import {MesesService} from '../Meses.service'

class ItemSelected {
  html: HTMLElement;
  item: any;
  categoria: number;
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
  cartaoCreditoDataSet;
  aportesDataSet;
  resgatesDataSet;
  desembolsosDataSet;
  totais = { 
    recebimentos: 0,
    pagamentos: 0,
    investimentos: 0
  };

  private itemSelected: ItemSelected;
  mesCurrent;
  constructor(private service: OrcamentoFamiliarService, private dialog: MatDialog,
     private message: MessageService, private mesesService: MesesService) { }
  ngOnInit() {
    this.mesAtual();
  }

  mesAtual(){
    this.mesCurrent = this.mesesService.getMesAtual();
    this.refreshTitulos();
  }

  previewMes(){
    this.mesCurrent = this.mesesService.getPreviewMes();
    this.refreshTitulos();
  }

  nextMes(){
    this.mesCurrent = this.mesesService.getNextMes();
    this.refreshTitulos();
  }

  refreshTitulos() {
    this.service.getTitulos(this.mesCurrent.ano, this.mesCurrent.mes).subscribe(data => {
      this.totais = { 
        recebimentos: 0,
        pagamentos: 0,
        investimentos: 0
      };
      this.recebimentoDataSet = [];
      this.gastosFixosDataSet = [];
      this.gastosPeriodicosDataSet = [];
      this.cartaoCreditoDataSet = [];
      this.aportesDataSet = [];
      this.resgatesDataSet = [];
      this.desembolsosDataSet = [];
      for (let item of data) {
        if (item.classeLancamento == 1) {
          this.recebimentoDataSet.push(item);
          this.totais.recebimentos += this.getValor(item);
        } else if (item.classeLancamento == 2) {
          this.gastosFixosDataSet.push(item);
          this.totais.pagamentos += this.getValor(item);
        } else if (item.classeLancamento == 3) {
          this.gastosPeriodicosDataSet.push(item);
          this.totais.pagamentos += this.getValor(item);
        } else if (item.classeLancamento == 4) {
          this.cartaoCreditoDataSet.push(item);
          this.totais.pagamentos += this.getValor(item);
        } else if (item.classeLancamento == 5) {
          this.aportesDataSet.push(item);
          this.totais.investimentos += this.getValor(item);
        } else if (item.classeLancamento == 6) {
          this.resgatesDataSet.push(item);
          this.totais.investimentos -= this.getValor(item);
        } else if (item.classeLancamento == 7) {
          this.desembolsosDataSet.push(item);
          this.totais.investimentos -= this.getValor(item);
        }
      }
    })
  }

  private getValor(item: any){
    if( item.valorEfetivo ){
      return item.valorEfetivo;
    }else{
      return item.valorPlanejado
    }
  }

  openLancamentos(categoria: number, titulo?: any): void {
    if (!titulo) {
      titulo = {
        mesVencimento: this.mesCurrent.mes,
        anoVencimento: this.mesCurrent.ano  
      }
    }
    let dataDialog = {
      id: titulo.id,
      categoriaLancamento: categoria,
      classeLancamento: titulo.classeLancamento,
      nmLancamento: titulo.nmLancamento,
      valorPlanejado: titulo.valorPlanejado,
      valorEfetivo: titulo.valorEfetivo,
      mesVencimento: this.mesCurrent.mes,
      anoVencimento: this.mesCurrent.ano
    }
    this.dialog.open(LancamentoTituloComponent, {
      width: '500px',
      data: dataDialog
    }).beforeClosed().subscribe(result => {
      if (result) {
        this.refreshTitulos();
      }
    })

  }

  openPagamento(): void {
    if (this.itemSelected) {
      let dataDialog = {
        categoria: this.itemSelected.categoria,
        id: this.itemSelected.item.id,
        nmLancamento: this.itemSelected.item.nmLancamento,
        valorPago: this.itemSelected.item.valorEfetivo,
        valorTitulo: this.itemSelected.item.valorPlanejado
      }
      this.dialog.open(PagamentoTituloComponent, {
        width: '400px',
        data: dataDialog
      }).beforeClosed().subscribe(result => {
        if(result){
          this.refreshTitulos();
        }
      })
    }
  }

  editLancamentos() {
    if (this.itemSelected) {
      this.openLancamentos(this.itemSelected.categoria, this.itemSelected.item);
    }
  }

  excluirLancamento() {
    if (this.itemSelected) {
      this.message.openConfirmDialog("Deseja excluir o Lançamento?").subscribe(result => {
        if (result) {
          this.service.excluir(this.itemSelected.item.id).subscribe(data => {
            this.refreshTitulos();
          });
        }
      });
    }
  }

  onSelect(event: Event, item: any, categoria) {
    if (this.itemSelected) {
      this.selectClear(this.itemSelected);
    } else {
      this.itemSelected = new ItemSelected();
    }
    if (this.itemSelected.html != <HTMLElement>event.currentTarget) {
      this.itemSelected = { html: <HTMLElement>event.currentTarget, item: item, categoria: categoria };
      this.select(this.itemSelected.html);
    } else {
      this.itemSelected = new ItemSelected();
    }
  }

  select(tr: HTMLElement) {
    tr.setAttribute("selected", "");
  }

  selectClear(item: ItemSelected) {
    if (item.html) {
      item.html.removeAttribute("selected");
      this.itemSelected = null;
    }
  }

  getTotalPlanejado(dataSet) {
    if (dataSet) {
      return dataSet.map(t => t.valorPlanejado).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }

  getTotalPago(dataSet) {
    if (dataSet) {
      return dataSet.map(t => t.valorEfetivo).reduce((acc, value) => acc + value, 0);
    }
    return 0;
  }


}

