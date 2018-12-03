package serializers;

import utils.json.SerializerUtil;
import flexjson.JSONSerializer;

public class UsuariosSerializar {
    public static JSONSerializer findByIdSerializer = SerializerUtil.create(
            "id",
            "nome",
            "username"
    );
}