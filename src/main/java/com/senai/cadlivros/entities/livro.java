package com.senai.cadlivros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class livro {
	// Id , descrição ,isbn
		// atributos
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String descrição;

		private String isbn;

		// construtor vazio
		public livro() {

		}

		// construtor com parametros
		public livro(Long id, String descrição, String isbn) {
			super();
			this.id = id;
			this.descrição = descrição;
			this.isbn = isbn;
		}

		// método de acesso
		public Long getid() {
			return id;
		}

		public void setid(Long id) {
			this.id = id;
		}

		// método de acesso
		public String getdescrição() {
			return descrição;
		}

		public void setdescrição(String descrição) {
			this.descrição = descrição;
		}

		// método de acesso
		public String getisbn() {
			return isbn;
		}

		public void setisbn(String isbn) {
			this.isbn = isbn;
		}
}
