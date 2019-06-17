import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrcamentoFamiliarComponent } from './orcamento-familiar/orcamento-familiar.component';
import {PlanejamentoFinanceiroComponent} from './planejamento-financeiro/planejamento-financeiro.component';
import {TesteComponent} from './teste/teste.component';
const routes: Routes = [
  { path: '', redirectTo: '/orcamento-familiar', pathMatch: 'full' },
  { path: 'orcamento-familiar', component: OrcamentoFamiliarComponent },
  { path: 'planejamento-financeiro', component: PlanejamentoFinanceiroComponent },
  { path: 'teste', component: TesteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
