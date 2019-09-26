import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  
import { HttpClientModule } from '@angular/common/http';  
import {DataTableModule} from 'angular-datatable';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewLeagueComponent } from './new-league/new-league.component';

@NgModule({
  declarations: [
    AppComponent,
    NewLeagueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DataTableModule,
    FormsModule,  
    ReactiveFormsModule,  
    HttpClientModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
