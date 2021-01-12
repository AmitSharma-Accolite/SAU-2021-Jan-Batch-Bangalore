/* 
    2.Write a JavaScript program to change the capitalization (case) 
    of all letters in a given string.  
*/

function getToggleString(enterString){
    let resultedString = "";
      for(let i=0;i<enterString.length;i++){
          if(/[a-z]/.test(enterString[i])==true)
          resultedString += enterString[i].toUpperCase();
          else if(/[A-Z]/.test(enterString))
          resultedString += enterString[i].toLowerCase();
          else 
          resultedString += enterString[i];
      }
    return resultedString;
}


/* 

   getValueConsole() method run in browser console because  prompt is opening 

*/
function getValueConsole(){
    let enterString = prompt('Enter Number to string for toggle result', "Enter");
    console.log(` given string ${enterString} 
     and toggled string is ${getToggleString(enterString)}`);
}

getValueConsole()
