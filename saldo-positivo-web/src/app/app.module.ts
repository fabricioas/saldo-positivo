import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule }   from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule, MatCheckboxModule,MatIconModule,MatMenuModule,MatNativeDateModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input'; 
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatChipsModule} from '@angular/material/chips';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {MatDividerModule} from '@angular/material/divider'; 
import {MatSelectModule} from '@angular/material/select';
import {MatDialogModule} from '@angular/material/dialog'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { OrcamentoFamiliarComponent } from './orcamento-familiar/orcamento-familiar.component';
import { PlanejamentoFinanceiroComponent } from './planejamento-financeiro/planejamento-financeiro.component';
import { TesteComponent } from './teste/teste.component';
import {LancamentoTituloComponent} from './lancamento-titulo/lancamento-titulo.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { PagamentoTituloComponent } from './pagamento-titulo/pagamento-titulo.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatDatepickerModule,} from '@angular/material/datepicker';
import {MAT_DATE_LOCALE} from '@angular/material/core';

@NgModule({
   declarations: [
      AppComponent,
      MenuComponent,
      OrcamentoFamiliarComponent,
      PlanejamentoFinanceiroComponent,
      TesteComponent,
      LancamentoTituloComponent,
      ConfirmationDialogComponent,
      PagamentoTituloComponent
   ],
   imports: [
      HttpClientModule,
      BrowserModule,
      CommonModule,
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
      FormsModule,
      ReactiveFormsModule,
      MatSelectModule,
      MatButtonToggleModule,
      MatDatepickerModule,
      MatNativeDateModule
   ],
   entryComponents: [
      LancamentoTituloComponent,
      ConfirmationDialogComponent,
      PagamentoTituloComponent
   ],
   providers: [
      {provide: MAT_DATE_LOCALE, useValue: 'pt-BR'},
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
