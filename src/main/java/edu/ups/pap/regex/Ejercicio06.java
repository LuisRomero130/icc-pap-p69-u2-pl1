package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E06: Palabras dentro de un texto. Contrato completo en README.md. */
public class Ejercicio06 {

    public static final Pattern PALABRA_VALIDA = Pattern.compile("[A-Za-z]+");

    public static List<String> buscar(String texto, String palabra) {
        List<String> coincidencias = new ArrayList<>();
        if (texto == null || texto.isEmpty() || palabra == null || palabra.isEmpty()) {
            return coincidencias;
        }
        Matcher validador = PALABRA_VALIDA.matcher(palabra);
        if (!validador.matches()) {
            return coincidencias;
        }

        Pattern patron = Pattern.compile(
                "(?<![A-Za-z0-9_])" + Pattern.quote(palabra) + "(?![A-Za-z0-9_])",
                Pattern.CASE_INSENSITIVE
        );
        Matcher matcher = patron.matcher(texto);
        while (matcher.find()) {
            coincidencias.add(matcher.group());
        }
        return coincidencias;
    }
}