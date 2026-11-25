package edu.ups.pap.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E03: Correos institucionales. Contrato completo en README.md. */
public class Ejercicio03 {

    public static final Pattern REGEX = Pattern.compile(
            "(?i)(?!.*\\.\\.)[a-z0-9](?:[a-z0-9._-]*[a-z0-9])?@(?:ups\\.edu\\.ec|est\\.ups\\.edu\\.ec)"
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