package com.rcintra.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(
        name="findProdutoByNome",
        query="SELECT p FROM Produto p WHERE p.nome = :prodName"
)
@Entity
@Table(name = "DMN_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = -6186201427148255910L;
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
