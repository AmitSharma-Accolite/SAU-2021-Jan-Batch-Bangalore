/*
3.Write a JavaScript program to check whether all the 
digits in a given number are the same or not. 
*/

/*
   inside function taking reference variable (ref) to store last digit of the value
   and matching with the all digits in the number from the ending inside the while loop
   because all digit in the number should be same then if any number is not equal to 
   ref variable then return false or while execution then number have all same digits
   then return true\

*/

function checkDigitsSame(num){
     let ref = num%10;
     
     num = Math.floor(num/10);
     while(num){
         let temp = num%10;
       //  console.log(temp + " " + ref );
         num = Math.floor(num/10);
         if(ref!=temp) return false;
     }
     return true;
}

/* 
   getValueConsole() method run in browser console because  prompt is opening 

*/

function getValueConsole(){
    let enterValue = prompt('Enter Number to check have same digits or not', -1);
    var value = parseInt(enterValue);
    if(isNaN(value)){
        console.log("Enter Numeric value or exist enter -1");
        getValue();     
    }
    else{
        if(value==-1) 
            return "Exist";
        else
            if(checkDigitsSame(value))
             console.log(`Enter number have same digits ${value}`);
            else 
            console.log(`Enter number have not same digits ${value}`);
        }
}

getValueConsole();