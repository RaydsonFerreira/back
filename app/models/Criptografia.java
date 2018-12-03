package models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

public class Criptografia {

    private static final String ALGORITMO_SALT = "SHA1PRNG";
    private static final String ALGORITMO_SENHA = "SHA-1";

    public static String gerarHash(String senha, String salt)  {

        try {
            MessageDigest condensador = MessageDigest.getInstance(ALGORITMO_SENHA);

            condensador.reset();
            condensador.update(toBytes(salt));

            byte[] hash = condensador.digest(senha.getBytes("UTF-8"));

            for (int i = 0; i < 100; i++) {
                condensador.reset();
                hash = condensador.digest(hash);
            }

            return toBase64(hash);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static String gerarSalt() {

        try {
            byte[] salt = new byte[8];
            SecureRandom random = SecureRandom.getInstance(ALGORITMO_SALT);
            random.nextBytes(salt);
            return toBase64(salt);

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }
    }

    private static String toBase64(byte[] bytes) {

        return DatatypeConverter.printBase64Binary(bytes);
    }

    private static byte[] toBytes(String base64) {

        return DatatypeConverter.parseBase64Binary(base64);
    }
}