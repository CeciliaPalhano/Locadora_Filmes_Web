//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio){
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item=0; item<formulario.length; item++){
		campo = formulario[item];
		if (campo.type == 'radio' && campo.name != radio.name){
			campo.checked = false;
		}
	}
}
//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcarTodos(){
	var formulario = document.getElementById('formulario');
	var campo;
	for (var item=0; item<formulario.length; item++){
		campo = formulario[item];
		if (campo.type == 'radio' && campo.checked){
			campo.checked = false;
		}
	}
}
//armazena o identificador do item escolhido
function selecionarItem(campoHidden,radioSelecionado){
	document.getElementById(campoHidden).value = radioSelecionado.value;
	desmarcar(radioSelecionado);
}

