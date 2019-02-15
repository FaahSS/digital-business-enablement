package br.com.fiap.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.PropertySingleton;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {

		Scanner e = new Scanner(System.in);
		int codigo = 0;
		String nome = PropertySingleton.getInstance().getProperty("nome");
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o código do produto: ");
		codigo = e.nextInt();
		e.close();

		ProdutoTO produto = EstoqueBO.consultarProduto(codigo);
		System.out.println(produto.getDescricao());

	}

}
