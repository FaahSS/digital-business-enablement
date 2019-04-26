package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.List;

public class EstoqueBO {
	private static EstoqueBO estoqueBo;
	private static ArrayList<ProdutoTO> lista = null;

	// Singleton
	public static EstoqueBO getInstance() {
		if (estoqueBo == null) {
			estoqueBo = new EstoqueBO();
		}
		return estoqueBo;
	}

	public EstoqueBO() {
		lista = new ArrayList<ProdutoTO>();
//		lista.add(EstoqueBO.consultarProduto(401));
//		lista.add(EstoqueBO.consultarProduto(402));
//		lista.add(EstoqueBO.consultarProduto(403));
		lista.add(new ProdutoTO(401, 2.99, 100, "Camiseta Branca"));
		lista.add(new ProdutoTO(402, 2.99, 100, "Camiseta Vermelho"));
		lista.add(new ProdutoTO(403, 2.99, 100, "Camiseta Preta"));
		System.out.println("Construiu!");
	}

	// public static ProdutoTO consultarProduto(int codigo) {
	// if (codigo == 401) {
	// return new ProdutoTO(codigo, 2.99, 4, "Camiseta Branca");
	// } else if (codigo == 402) {
	// return new ProdutoTO(codigo, 2.99, 4, "Camiseta Azul");
	// } else if (codigo == 403) {
	// return new ProdutoTO(codigo, 2.99, 4, "Camiseta Rosa");
	// } else {
	// return new ProdutoTO(-1, 0, 0, "Produto não encontrado");
	// }
	// }
	public static ProdutoTO consultarProduto(int codigo) {
		for (ProdutoTO produto : lista) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}

	public List<ProdutoTO> listar() {

		// ArrayList<ProdutoTO> lista = new ArrayList<ProdutoTO>();
		// lista.add(new ProdutoTO(1, 4000, 10, "Galaxy S9+"));
		// lista.add(new ProdutoTO(2, 6000, 2, "Galaxy S10+"));
		// lista.add(new ProdutoTO(3, 8000, 15, "iPhone X"));
		// lista.add(EstoqueBO.consultarProduto(401));
		// lista.add(EstoqueBO.consultarProduto(402));
		// lista.add(EstoqueBO.consultarProduto(403));
		return lista;

	}

	public void cadastrar(ProdutoTO produto) {
		System.out.println("Gravou!");
		lista.add(produto);

	}

	public void remover(int codigo) {
		for (ProdutoTO produto : lista) {
			if (produto.getCodigo() == codigo) {
				lista.remove(produto);
				break;
			}
		}
	}

	public void atualizar(ProdutoTO produto) {
		for (ProdutoTO produto2 : lista) {
			if(produto2.getCodigo() == produto.getCodigo()) {
			produto2.setDescricao(produto.getDescricao());
			produto2.setPreco(produto.getPreco());
			produto2.setQuantidade(produto.getQuantidade());
			break;
			}
		}
	}

}
