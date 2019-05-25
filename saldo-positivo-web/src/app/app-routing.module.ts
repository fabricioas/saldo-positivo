import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrcamentoFamiliarComponent } from './orcamento-familiar/orcamento-familiar.component';


const routes: Routes = [
  { path: '', redirectTo: '/orcamento-familiar', pathMatch: 'full' },
  { path: 'orcamento-familiar', component: OrcamentoFamiliarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
