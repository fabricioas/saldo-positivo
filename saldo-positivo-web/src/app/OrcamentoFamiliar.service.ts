import { Injectable } from '@angular/core';
import {HttpService} from './http.service';
import { Observable } from 'rxjs';
;@Injectable({
  providedIn: 'root'
})
export class OrcamentoFamiliarService {

constructor(private http: HttpService) { }

  getTitulos(ano: number,mes: number): Observable<any>{
    return this.http.get(`/titulos/lancamentos/${ano}/${mes}`);
  }

  excluir(id: string): Observable<any>{
    return this.http.delete("/titulos/lancamentos/",id);
  }

}
