package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	public static ProdutoTO consultarProduto(int codigo){
		if(codigo==401){
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Branca" );
		} else if(codigo==402) {
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Azul" );
		} else if(codigo==403) {
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Rosa" );
		} else {
			return new ProdutoTO(-1, 0, 0, "Produto não encontrado" );
		}
	}

}
