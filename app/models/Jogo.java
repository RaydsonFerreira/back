package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Jogo extends GenericModel {
    @Id
    @Column(name = "id_jogo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario_envio",nullable=false)
    public Usuario usuarioEnvio;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario_recibo",nullable=false)
    public Usuario usuarioRecibo;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta_resposta_1",nullable=false)
    public PerguntaResposta perguntaResposta1;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta_resposta_2",nullable=false)
    public PerguntaResposta perguntaResposta2;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta_resposta_3",nullable=false)
    public PerguntaResposta perguntaResposta3;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta_resposta_4",nullable=false)
    public PerguntaResposta perguntaResposta4;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_pergunta_resposta_5",nullable=false)
    public PerguntaResposta perguntaResposta5;

    @Column(name="fl_ativo")
    public Boolean ativo;

    public Jogo(Usuario usuarioEnvio, Usuario usuarioRecibo, PerguntaResposta perguntaResposta1, PerguntaResposta perguntaResposta2, PerguntaResposta perguntaResposta3, PerguntaResposta perguntaResposta4, PerguntaResposta perguntaResposta5, Boolean ativo) {
        this.usuarioEnvio = usuarioEnvio;
        this.usuarioRecibo = usuarioRecibo;
        this.perguntaResposta1 = perguntaResposta1;
        this.perguntaResposta2 = perguntaResposta2;
        this.perguntaResposta3 = perguntaResposta3;
        this.perguntaResposta4 = perguntaResposta4;
        this.perguntaResposta5 = perguntaResposta5;
        this.ativo = ativo;
    }
}
