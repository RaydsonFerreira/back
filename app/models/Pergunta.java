package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Pergunta extends GenericModel {
    @Id
    @Column(name = "id_pergunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "questao")
    public String questao;

    @Column(name = "alternativa_a")
    public String alternativaA;

    @Column(name = "alternativa_b")
    public String alternativaB;

    @Column(name = "alternativa_c")
    public String alternativaC;

    @Column(name = "alternativa_d")
    public String alternativaD;

    @Column(name = "alternativa_Correta")
    public String alternativaCorreta;

    public Pergunta(String questao, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String alternativaCorreta) {
        this.questao = questao;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD= alternativaD;
        this.alternativaCorreta = alternativaCorreta;
    }
}
