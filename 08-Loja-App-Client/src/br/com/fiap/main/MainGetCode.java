package br.com.fiap.main;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainGetCode {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);	
		Client client = Client.create();
		System.out.println("Digite o codigo do produto: ");
		int codigo = e.nextInt();
		
		WebResource resource = client.resource("http://localhost:8061/07-Loja-App-RESTFul/rest/produto/" + codigo);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() == 200) {
			ProdutoTO produto = response.getEntity(ProdutoTO.class);
			System.out.println(produto.getCodigo());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getQuantidade());
			System.out.println(produto.getPreco());
		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}
	}
}
