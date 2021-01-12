/*
4.Write a JavaScript program to compute
 the sum of all digits that occur in a given string. 
*/

// use RegExp [1-9] for check digits inside the string 
function getDigitSum(enterString){
    let digitSum = 0;
    for(let i=0;i<enterString.length;i++){
        if(/[1-9]/.test(enterString[i]))
        digitSum += parseInt(enterString[i]);
    }
    return digitSum;
}

/* 
   getValueConsole() method run in browser 
   console because  prompt is opening 
*/
function getValueConsole(){
    let enterString = prompt('Enter string ', -1);
    console.log(`Enter string is ${enterString}
                 and sum of digits in given string is ${getDigitSum(enterString)}`);
}

getValueConsole();