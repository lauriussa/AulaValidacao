/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import modelo.Pessoa;
import persistencia.DaoPessoa;
import util.Input;

/**
 *
 * @author Laris
 */
public class ControlePessoa {
    
    private DaoPessoa dao;
    
    public ControlePessoa(){
        dao = new DaoPessoa();
    }
    
    public void cadastrar(){
        Pessoa p = new Pessoa();
    }
    
    public void setarDados(Pessoa p){
        System.out.println("Informe o nome: ");
        p.setNome(Input.nextLine());
        System.out.println("Informe o cpf: ");
        p.setCpf(Input.nextLine());
        System.out.println("Informe o e-mail: ");
        p.setEmail(Input.nextLine());
        System.out.println("Informe o telefone: ");
        p.setTelefone(Input.nextLine());
    }
}
