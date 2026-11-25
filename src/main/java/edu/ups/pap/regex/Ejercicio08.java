package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E08: Análisis de registros. Contrato completo en README.md. */
public class Ejercicio08 {

    public static final String OCTETO = "(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])";
    public static final String IP = OCTETO + "\\." + OCTETO + "\\." + OCTETO + "\\." + OCTETO;
    public static final String VALOR = "-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?";

    public static final String TRAMA_GRUPOS =
            "(?:(T(?!000)[0-9]{3});(" + VALOR + ");(C)"
            + "|(H(?!000)[0-9]{3});(" + VALOR + ");(PCT)"
            + "|(P(?!000)[0-9]{3});(" + VALOR + ");(HPA))";

    public static final Pattern REGEX = Pattern.compile(
            "(INFO|WARN|ERROR) (" + IP + ") " + TRAMA_GRUPOS
    );

    public static List<String> analizar(String texto) {
        List<String> registros = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            return registros;
        }

        String[] lineas = texto.split("\\r?\\n", -1);
        for (String linea : lineas) {
            if (linea.isEmpty()) {
                continue;
            }
            Matcher matcher = REGEX.matcher(linea);
            if (matcher.matches()) {
                String nivel = matcher.group(1);
                String ip = matcher.group(2);
                String codigo = null;
                String valor = null;
                String unidad = null;

                if (matcher.group(3) != null) {
                    codigo = matcher.group(3);
                    valor = matcher.group(4);
                    unidad = matcher.group(5);
                } else if (matcher.group(6) != null) {
                    codigo = matcher.group(6);
                    valor = matcher.group(7);
                    unidad = matcher.group(8);
                } else if (matcher.group(9) != null) {
                    codigo = matcher.group(9);
                    valor = matcher.group(10);
                    unidad = matcher.group(11);
                }

                if (codigo != null) {
                    registros.add(nivel + "|" + ip + "|" + codigo + "|" + valor + "|" + unidad);
                }
            }
        }
        return registros;
    }
}