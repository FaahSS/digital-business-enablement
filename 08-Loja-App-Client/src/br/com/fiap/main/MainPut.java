package br.com.fiap.main;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainPut {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		Client client = Client.create();
		System.out.println("Digite o código: ");
		int codigo = e.nextInt();
		WebResource webResource = client.resource("http://localhost:8061/07-Loja-App-RESTFul/rest/produto/" + codigo);
		ProdutoTO produto = new ProdutoTO(codigo, 300, 110, "Camiseta da Positivo");
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, produto);
		if (response.getStatus() == 200) {
			System.out.println("Sucesso! ");
		} else {
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}
}
