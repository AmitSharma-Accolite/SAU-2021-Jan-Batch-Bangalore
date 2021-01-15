
class operation{


    // create object to store result of the functions 
    data  = { };

    constructor(param){
        this.inputString = param;
    }
    
    /*
      serial function call callback convertLegth 
    */
    Serial = (callback)=>{
        console.log("serial function call");
        callback(this.convertUpperCase);
        console.log(this.data.Legth);
        return this.data;
    };

     /*
      convertLength function call callback convertUpperCase
    */
    calculateLength = (callback)=>{
        console.log("calculateLength function call");
        this.data.Legth = this.inputString.length;
        callback(this.convertLowerCase);
    };

     /*
      convertUpperCase function call callback convertLowerCase
    */
    convertUpperCase = (callback)=>{
        console.log("convertUpperCase function call");
        this.data.UpperCase =  this.inputString.toUpperCase();
        callback(this.filterLetter);
    };
    /*
      convertLowerCase function call callback filterLetter
    */
    convertLowerCase = (callback)=>{
        console.log(" convertLowerCase function call");
        this.data.LowerCase = this.inputString.toLowerCase();
        callback(this.statusCheck);
    };
     /*
      filterLetter function call callback Status
    */
    filterLetter = (callback) =>{
        console.log("filterLetter function call");
        let consonants = "";
        let vowels = "";
        let garbage = "";
       for(let i=0;i<this.inputString.length;i++){
            if(/[a,e,i,o,u,A,E,I,O,U]/.test(this.inputString[i])    )
                    vowels += this.inputString[i];
            else if(/[0-9]/.test(this.inputString[i]))
                    garbage +=  this.inputString[i];
            else consonants += this.inputString[i];
            };
        
            this.data.Filter =  ({
              consonants : consonants,
              vowels: vowels,
               garbage : garbage} );
               callback();
    }
   /*
      status function call no function callback here
    */
    statusCheck = ()=>{
        console.log("statusCheck function call");
       let flag = /[0-9]/.test(this.inputString)
       if(flag) alert(`Input String have numeric value`);
         flag ? this.data.Status = `Input String have numeric value`
                                              :this.data.Status = `Input String is valid`;
    }


}


/*
      asyn function init  argument object of opeartion class
      wait for execuation of Serial function and after that call Show function to change DOM
*/

async function init(opt){
        await opt.Serial(opt.calculateLength);

        /* 
            show data function  
            here opt ( object of operation) taking reference from init method
            
        */
         show = () =>{
          document.getElementById("lengthIn").innerHTML = opt.data.Legth;
          document.getElementById("upperIn").innerHTML = opt.data.UpperCase;
          document.getElementById("lowerIn").innerHTML = opt.data.LowerCase; 
          document.getElementById("filterC").innerHTML = opt.data.Filter.vowels;
          document.getElementById("filterV").innerHTML = opt.data.Filter.consonants;
          document.getElementById("filterG").innerHTML =opt.data.Filter.garbage;
          document.getElementById("status").innerHTML = opt.data.Status; 
        }

        show();
}








function Compute() {    
  
    // Taking string  value from the inut tag a
     let inputString = document.getElementById("inputString").value;
     console.log(inputString);

     // create object of operation class and pass inputstring in constructor 
     let opt = new operation(inputString);
  
    // call init function with class object operation 
     init(opt);



   
}