package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Resposta extends GenericModel {
    @Id
    @Column(name = "id_resposta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario_Respondente",nullable=false)
    public Usuario usuarioRespondente;

    @Column(name = "alternativa")
    public String alternativa;

    public Resposta(Usuario usuarioRespondente, String alternativa) {
        this.usuarioRespondente = usuarioRespondente;
        this.alternativa = alternativa;
    }
}
