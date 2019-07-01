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
    return this.http.put("/titulos/lancamentos/1",lancamento);
  }

}
