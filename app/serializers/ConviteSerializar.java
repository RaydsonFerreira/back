package serializers;

import utils.json.SerializerUtil;
import flexjson.JSONSerializer;

public class ConviteSerializar {
    public static JSONSerializer findByStatusSerializer = SerializerUtil.create(
            "status"
    );
}