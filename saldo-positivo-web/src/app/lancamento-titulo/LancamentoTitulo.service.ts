import { Injectable,Inject } from '@angular/core';
import { HttpService } from '../http.service';
import { LancamentoTitulo } from './LancamentoTitulo';
import { PagamentoTitulo } from '../pagamento-titulo/PagamentoTitulo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LancamentoTituloService {
  constructor(private http: HttpService){}

  salvar(lancamento: LancamentoTitulo): Observable<any>{
    return this.http.put("/titulos/lancamentos/",lancamento);
  }

  pagar(titulo: PagamentoTitulo): Observable<any>{
    return this.http.put("/titulos/lancamentos/pagar/",titulo);
  }
}
