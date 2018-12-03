package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;

import javax.persistence.*;

import models.*;

public class Application extends Controller {

    public static void index() {
//        Usuario user = new Usuario("Raydson","ray","minhaSenha");
//        user.save();
//
//        Usuario user2 = new Usuario("Salgado","salgado","senhadele");
//        user2.save();
//
//        Organizacao org = new Organizacao("lar dos idoso", "lar@lar", "rua das madeira, 203", "lar dos idoso de lavras", "2333423", "minhasenha");
//        org.save();
//
//        Organizacao org2 = new Organizacao("lar das idosa", "lardasidosa@idosa", "rua martin", "lar que abriga as idosa", "123 445", "minhasenha");
//        org2.save();
//
//        Evento evento = new Evento(org, new Date(), "rua das ostras", "evento beneficente");
//        evento.save();
//
//        Evento evento2 = new Evento(org2, new Date(), "rua das pedras", "evento pra crianças");
//        evento2.save();
//
//        UsuarioEvento ue= new UsuarioEvento(user, evento2);
//        ue.save();
//
//        UsuarioEvento ue2 = new UsuarioEvento(user2, evento);
//        ue2.save();

        List<Usuario> ues = JPA.em().createNativeQuery("SELECT * from Usuario", Usuario.class).getResultList();

        renderJSON(ues);
    }

}