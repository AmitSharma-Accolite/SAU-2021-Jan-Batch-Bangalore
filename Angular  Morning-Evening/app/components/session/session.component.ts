import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';
import { Session } from '../../model/session';
import { EventEmitter } from "@angular/core";
import { concat } from 'rxjs';
@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})
export class SessionComponent implements OnInit {

  sessionDetails:Session[];
  
  newSessionDetails!:Session;
  constructor(private sessionService : DataService) { 
    this.sessionDetails = this.sessionService.details;
    console.log(this.sessionDetails);

  
  }

  addCheck:boolean =false;
  
  edit(index:any):void{
   this.sessionDetails[index].editing = true;
  }

   save(index:any):void { 
    console.log(this.sessionDetails);
    this.sessionDetails[index].editing = false;
    this.addCheck = true;
  
       
   }
  
  add(){
       this.newSessionDetails =  {
        sessionName:"",
        trainerName:"",
        date: new Date,
        editing:true,
     };

    //  this.oldSessionData= this.sessionDetails;

     this.sessionDetails.push(this.newSessionDetails);
    
  }

   delete(index:any){
    this.sessionDetails.splice(index, 1);
   }

  ngOnInit(): void {
   
  }
 

}
