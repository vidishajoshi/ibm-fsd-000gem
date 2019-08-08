import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddComponent } from './add/add.component';
import { ModifyComponent } from './modify/modify.component';
import { DeleteComponent } from './delete/delete.component';
import {UsersRoutingModule} from  './users-routing.module';
import { ListComponent } from './list/list.component';
import {FormsModule} from '@angular/forms'

@NgModule({
  declarations: [AddComponent, ModifyComponent, DeleteComponent, ListComponent],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule
  ]
})
export class UsersModule { }
