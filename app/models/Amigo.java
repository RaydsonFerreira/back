package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Amigo extends GenericModel {
    @Id
    @Column(name = "id_amigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario1",nullable=false)
    public Usuario usuario1;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario2",nullable=false)
    public Usuario usuario2;



    public Amigo(Usuario usuario1, Usuario usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }
}
