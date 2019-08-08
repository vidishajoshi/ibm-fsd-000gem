import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit {

  constructor(private route:ActivatedRoute,private router:Router) { }
  uDatas:any
  ngOnInit() {
    this.uDatas= JSON.parse(this.route.snapshot.queryParams.users);
    console.log(this.uDatas)
  }
ModUser(){
  console.log(this.uDatas);
 this.router.navigate(['/users/list'],{queryParams:{ user: JSON.stringify(this.uDatas) }})
}

}
export interface User{
  name:string
  email:any
  cname:string
} 
