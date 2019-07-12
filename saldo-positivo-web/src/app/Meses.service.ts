import { Injectable } from '@angular/core';

export interface Mes {
  mes: number,
  ano: number,  
}
const MESES = ["Janeiro", "Fevereiro","Março","Abril","Maio","Junho","Julio","Agosto","Setembro","Outubro","Novembro","Dezembro"];

@Injectable({
  providedIn: 'root'
})

export class MesesService {

constructor() { }
  private dataAtual = new Date();

  getMes(){
    let mes: Mes = {
      mes: this.dataAtual.getMonth()+1,
      ano: this.dataAtual.getFullYear()
    }
    return mes;
  }

  getMesAtual(){
    this.dataAtual = new Date();
    return this.getMes();
  }

  getNextMes(){
    this.dataAtual.setMonth(this.dataAtual.getMonth() +1);
    return this.getMes();
  }
  
  getPreviewMes(){
    this.dataAtual.setMonth(this.dataAtual.getMonth() -1);
    return this.getMes();
  }
}
