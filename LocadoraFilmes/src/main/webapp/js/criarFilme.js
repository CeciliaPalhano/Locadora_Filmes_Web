//valida o formulario
function validarFormulario(){
	var campo = document.getElementById('formulario:nome');
	var campo1 = document.getElementById('formulario:assunto');
	var campo2 = document.getElementById('formulario:duracao');
	var campo3 = document.getElementById('formulario:datalocacao');
	var campo4 = document.getElementById('formulario:dataentrega');
	var campo5 = document.getElementById('formulario:precolocacao');
	
	if(campo.value.length==0){
		alert('O campo nome deve ser preenchido.');
		campo.focus();
		return false;
	}
	if(campo1.value.length==0){
		alert('O campo assunto deve ser preenchido.');
		campo.focus();
		return false;
	}
	if(campo2.value.length==0){
		alert('O campo duração deve ser preenchido.');
		campo.focus();
		return false;
	}
	if(campo3.value.length==0){
		alert('O campo data locação deve ser preenchido.');
		campo.focus();
		return false;
	}
	if(campo4.value.length==0){
		alert('O campo data entrega deve ser preenchido.');
		campo.focus();
		return false;
	}
	if(campo5.value.length==0){
		alert('O campo preço locação deve ser preenchido.');
		campo.focus();
		return false;
	}
	
	return true;
}



