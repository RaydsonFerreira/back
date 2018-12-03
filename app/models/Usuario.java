package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Usuario extends GenericModel {
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "nm_usuario")
    public String nome;

	@Column(name = "usr_usuario")
    public String username;

	@Column(name = "senha_usuario")
    public String senha;


    
    public Usuario(String nome, String username, String senha) {
    	this.nome = nome;
    	this.username = username;
    	this.senha = senha;
    }
}
