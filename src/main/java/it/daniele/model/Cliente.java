package it.daniele.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	private Integer id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	@Column(name="nome", nullable=false, length=50)
	public String getNome() {
		return nome;
	}
	
	@Column(name="cognome", nullable=false, length=50)
	public String getCognome() {
		return cognome;
	}
	
	@Column(name="username", unique=true, nullable=false, length=50)
	public String getUsername() {
		return username;
	}
	
	@Column(name="password", nullable=false, length=50)
	public String getPassword() {
		return password;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Dettagli cleinte: [Id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", username=" + username  + "]";
	}
	
	

}
