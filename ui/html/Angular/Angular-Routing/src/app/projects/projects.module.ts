import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddComponent } from './add/add.component';
import { ModifyComponent } from './modify/modify.component';
import { DeleteComponent } from './delete/delete.component';
import {ProjectsRoutingModule} from './projects-routing.module';
import { ListComponent } from './list/list.component';
import {FormsModule} from '@angular/forms'



@NgModule({
  declarations: [AddComponent, ModifyComponent, DeleteComponent, ListComponent],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    FormsModule
  ]
})
export class ProjectsModule { }
