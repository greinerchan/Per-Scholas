var element = document.getElementById("form");
var ele = document.getElementById("feedback");
if(element.addEventListener) {
  element.addEventListener("submit", main_validator, true);
} else if(ele.attachEvent) {
  element.attachEvent("onsubmit", main_validator);
}
function main_validator(e) {
  console.log(e);
  e.preventDefault();
  ele.innerHTML = "";
  if(check_username(e.target[0].value) && check_dob(e.target[1].value)) {
      element.submit();
  }
}
function check_username(username) {
  var re = new RegExp(/^[a-zA-Z0-9_.-]*$[a-zA-Z_.-]*$/g);
  var message = "";
  var someWrong = false;
  console.log(re.test(username));

  if(!re.test(username)) {
    message += "Username can only be [a-z], [A-Z], or (-,_)";
    someWrong = true;
  }
  if(username.length > 20) {
    message += "\nUsername must be less than 20 characters";
    someWrong = true;
  }
  if(someWrong) {
    var para = document.createElement("p");
    para.classList.add("danger");
    var t = document.createTextNode(message);
    para.appendChild(t);
    ele.appendChild(para);
    return false;
  }
  return true;
}

function check_dob(dob){
  //this is one line
  var re = new RegExp(/(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/);
  var message = "";
  var someWrong = false;
  if(!re.test(dob)){
      message += "Your date of birth is not in the right format";
      someWrong = true;
  }
  if(someWrong){
      // Create a <p> element
      var para = document.createElement("P");
      para.classList.add("danger");
      // Create a text node
      var t = document.createTextNode(message);
      para.appendChild(t);
      ele.appendChild(para);
      return false;
  }
}
