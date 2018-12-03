package utils;

import java.io.File;

import play.Play;

public class Configuracoes {

    public static final File PASTA_TEMP = new File(Play.applicationPath + "/tmp/arquivos");

    public static final File PASTA_ARQUIVOS = new File(Play.configuration.getProperty("arquivos.path"));

    public static final String DATE_FORMAT = Play.configuration.getProperty("date.format");

    public static final String VERSAO = Play.configuration.getProperty("app_version");
}
