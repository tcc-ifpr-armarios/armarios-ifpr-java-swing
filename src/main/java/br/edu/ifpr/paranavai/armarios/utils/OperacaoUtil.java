package br.edu.ifpr.paranavai.armarios.utils;

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
}
