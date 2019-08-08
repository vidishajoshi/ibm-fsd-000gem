import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from '../users/list/list.component';
import {AddComponent} from '../users/add/add.component';
import {ModifyComponent} from  '../users/modify/modify.component';
import {DeleteComponent} from '../users/delete/delete.component';


const routes: Routes = [{
    path: 'users',
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
export class UsersRoutingModule { }
