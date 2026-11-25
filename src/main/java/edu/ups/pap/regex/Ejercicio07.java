package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E07: Extracción de tramas. Contrato completo en README.md. */
public class Ejercicio07 {

    public static final String TRAMA =
            "(?:T(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;C"
            + "|H(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;PCT"
            + "|P(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;HPA)";

    public static final String DELIMITADOR = "(?:[ \\t\\n\\r\\u000B\\f\\[\\]()\\{\\}])";

    public static final Pattern REGEX = Pattern.compile(
            "(?:^|" + DELIMITADOR + ")(" + TRAMA + ")(?=$|" + DELIMITADOR + ")"
    );

    public static List<String> extraer(String texto) {
        List<String> tramas = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            return tramas;
        }
        Matcher matcher = REGEX.matcher(texto);
        while (matcher.find()) {
            tramas.add(matcher.group(1));
        }
        return tramas;
    }
}