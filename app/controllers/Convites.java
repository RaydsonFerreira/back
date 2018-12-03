package controllers;

import java.util.List;

import java.security.MessageDigest;

import static serializers.ConviteSerializar.findByStatusSerializer;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

import com.fasterxml.jackson.*;

public class Convites extends InternalController {

    public static void convidar(int id_envio, int id_recibo){

        Usuario usuario_envio = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_envio, Usuario.class).getSingleResult();
        Usuario usuario_recibo = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id_usuario = " + id_recibo, Usuario.class).getSingleResult();

        Convite c = new Convite(usuario_envio, usuario_recibo, "Aguardando");

        c.save();

        Mensagem m = new Mensagem("Convite enviado com sucesso");

        renderJSON(m);
    }

    public static void convites(){
        List<Convite> c = JPA.em().createNativeQuery("SELECT * from Convite c", Convite.class).getResultList();
        renderJSON(c);
    }

    public static void AceitarConvite(int id_envio, int id_recibo){
        int a = JPA.em().createNativeQuery("UPDATE Convite SET status = 'Aceito' WHERE fk_id_usuario_envio = " + id_envio + " AND fk_id_usuario_recibo = " + id_recibo, Convite.class).executeUpdate();

        renderJSON(new Mensagem("Convite Aceito"));
    }

    public static void CancelarConvite(int id_envio, int id_recibo){
        int a = JPA.em().createNativeQuery("UPDATE Convite SET status = 'Cancelado' WHERE fk_id_usuario_envio = " + id_envio + " AND fk_id_usuario_recibo = " + id_recibo, Convite.class).executeUpdate();

        renderJSON(new Mensagem("Convite Cancelado"));
    }

    public static void RecusarConvite(int id_envio, int id_recibo){
        int a = JPA.em().createNativeQuery("UPDATE Convite SET status = 'Recusado' WHERE fk_id_usuario_envio = " + id_envio + " AND fk_id_usuario_recibo = " + id_recibo, Convite.class).executeUpdate();

        renderJSON(new Mensagem("Convite Recusado"));
    }

    public static void getStatusConvite(int id_envio, int id_recibo){
        Convite c = (Convite) JPA.em().createNativeQuery("SELECT * FROM Convite c WHERE c.fk_id_usuario_envio = " + id_envio + " AND c.fk_id_usuario_recibo = " + id_recibo, Convite.class).getSingleResult();

        renderJSON(findByStatusSerializer.serialize(c));
    }
}
