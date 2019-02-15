package br.com.fiap.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TerminalConsulta {
	public static void main(String[] args) {
		
	Scanner e = new Scanner(System.in);
	int codigo =0;
	String descricao ="";
	String nomeLoja = "Loja do Fah";
	
	LocalDate hoje = LocalDate.now();
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	hoje.format(formatador);

	System.out.println("Digite o código do produto: ");
	codigo = e.nextInt();
	
	if(codigo==401){
		descricao="Camiseta Branca";
		System.out.println(descricao);
	} else if(codigo==402) {
		descricao="Camiseta Azul";
		System.out.println(descricao);
	} else if(codigo==403) {
		descricao="Camiseta Rosa";
		System.out.println(descricao);
	} else {
		System.out.println("Produto não encontrado");
	}
	
	
	System.out.println(nomeLoja + " " + "Data: " + hoje.format(formatador));
	
	e.close();
	}
	
	
	
}
