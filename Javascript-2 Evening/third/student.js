











function getRadioButtonValue() {
    let gender;
    if (document.getElementById("male").checked)
        gender = "male";
    else if (document.getElementById("female").checked)
        gender = "female";
    else gender = "";
    return gender;
}

AllData = {};

addStudentDetails = () => {
    
    
    count = 0;
    data = {};  
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let age = document.getElementById("age").value;
    let rollno = document.getElementById("rollno").value.toUpperCase();;
    let dob = document.getElementById("dob").value;
    let gender = getRadioButtonValue();
   console.log(rollno);

    if (firstName != "" && lastName != "" && gender != "" && age != "" &&rollno!="" && dob!="") {
      data = {
            FirstName: firstName,
            LastName: lastName,
            Gender :gender,
            Rollno : rollno,
            DOB : dob,
            Age :age
        }
    
    
      AllData[rollno] = data;
        
    
    // count +=1;
    alert("new Student Data add");
    console.log("new Student add"); 
    }else{
        alert("Form is not Valid");
        console.log("Form is not Valid");
    }

  console.log(AllData);


}

getStudentDetails = () => {
    let findRollno = document.getElementById("getRollno").value.toUpperCase();;
    let show = "";
    console.log(findRollno);
    if(findRollno=="") alert("Enter Rollno");
     else if(findRollno in AllData){
   
      show += `First Name: ${AllData[findRollno].FirstName} <br>
      Last Name: ${AllData[findRollno].LastName} <br>
      Gender : ${AllData[findRollno].Gender} <br>
      Age : ${AllData[findRollno].Age} <br>
      DOB :  ${AllData[findRollno].DOB} <br> `;
         console.log(AllData[findRollno]);  

         document.getElementById("studentData").innerHTML = show;
     }
   else {
    document.getElementById("studentData").innerHTML = "Student Rollno not Found";
   }

}