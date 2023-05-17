/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laris
 */
public class PessoaTest {
    
    private static ValidatorFactory factory;
    private static Validator validator;
    
    public PessoaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testarNomeEmBranco(){
        
        Pessoa p = new Pessoa();
        p.setNome("    ");
        
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            if(violation.getPropertyPath().toString().equalsIgnoreCase("nome")){
                System.out.println(violation.getMessage());
                if(violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank){
                    assertTrue("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if(violation.getConstraintDescriptor().getAnnotation() instanceof Size){
                    assertFalse("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }      
        }
        
    }
    
}
    
    @Test
    public void testarQtdadeCaracteresNome(){
        Pessoa p = new Pessoa();
        p.setNome("la");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            if(violation.getPropertyPath().toString().equalsIgnoreCase("nome")){
                System.out.println(violation.getMessage());
                if(violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank){
                    assertFalse("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if(violation.getConstraintDescriptor().getAnnotation() instanceof Size){
                    assertTrue("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }      
        }
        
    }
  }
    
    @Test
    public void testarNomeValido(){
        Pessoa p = new Pessoa();
        
        p.setNome("Larissa");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            assertFalse("Validar nome", violation.getPropertyPath().toString().equalsIgnoreCase("nome"));      
    }
        
        p.setNome("LarissaBraunLarissaBraunLarissaBraunLarissaBraunLarissaBraunLarissaBraunLarissaBraunBraunn");
        violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            assertFalse("Validar nome", violation.getPropertyPath().toString().equalsIgnoreCase("nome"));      
    }
    }
    
    @Test
    public void testarCPFEmBranco(){
        
        Pessoa p = new Pessoa();
        p.setCpf("           ");
        
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        for(ConstraintViolation<Pessoa> violation : violations){
            if(violation.getPropertyPath().toString().equalsIgnoreCase("cpf")){
                System.out.println(violation.getMessage());
                if(violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank){
                    assertTrue("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if(violation.getConstraintDescriptor().getAnnotation() instanceof Size){
                    assertFalse("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }      
        }
        
    }
        
    }
}
