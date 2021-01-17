import {  NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { SessionComponent } from './components/session/session.component';
import { TodoDataComponent } from './components/todo-data/todo-data.component';

const routes: Routes = [
   
  {path:'', component:SessionComponent},
  {path:'api-data' ,component:TodoDataComponent},
  {path:'**',component:PageNotFoundComponent},

   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
