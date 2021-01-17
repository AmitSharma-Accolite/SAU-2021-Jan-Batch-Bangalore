import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiDataService {

  constructor(private http : HttpClient) { }
   url = 'https://jsonplaceholder.typicode.com/todos';
  getData() {
    
    return this.http.get(this.url);
  }
  
  getTodoDetailsURL(id:any){
    const newUrl = this.url + "/" + id;
    console.log(newUrl);
   return this.http.get(newUrl);
  }

}
