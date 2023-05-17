/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import modelo.Pessoa;
import persistencia.ConexaoBD;

/**
 *
 * @author Laris
 */
public class Main {

    public static void main(String[] args) {
        ConexaoBD.getConnection();
        
        /*Pessoa p = new Pessoa();
        
        p.setNome("Larissá Braun");
        p.setCpf("11111111111");
        p.setTelefone("(045) 99999-9999");
        p.setEmail(null);
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            System.out.println(violation.getMessage());
        }*/
    }
    
}
