function formValidation()  
{  
var uid = document.registration.name1; 
var uid2 = document.registration.name2; 
var passid = document.registration.pword;  
var uname = document.registration.uname;  
  
var uzip = document.registration.phone;  
var uemail = document.registration.email;
var cpassid = document.registration.cpword;
 if(userid_validation(uid,5,20))  
{ 
    if(userid2_validation(uid2,5,20))
    {
        
        
    
if(teamid_validation(uname, 5, 20))  
{

if(passid_validation(passid,7,20))  
{ 

  

if(allnumeric(uzip))  
{  
if(ValidateEmail(uemail))  
{
    if(cpassid_validation(passid,cpassid))  
{
return true;
}  
}   
}  
}   
}
}
}
 
  
  
  
return false;  
  
}

function userid_validation(uid,mx,my)  
{  
var uid_len = uid.value.length;  
if (uid_len == 0 || uid_len >= my || uid_len < mx)  
{  
alert("Name 1 should not be empty. Length should be between "+mx+" and "+my+" characters.");  
uid.focus();  
return false;  
}  
return true;  
}

function userid2_validation(uid,mx,my)  
{  
var uid_len = uid.value.length;  
if ( uid_len >= my)  
{  
alert("Length of Name 2 should be less than"+my+"characters.");  
uid.focus();  
return false;  
}  
return true;  
}

function teamid_validation(uid,mx,my)  
{  
var uid_len = uid.value.length;  
if (uid_len == 0 || uid_len >= my || uid_len < mx)  
{  
alert("Length of Team Name should be between "+mx+" and "+my+" characters.");  
uid.focus();  
return false;  
}  
return true;  
}




function passid_validation(passid,mx,my)  
{  
var passid_len = passid.value.length;  
if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
{  
alert("Length of password should be between "+mx+" and "+my+" characters.");  
passid.focus();  
return false;  
}  
return true;  
}  



function allnumeric(uzip)  
{   
var numbers = /^[0-9]+$/;  
if(uzip.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('You have entered an invalid phone number');  
uzip.focus();  
return false;  
}  
}  
function ValidateEmail(uemail)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(uemail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
uemail.focus();  
return false;  
}  
}


function cpassid_validation(pass, cpass)
{
    if(pass.value==cpass.value)
    {return true;
    }
    else
    {
        alert("Passwords do not match. ");
        cpass.focus();
        return false;
    }
}


