package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	private static Logger log = Logger.getLogger(EstoqueBO.class);
	public static ProdutoTO consultarProduto(int codigo){
		if(codigo==401){
			log.debug(codigo + " - Camiseta Branca");
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Branca" );
		} else if(codigo==402) {
			log.debug(codigo + " - Camiseta Azul");
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Azul" );
		} else if(codigo==403) {
			log.debug(codigo + " - Camiseta Rosa");
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Rosa" );
		} else {
			log.error(codigo + " - Produto não encontrado");
			return new ProdutoTO(-1, 0, 0, "Produto não encontrado" );
		}
	}

}
