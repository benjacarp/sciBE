window.onload = loadEmpresaInfo;

function loadEmpresaInfo() {
    $.ajax({
       type: "GET",
       dataType: "json",
       url: "/empresa/1",
       success: function(data){
                    document.getElementById("empresa").innerHTML = ""+data.nombre;
                    document.getElementById("cuit").innerHTML = ""+data.cuit;
                    document.getElementById("direccion").innerHTML = ""+data.direccion;
                },
       error: function() {
        alert('error');
       }
    });
}

