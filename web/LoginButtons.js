var LoginButton = document.createElement("button");
LoginButton.innerHTML = "Login";

var SignUpButton = document.createElement("button");
SignUpButton.innerHTML = "Sign Up";

var body =  document.getElementsByTagName("body")[0];
body.appendChild(LoginButton);
body.appendChild(SignUpButton);

LoginButton.addEventListener("click", function () {
   alert("Login");
});

SignUpButton.addEventListener("click", function () {
    alert("Sign Up");
});