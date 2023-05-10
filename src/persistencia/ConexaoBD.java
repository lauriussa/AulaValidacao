/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laris
 */
public class ConexaoBD {
    
    private static EntityManagerFactory factory;
    private static EntityManager entidadeConexao;
    
    public static void criarConexao(){
        factory = Persistence.createEntityManagerFactory("AulaValidacaoPU");
        entidadeConexao = factory.createEntityManager();
    }
    
    public static EntityManager getConnection(){
        if(entidadeConexao == null || !entidadeConexao.isOpen()){
            criarConexao();
        }
        return entidadeConexao;
    }
}
