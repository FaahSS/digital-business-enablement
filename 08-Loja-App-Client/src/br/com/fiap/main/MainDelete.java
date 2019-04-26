package br.com.fiap.main;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainDelete {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		Client client = Client.create();
		System.out.println("Digite o código para deletar o produto: ");
		int codigo = e.nextInt();
		WebResource webResource = client.resource("http://localhost:8061/07-Loja-App-RESTFul/rest/produto/" + codigo);
		ClientResponse response = webResource.delete(ClientResponse.class);
		if (response.getStatus() == 204) {
			System.out.println("Sucesso! ");
		} else {
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}

}
