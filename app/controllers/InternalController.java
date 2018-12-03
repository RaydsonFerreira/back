package controllers;

import models.*;
import play.mvc.Before;
import play.mvc.Http;

public class InternalController extends GenericController {

//    @Before
//    public static void verificarAutenticacao() {
//
//        UsuarioSessao usuario = Auth.getUsuarioSessao(session.current());
//
//        if (usuario == null)
//            redirect(Login.LOGIN_URL);
//
//
//    }
//
//    protected static UsuarioSessao getUsuarioSessao() {
//
//        return Auth.getUsuarioSessao(session.current());
//    }
//
//    protected static void verificarPermissao(Acoes ... acoes) {
//
//        UsuarioSessao usuario = getUsuarioSessao();
//
//        boolean permitido = false;
//
//        for (Acoes acao : acoes)
//            permitido = permitido || usuario.possuiPermissao(acao);
//
//        if (!permitido) {
//
//            response.status = Http.StatusCode.FORBIDDEN;
//            renderJSON(new Mensagem("Você não possui permissão para efetuar esta ação."));
//        }
//    }
}