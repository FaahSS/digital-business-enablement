package br.com.fiap.main;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoTO implements Serializable{
	private int codigo;
	private double preco;
	private int quantidade;
	private String descricao;

	public ProdutoTO() {
	}

	public ProdutoTO(int codigo, double preco, int quantidade, String descricao) {
		setCodigo(codigo);
		setPreco(preco);
		setQuantidade(quantidade);
		setDescricao(descricao);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
