package br.edu.ifpr.paranavai.armarios.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author professor Marcelo Figueiredo Terenciani
 */
public class OperacaoUtil {

    public static String EDITAR = "Editar";
    public static String SALVAR = "Salvar";
    public static String EXCLUIR = "Excluir";
    public static String DETALHES = "Detalhes";

    public static boolean ehEmailValido(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean ehTelefoneValido(String telefone) {
        String regex = "^\\(\\d{2}\\) \\d \\d{4}-\\d{4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);

        return matcher.matches();
    }

    public static String formatarDataHora(LocalDateTime dataCriacao) {
        if (dataCriacao == null) {
            return "Ocupado";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            return dataCriacao.format(formatter);
        }
    }

    public static LocalDateTime formatarDataHoraLocalDateTime(LocalDateTime dataCriacao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dataCriacao.format(formatter), formatter);
    }
}
