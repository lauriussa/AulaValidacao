/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import modelo.Endereco;
import modelo.Pessoa;
import persistencia.DaoEndereco;
import util.Input;

/**
 *
 * @author Laris
 */
public class ControleEndereco {
    
    private DaoEndereco dao;
    
    public ControleEndereco(){
        dao = new DaoEndereco();
    }
    
    public void cadastar(){
        Endereco endereco = new Endereco();
    }
    
    public void setarDados(Endereco endereco){
        System.out.println("Informe a cidade: ");
        endereco.setCidade(Input.nextLine());
        System.out.println("Informe o bairro: ");
        endereco.setBairro(Input.nextLine());
        System.out.println("Informe a rua: ");
        endereco.setRua(Input.nextLine());
        System.out.println("Informe o numero: ");
        endereco.setNumero(Input.next());
    }
    
    public boolean cadastroValido(Endereco endereco){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
        
        return !violations.isEmpty();
    }
}
