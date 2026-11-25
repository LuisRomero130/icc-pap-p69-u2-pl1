package edu.ups.pap.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E05: Direcciones IPv4. Contrato completo en README.md. */
public class Ejercicio05 {

    private static final String OCTETO = "(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])";
    public static final Pattern REGEX = Pattern.compile(
            OCTETO + "\\." + OCTETO + "\\." + OCTETO + "\\." + OCTETO
    );

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