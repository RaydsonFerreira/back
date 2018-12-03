package controllers;

import java.util.List;

import java.security.MessageDigest;

import static serializers.UsuariosSerializar.findByIdSerializer;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

import com.fasterxml.jackson.*;

public class Usuarios extends InternalController {

    public static void getUsuario(int id_usuario){
        Usuario usuario = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_usuario, Usuario.class).getSingleResult();
        renderJSON(findByIdSerializer.serialize(usuario));
    }

    public static void getUsuarios(){
        List<Usuario> ues = JPA.em().createNativeQuery("SELECT * from Usuario", Usuario.class).getResultList();
        renderJSON(ues);
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
