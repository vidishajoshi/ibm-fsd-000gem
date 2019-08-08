import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  details : User
  constructor(private route:ActivatedRoute,private router:Router) { }


  ngOnInit() {
  }
  addProjects(data_){
    // console.log(data_);
    const uData = data_
    this.details={
      name: uData.name,
      info: uData.info,
      cname: uData.cname
    }
    this.router.navigate(['/projects/list'],{queryParams:{ user: JSON.stringify(this.details) }})
  }

}

export interface User{
  name:string
  info:any
  cname:string
} 
