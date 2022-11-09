function nameValidator(id, errorId) {
    const nameerror = "First letter have to be uppercase"

    let name = document.getElementById(id).value;
    let length = name.length;

    if(2 <= length && length < 25){
        if(name[0].toUpperCase() === name[0]){
          document.getElementById(id).style.outlineColor = "#33ff4e";
          document.getElementById(errorId).innerHTML = "";
          return true;
        }else{
          document.getElementById(errorId).innerHTML = nameerror;
          return false;
        }
    }else{
        document.getElementById(id).style.outlineColor = "#FF4545";
        return false;
    }
}

  function phoneValidator(){
    const id = 'phonenumber';
    const error = "Please provide a phonenumber";

    let phone = document.getElementById(id).value;
    let lenght = phone.length;


    if(lenght !== 8){
      document.getElementById(id).style.outlineColor = "#FF4545";
      return false;
    }else{
      if (Number.isNaN(parseInt(phone))){
        document.getElementById('numbererror').innerHTML = error;
        return false;
      }else{
      document.getElementById(id).style.outlineColor = "#33ff4e";
      document.getElementById('numbererror').innerHTML = "";
      return true;
      }
    }
  }

  function passwordValidator(){
    const passworderror = "Password have to be between 8 - 16 characters"
    const id = 'pw';

    let password = document.getElementById(id).value;
    let length = password.length;

    if(length < 8 || length > 16){
      document.getElementById(id).style.outlineColor = "#FF4545";
      document.getElementById('passwordError').innerHTML = passworderror;
      return false;
    }else{
      document.getElementById(id).style.outlineColor = "#33ff4e";
      if(document.getElementById('passwordError').value !== ""){
        document.getElementById('passwordError').innerHTML = "";
      }
      return true
    }
  }

    function equalPassword(){
      const mainPass = document.getElementById('pw').value;
      const repeted = document.getElementById('repeted').value;


      if(repeted !== mainPass){
        document.getElementById('repeted').style.outlineColor = "#FF4545";
        return false
      }else{
        document.getElementById('repeted').style.outlineColor = "#33ff4e";
        return true
    }

  }