package controllers;

import java.util.*;

import static serializers.UsuariosSerializar.findByIdSerializer;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.Random;

import com.fasterxml.jackson.*;

public class Perguntas extends InternalController {

    public static void getPerguntas(){
        List<Pergunta> perguntas = JPA.em().createNativeQuery("SELECT * from Pergunta", Pergunta.class).getResultList();

        Random gerador = new Random();

        int a, posicao;
        List<Integer> posicoes = new ArrayList<>();
        List<Pergunta> perguntasSelecionadas = new ArrayList<>();

        while (posicoes.size() < 5) {
            a = gerador.nextInt();
            if (a < 0) a = (a * -1);
            posicao = (a % perguntas.size());

            if(posicoes.size() == 0){
                posicoes.add(posicao);
            } else if (!posicoes.contains(posicao)){
                posicoes.add(posicao);
            }
        }

        for(int i = 0; i < 5; i++){
            perguntasSelecionadas.add(perguntas.get(posicoes.get(i)));
        }


        renderJSON(perguntasSelecionadas);
    }

    public static void postUsuario(){
        Usuario usuario = getBody(Usuario.class);

        Criptografia c = new Criptografia();
        usuario.senha = c.gerarHash(usuario.senha, usuario.senha);
        usuario.save();

        Mensagem m = new Mensagem("USUARIO CADASTRADO COM SUCESSO");
        renderJSON(m);
    }

}
