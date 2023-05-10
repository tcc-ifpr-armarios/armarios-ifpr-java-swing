package br.edu.ifpr.paranavai.armarios.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class AutenticacaoUtil {

    public static final String CHAVE_PRIVADA = "ArmariosIFPR-Paranvaí";
    
    public static String converteSenhaParaSha256Hex (String senha){
        String senhaComChavePrivada = CHAVE_PRIVADA + senha + CHAVE_PRIVADA;
        return DigestUtils.sha256Hex(senhaComChavePrivada);
    }
    
    
}
