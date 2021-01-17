import { ViewportScroller } from '@angular/common';
import { Injectable } from '@angular/core';
import { Session } from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }
  // sessionName!: string;
  // trainerName !: string;
  // date!:Date;
  details:Session[] =[
    {
       sessionName:"VCS",
       trainerName:"Devansh sharma",
       date: new Date,
       editing:false,
    },
    {
       sessionName:"RDBMS concepts ",
       trainerName:"Sivagami S",
       date: new Date,
       editing:false,
    },
    {
      sessionName:"SQL concepts ",
      trainerName:"Sivagami S",
      date: new Date,
      editing:false,
   },
   {
    sessionName:"No SQL",
    trainerName:"Abhisek Nandan",
    date: new Date,
    editing:false,
 },
 {
  sessionName:"HTML/CSS",
  trainerName:"Vignesh",
  date: new Date,
  editing:false,
},
{
  sessionName:"Java Script",
  trainerName:"Anushree",
  date: new Date,
  editing:false,
},
{
  sessionName:"Angular ",
  trainerName:"Pritam ",
  date: new Date,
  editing:false,
},
{
  sessionName:"React ",
  trainerName:"Raviteja V / Vignesh",
  date: new Date,
  editing:false,
},
{
  sessionName:"React Native",
  trainerName:"Tajammul",
  date: new Date,
  editing:false,
},

  ];



}
