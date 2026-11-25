package edu.ups.pap.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E02: Códigos de dispositivos. Contrato completo en README.md. */
public class Ejercicio02 {

    public static final Pattern REGEX = Pattern.compile("[THP](?!000)[0-9]{3}");

    public static boolean validar(String texto) {
        if (texto == null) {
            return false;
        }
        Matcher matcher = REGEX.matcher(texto);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}