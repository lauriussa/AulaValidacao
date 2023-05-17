/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.excecoes;

import java.util.Set;
import javax.validation.ConstraintViolation;
import modelo.Pessoa;

/**
 *
 * @author Laris
 */
public class ExceptionCadastroPessoa extends Exception {
    
    public ExceptionCadastroPessoa(String mensagem) {
         super(mensagem);
    }
    
    public ExceptionCadastroPessoa(String mensagem, Set<ConstraintViolation<Pessoa>> violations) {
         super(mensagem + getViolations(violations));
    }

    private static String getViolations(Set<ConstraintViolation<Pessoa>> violations) {
        String msg = "";
        if (violations == null || violations.isEmpty()) {
            return msg;
        }
        for (ConstraintViolation<Pessoa> violation : violations) {
            msg += "\n" + violation.getMessage();
        }
        return msg;
    }
    
}
