package br.com.fiap.main;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainPost {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		Client client = Client.create();
		System.out.println("Digite o código: ");
		int codigo = e.nextInt();
		
		WebResource webResource = client.resource("http://localhost:8061/07-Loja-App-RESTFul/rest/produto");
		ProdutoTO produto = new ProdutoTO(codigo, 500, 10, "Camiseta da Lenovo");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, produto);
		if (response.getStatus() == 201) {
			System.out.println("Sucesso! " + response.getLocation());
		} else {
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}
}
