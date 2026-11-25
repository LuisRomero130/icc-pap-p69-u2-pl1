package edu.ups.pap.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E04: Tramas de sensores. Contrato completo en README.md. */
public class Ejercicio04 {

    public static final Pattern REGEX = Pattern.compile(
            "(?:T(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;C"
            + "|H(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;PCT"
            + "|P(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;HPA)"
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