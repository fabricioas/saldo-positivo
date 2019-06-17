import { Injectable } from '@angular/core';
import { HttpService } from '../http.service';
import { LancamentoTitulo } from './LancamentoTitulo';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LancamentoTituloService {

constructor(private http: HttpService) { }

  salvar(lancamento: LancamentoTitulo): Observable<any>{
    if( lancamento.id ){
      return this.http.put("/titulos/lancamento",lancamento.id,lancamento);
    }else{
      return this.http.post("/titulos/lancamento",lancamento);
    }
  }

}
