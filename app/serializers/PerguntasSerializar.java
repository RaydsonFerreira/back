package serializers;

import utils.json.SerializerUtil;
import flexjson.JSONSerializer;

public class PerguntasSerializar {
    public static JSONSerializer findByIdSerializer = SerializerUtil.create(
        "questao",
        "alternativa_a",
        "alternativa_b",
        "alternativa_c",
        "alternativa_d",
        "alternativa_Correta"
    );
}