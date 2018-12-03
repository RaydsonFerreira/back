package utils.json;

import java.util.Date;

import play.Play;
import play.Play.Mode;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import flexjson.transformer.Transformer;

public class SerializerUtil {

    private static final String DATE_FORMAT = Play.configuration.getProperty("date.format");
    private static final String DATETIME_FORMAT = Play.configuration.getProperty("datetime.format");

    public static JSONSerializer create(String... includes) {

        boolean prettyPrint = Play.mode == Mode.DEV;

        return new JSONSerializer()
                .include(includes)
                .exclude("*")
                .prettyPrint(prettyPrint)
                .transform(getDateTransformer(), Date.class);
    }

    public static Transformer getDateTransformer() {

        return new DateTransformer(DATE_FORMAT);
    }

    public static Transformer getDateTimeTransformer() {

        return new DateTransformer(DATETIME_FORMAT);
    }
}

