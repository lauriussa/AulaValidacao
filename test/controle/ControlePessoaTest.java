/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controle;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import modelo.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Endereco;

/**
 *
 * @author Laris
 */
public class ControlePessoaTest {
    
    public ControlePessoaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream(getDados().getBytes());
        System.setIn(inputStream);
    }
    
    @After
    public void tearDown() {
        System.setIn(null);
    }
    
    public String getDados(){
        StringBuilder builder = new StringBuilder();
        builder.append("Larissa\n");
        builder.append("11111111111\n");
        builder.append("larissa@gmail.com\n");
        builder.append("(045)99902-0291\n");
        return builder.toString();
    }

    /**
     * Test of cadastrar method, of class ControlePessoa.
     */
    @Test
    public void testeSetDados(){
        Pessoa pessoaTeste = new Pessoa();
        Pessoa pessoaAux = new Pessoa(null, "Larissa", "11111111111", 
                "larissa@gmail.com", "(045)99902-0291", new Endereco());
        ControlePessoa controle = new ControlePessoa();
        controle.setarDados(pessoaTeste);
        
        //assertEquals("larissa", pessoaTeste.getNome());
        assertEquals(pessoaAux, pessoaTeste);
        
    }
}
