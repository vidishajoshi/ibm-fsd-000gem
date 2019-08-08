import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router} from '@angular/router';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(private route:ActivatedRoute,private router:Router) { }
  qParams :any;

  ngOnInit() {
    this.qParams= JSON.parse(this.route.snapshot.queryParams.user);
  }
  
  modifyProjects(){
    this.router.navigate(['/users/modify'],{queryParams:{ users: JSON.stringify(this.qParams) }})
  }

}
