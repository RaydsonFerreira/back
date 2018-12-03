package serializers;

import utils.json.SerializerUtil;
import flexjson.JSONSerializer;

public class AmigoSerializar {
    public static JSONSerializer findByAmigosSerializer = SerializerUtil.create(
            "id",
            "usuario2.id",
            "usuario2.nome",
            "usuario2.username"
    );
}