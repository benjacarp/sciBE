function login(){
    //e.preventDefault();
    var user = document.getElementById("userfield").value;
    var pass = document.getElementById("passfield").value;

    $.ajax({
        type     : "GET",
        dataType: "json",
        url      : "/empresa/login?user=" + user + "&pass=" + pass ,
        success  : function(data) {

            if (data.success) {
                alert('login');
            } else {
                document.getElementById("passlabel").innerHTML = "password: "+data.message;
            }
        }
    });

};