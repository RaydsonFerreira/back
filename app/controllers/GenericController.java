package controllers;

import java.io.File;
import java.io.IOException;

import models.Mensagem;

import org.hibernate.Session;

import play.db.jpa.JPA;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Http.StatusCode;
import utils.Configuracoes;
import utils.Mensagens;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenericController extends Controller {

    private static GsonBuilder gsonBuilder = new GsonBuilder();
//            .setDateFormat(Configuracoes.DATE_FORMAT);

//    @Before
//    public static void before() {
//
//        ((Session) JPA.em().getDelegate());
//                .enableFilter("ativos")
//                .setParameter("ativo", true);
//    }

    protected static <T> T getBody(Class<T> clazz) {

        String body = Request.current().params.get("body");
        JsonElement jsonElem = new JsonParser().parse(body);
        Gson gson = gsonBuilder.create();

        if (jsonElem.isJsonObject()) {

            JsonObject json = (JsonObject) jsonElem;
            return gson.fromJson(json, clazz);

        } else if (jsonElem.isJsonArray()) {

            return gson.fromJson(jsonElem.getAsJsonArray(), clazz);
        }

        return null;
    }

    protected static void renderImage(File file) throws IOException {

        if(file.exists() || file.getAbsoluteFile().exists()){

            response.setHeader("Cache-Control", "max-age=0");
            response.setHeader("Content-Type", "image/jpg");
            renderBinary(file);
        }
    }

    protected static void renderMensagem(Mensagens msg) {

        renderJSON(new Mensagem(msg.getTexto()));
    }

    protected static void renderError(Mensagens msg) {

        response.status = StatusCode.INTERNAL_ERROR;
        renderMensagem(msg);
    }

    protected static void returnIfNull(Object ... objects) {

        for (Object obj : objects) {

            if (obj == null) {

                renderError(Mensagens.OBJETO_NAO_ENCONTRADO);
            }
        }
    }
}
