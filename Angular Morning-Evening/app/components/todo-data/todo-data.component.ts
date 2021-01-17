import { Component, OnInit } from '@angular/core';
import { ApiDataService } from 'src/app/service/api-data.service';
import { DOCUMENT } from '@angular/common'; 
@Component({
  selector: 'app-todo-data',
  templateUrl: './todo-data.component.html',
  styleUrls: ['./todo-data.component.scss']
})
export class TodoDataComponent implements OnInit {
   apiData:any;
   todoData: any
  todoDetails:any;
  constructor(private Data: ApiDataService) { 
          this.apiData = Data.getData();
         // console.log(this.apiData);
          this.apiData.subscribe((item: any)=>{
            this.todoData = item;
           // console.log(item);
          });
          // console.log(this.todoData);
         

   }
   id : any;
   getTodoDetails(id:any){
       this.id = id;
      //  console.log(this.todoDetails);  
     this.ngOnInit();
    }
 


  ngOnInit(): void {
    if(this.id!=undefined) {
    this.Data.getTodoDetailsURL(this.id).subscribe((item:any)=>{
      this.todoDetails = item;
    });
  }
  }

}
