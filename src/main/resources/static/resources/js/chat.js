let stompClient;

function registration(){
	// Crear un objeto de la clase SockJS, utilizar la ruta
	// que sirve para comunicar el cliente con el servidor
	let socket = new SockJS("/chat");
	// Crear objeto stompClient de tipo Stomp utilizando el 
	// canal de comunicación actual
	stompClient = Stomp.over(socket); 
	// Abrir acceso
	stompClient.connect({}, function(){
		// Registrar
		stompClient.subscribe("/topic/messages/"+$("#userName").val(),mensajeRecibido)
	})

}

function mensajeRecibido(response){
	// convertir en JSON el valor del parámetro response
	let data = JSON.parse(response.body);
	render(data.message, data.fromUsuario);
}

				// Alex    Hola
function sendMsg(username, men){
	stompClient.send("/app/chat/server", {}, 
		JSON.stringify({message:men, fromUsuario:username})
	)
}

function sendMsgServer(username, men){
	stompClient.send("/app/chat/"+username, {}, 
		JSON.stringify({message:men, fromUsuario:"server"})
	)
}