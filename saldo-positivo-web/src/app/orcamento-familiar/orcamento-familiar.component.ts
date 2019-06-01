import { Component, OnInit } from '@angular/core';
import {MatIconRegistry} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';

export interface LancamentosMesResponseLancamentos  {
  id : String;
  nmLancamento : String;
  status : String;
  tipeLancamento : String;
  valorLancamento : Number;
  valorSaldo : Number;
  dataLiquidacao : String;
  dataVencimento : String;
}

const RECEITA_DATA: LancamentosMesResponseLancamentos[] = [
  {id: "1", nmLancamento: 'Luz', status: "PAGO", tipeLancamento: 'DESPESA',valorLancamento:187.90,valorSaldo: 1020.45, dataLiquidacao: "2019-5-10",dataVencimento: "2019-5-10"}
];

@Component({
  selector: 'app-orcamento-familiar',
  templateUrl: './orcamento-familiar.component.html',
  styleUrls: ['./orcamento-familiar.component.css']
})

export class OrcamentoFamiliarComponent implements OnInit {

  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'add',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-add-24px.svg'));
  iconRegistry.addSvgIcon(
        'delete',
        sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-delete-24px.svg'));
    iconRegistry.addSvgIcon(
      'edit',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-create-24px.svg'));
      iconRegistry.addSvgIcon(
        'descript',
        sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-description-24px.svg'));
        
    }
  ngOnInit() {
  }

  mes="Maio";
  ano="2019";
  displayedColumns: string[] = ['nmLancamento', 'status', 'tipeLancamento', 'valorLancamento','dataVencimento','descript','edit','delete'];
  

}

