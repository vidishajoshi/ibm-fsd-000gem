import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddComponent} from '../projects/add/add.component';
import {ModifyComponent} from  '../projects/modify/modify.component';
import {DeleteComponent} from '../projects/delete/delete.component';
import {ListComponent} from '../projects/list/list.component';

const routes: Routes = [{
    path: 'projects',
    children:[
        {
            path:'list',
            component:ListComponent
        },
        {
        path:'add',
        component:AddComponent
    },
    {
    path:'modify',
    component:ModifyComponent
   },  
   {
    path:'delete',
    component:DeleteComponent
  }
]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
