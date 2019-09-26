import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-league',
  templateUrl: './league.component.html',
  styleUrls: ['./league.component.css']
})
export class LeagueComponent implements OnInit {
  _url:any;
  list:any;
  
  constructor() { }

  ngOnInit() {
    this._url="http://localhost:8976/league/view"
    fetch(this._url)
    .then(res=>res.json())
    .then(data=> {
      console.log(data)
    this.list=data;
    console.log(this.list);
    
    });

  }
    add(){
      fetch("http://localhost:8976/league/add",{
        method:"POST",
        headers:{
          "content-type":"application/json"
        },
        body:JSON.stringify({
           "leagueName":"khokho",
           "season":"spring",
           "year":"2019"
        })
      })
      .then(res=>res.json())
      .then(data=>{
        console.log(data);
      })
    }
    }



  


