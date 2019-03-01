package br.com.fiap.loja.main;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class Teste {
	public static void main(String[] args) throws RemoteException {

		int codigo = 0;
		String descricao = "";
		String nomeLoja = "Loja do Fah";

		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		System.out.println(nomeLoja + " " + "Data: " + hoje.format(formatador));

		System.out.println("Digite o código do produto: ");
		Scanner e = new Scanner(System.in);
		codigo = e.nextInt();
		e.close();

		EstoqueBOStub stub = new EstoqueBOStub();
		ConsultarProduto consulta = new ConsultarProduto();
		consulta.setCodigo(codigo);
		stub.consultarProduto(consulta);
		ConsultarProdutoResponse response = stub.consultarProduto(consulta);
		ProdutoTO produto = response.get_return();

		System.out.println();
		System.out.println("Produto: " + produto.getDescricao());
		

	}

}
