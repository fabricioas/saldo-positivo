import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule, MatCheckboxModule,MatIconModule,MatMenuModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input'; 
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatChipsModule} from '@angular/material/chips';
import {MatDividerModule} from '@angular/material/divider'; 
import {MatFormFieldModule} from '@angular/material/form-field'; 
import {MatDialogModule} from '@angular/material/dialog'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { OrcamentoFamiliarComponent } from './orcamento-familiar/orcamento-familiar.component';
import { PlanejamentoFinanceiroComponent } from './planejamento-financeiro/planejamento-financeiro.component';
import { TesteComponent } from './teste/teste.component';
import {LancamentoTituloComponent} from './lancamento-titulo/lancamento-titulo.component';
@NgModule({
   declarations: [
      AppComponent,
      MenuComponent,
      OrcamentoFamiliarComponent,
      PlanejamentoFinanceiroComponent,
      TesteComponent,
      LancamentoTituloComponent
   ],
   imports: [
      HttpClientModule,
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      MatButtonModule,
      MatCheckboxModule,
      MatMenuModule,
      MatSidenavModule,
      MatToolbarModule,
      MatGridListModule,
      MatCardModule,
      MatTableModule,
      MatChipsModule,
      MatIconModule,
      MatDividerModule,
      MatDialogModule,
      MatInputModule,
      MatFormFieldModule
   ],
   entryComponents: [
      LancamentoTituloComponent
    ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
