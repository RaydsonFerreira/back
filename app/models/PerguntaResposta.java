package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
@Table(name = "pergunta_resposta")
public class PerguntaResposta extends GenericModel {
    @Id
    @Column(name = "id_pergunta_resposta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta",nullable=false)
    public Pergunta pergunta;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_resposta")
    public Resposta resposta;

    public PerguntaResposta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public PerguntaResposta(Pergunta pergunta, Resposta resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
}
