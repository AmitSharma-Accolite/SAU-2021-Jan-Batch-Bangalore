// 1.Write a JavaScript program to find all distinct prime factors of a given integer.


// checkprime is used to check wheater number is prime or not
function checkPrime(num){
    for(let i = 2;i<=Math.sqrt(num);i++)
        if(num%i==0) 
            return false;
return true;
}

function findFactor(num){
    let containFactor = [];

    for(let i = 2;i<=num;i++){
        if(checkPrime(i) && num%i===0){
            containFactor.push(i);
        }
    }
    console.log(`Prime factor of the value ${num} is ${containFactor}`);
    
}

/* 
   getValueConsole() method run in browser
    console because  prompt is opening 

*/
function getValueConsole(){
    let enterValue = prompt('Enter Number to find prime factor', -1);
    var value = parseInt(enterValue);
    if(isNaN(value)){
        console.log("Enter Numeric value or exist enter -1");
        getValue();     
    }
    else{
        if(value==-1) 
            return "Exist";
        else
            findFactor(value);
        }
}

getValueConsole();
