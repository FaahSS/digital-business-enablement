package br.com.fiap.bean;

public class Usuario {
private String nome;
private String id;


public Usuario() {
	super();
}
public Usuario(String nome, String id) {
	super();
	this.nome = nome;
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


}
