package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.security.MessageDigest;

//import static serializers.ConviteSerializar.findByStatusSerializer;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

import com.fasterxml.jackson.*;

public class Jogos extends InternalController {

    public static void novoJogo(int id_envio, int id_recibo){
        System.out.println("HERE");

//        Usuario usuario_envio = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_envio, Usuario.class).getSingleResult();
//        Usuario usuario_recibo = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_recibo, Usuario.class).getSingleResult();

        List<Pergunta> perguntas = getPerguntas();

        PerguntaResposta pr1 = new PerguntaResposta(perguntas.get(0));
        PerguntaResposta pr2 = new PerguntaResposta(perguntas.get(1));
        PerguntaResposta pr3 = new PerguntaResposta(perguntas.get(2));
        PerguntaResposta pr4 = new PerguntaResposta(perguntas.get(3));
        PerguntaResposta pr5 = new PerguntaResposta(perguntas.get(4));
//        Jogo jogo = new Jogo(usuario_envio, usuario_recibo, pr1, pr2, pr3, pr4, pr5, true);

//        jogo.save();

//        renderJSON(jogo);
    }

    public static List<Pergunta> getPerguntas() {
        List<Pergunta> perguntas = JPA.em().createNativeQuery("SELECT * from Pergunta", Pergunta.class).getResultList();

        Random gerador = new Random();

        int a, posicao;
        List<Integer> posicoes = new ArrayList<>();
        List<Pergunta> perguntasSelecionadas = new ArrayList<>();

        while (posicoes.size() < 5) {
            a = gerador.nextInt();
            if (a < 0) a = (a * -1);
            posicao = (a % perguntas.size());

            if (posicoes.size() == 0) {
                posicoes.add(posicao);
            } else if (!posicoes.contains(posicao)) {
                posicoes.add(posicao);
            }
        }

        for (int i = 0; i < 5; i++) {
            perguntasSelecionadas.add(perguntas.get(posicoes.get(i)));
        }

        return perguntasSelecionadas;
    }

    public static void getJogo(int id_envio, int id_recibo){
        try {
            Jogo jogo = (Jogo) JPA.em().createNativeQuery("SELECT * from Jogo j WHERE j.fk_id_usuario_envio = " + id_envio + " AND j.fk_id_usuario_recibo = " + id_recibo + " AND j.fl_ativo = true", Jogo.class).getSingleResult();
            renderJSON(jogo);
        } catch (Exception e) {
            renderJSON(new Mensagem("jogo ainda não criado!"));
        }
    }

    public static void responder(String body, int id_jogo, int id_user, int id_pergunta_resposta){
        Usuario usuario = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_user, Usuario.class).getSingleResult();

        Resposta resposta = new Resposta(usuario, body);

        resposta.save();

        int a = JPA.em().createNativeQuery("UPDATE pergunta_resposta SET fk_id_resposta = " + resposta.id + " WHERE id_pergunta_resposta = " + id_pergunta_resposta, PerguntaResposta.class).executeUpdate();


        renderJSON(new Mensagem("respondido com sucesso"));
    }

    public static  void finalizar (int id_jogo) {
        try {
            int a = JPA.em().createNativeQuery("UPDATE jogo SET fl_ativo = false WHERE id_jogo = " + id_jogo, Jogo.class).executeUpdate();
            renderJSON(new Mensagem("Jogo Finalizado"));
        }catch (Exception e){
            renderJSON(new Mensagem("Erro ao finalizar"));
        }
    }

    public static void monitorar(){
        PerguntaResposta pr = (PerguntaResposta) JPA.em().createNativeQuery("SELECT * FROM pergunta_resposta pr WHERE pr.id_pergunta_resposta = " + 1, PerguntaResposta.class).getSingleResult();

        renderJSON(pr);
    }
//
//    public static void RecusarConvite(int id_envio, int id_recibo){
//        int a = JPA.em().createNativeQuery("UPDATE Convite SET status = 'Recusado' WHERE fk_id_usuario_envio = " + id_envio + " AND fk_id_usuario_recibo = " + id_recibo, Convite.class).executeUpdate();
//
//        renderJSON(new Mensagem("Convite Recusado"));
//    }
//
//    public static void getStatusConvite(int id_envio, int id_recibo){
//        Convite c = (Convite) JPA.em().createNativeQuery("SELECT * FROM Convite c WHERE c.fk_id_usuario_envio = " + id_envio + " AND c.fk_id_usuario_recibo = " + id_recibo, Convite.class).getSingleResult();
//
//        renderJSON(findByStatusSerializer.serialize(c));
//    }
}
