import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewLeagueComponent } from './new-league/new-league.component';


const routes: Routes = [{
  path:"view",
  component:NewLeagueComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
