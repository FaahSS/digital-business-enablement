package br.com.fiap.bean;

public class Forma {
	private int id;
	private String nome;
	
	//Constructors
		public Forma() {
			super();
		}
		public Forma(int id, String nome) {
			super();
			this.id = id;
			this.nome = nome;
		}
		
		//Getters & Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

}
