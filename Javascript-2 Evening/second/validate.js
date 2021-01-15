/* 
taking value from which Radio button is checked 
if no one clicked then return empty string 
*/

function getRadioButtonValue() {
    let gender;
    if (document.getElementById("male").checked)
        gender = "male";
    else if (document.getElementById("female").checked)
        gender = "female";
    else gender = "";
    return gender;
}

/*
validate email address 
*/
function checkEmailAddress(email) {
    if (/^[a-z0-9]+@[a-z]+.com$/.test(email)) return true;
    else return false;
}

/* 
validating form call after click submit button
capture value of  html form field and checking have empty string that's default

 email Address validate with checkEmailAddress allowing ony .com domain emails

*/

function validateForm() {
    let firstName = document.getElementById("first_name").value;
    let lastName = document.getElementById("last_name").value;
    let emailAddress = document.getElementById("address").value;


    var country = document.getElementById("country").value;

    let gender = getRadioButtonValue();


    validEmail = checkEmailAddress(emailAddress);

    if (validEmail && firstName != "" && lastName != "" && gender != "" && country != "") {
        let data = {
            FirstName: firstName,
            LastName: lastName,
            Gender :gender,
            Country:country,
            Email : emailAddress
        }
        console.log(data);
     
        let sendData = `First Name: ${data.FirstName} <br> Last Name: ${data.LastName} <br> Gender :${data.Gender} 
                         Country: ${data.Country} <br> Email: ${data.Email}`;
                         
         
        document.getElementById("about").innerHTML = sendData;
    }else{
        alert("Form is not Valid");
        console.log("Form is not Valid");
    }


}