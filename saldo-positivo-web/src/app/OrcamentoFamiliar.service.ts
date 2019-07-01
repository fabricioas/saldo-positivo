import { Injectable } from '@angular/core';
import {HttpService} from './http.service';
import { Observable } from 'rxjs';
;@Injectable({
  providedIn: 'root'
})
export class OrcamentoFamiliarService {

constructor(private http: HttpService) { }

  getTitulosRecebimento(ano: number,mes: number): Observable<any>{
    return this.http.get(`/titulos/lancamentos/1/${ano}/${mes}`);
  }
  getTitulosGastosFixos(mes: number, ano: number): Observable<any>{
    return this.http.get("/titulos/lancamentos/2/1/1");
  }
  getTitulosGastosPeriodicos(mes: number, ano: number): Observable<any>{
    return this.http.get("/titulos/lancamentos/3/1/1");
  }
}
