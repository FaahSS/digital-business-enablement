package br.com.fiap.loja.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	public static ProdutoTO consultarProduto(int codigo) throws AxisFault{
		if(codigo==401){
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Branca" );
		} else if(codigo==402) {
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Azul" );
		} else if(codigo==403) {
			return new ProdutoTO(codigo, 2.99, 4, "Camiseta Rosa" );
		} else if(codigo==404){
			return new ProdutoTO(codigo, 4.99, 4, "Camiseta Amarelo Roxa Indigo");
		}else {
			throw new AxisFault("Produto não encontrado!");
		}
	}

}
