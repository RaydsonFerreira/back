package utils;

import play.i18n.Messages;

public enum Mensagens {

    ERRO_PADRAO,
    ERRO_VALIDACAO,
    OBJETO_NAO_ENCONTRADO,
    PERMISSAO_NEGADA;

    public String getTexto(Object ... args) {

        return Messages.get(name(), args);
    }
}
