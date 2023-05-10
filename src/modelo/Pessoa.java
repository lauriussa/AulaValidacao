/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import util.validacoes.DataClass;
import util.validacoes.DataCpf;

@Entity
public class Pessoa extends Entidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 3, max = 90, message = "O nome deve conter entre 3 a 90 caracteres")
    private String nome;
    
    @DataCpf(message = "CPF Invalido!")
    @NotBlank(message = "O CPF não pode estar em branco")
    @Size(min = 11, max = 14, message = "O CPF deve conter entre 11 a 14 caracteres")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF Invalido!")
    private String cpf;
    
    @DataClass(message = "O email nao pode ser nulo!")
    @Email(message = "E-mail inválido")
    private String email;
    
    @NotBlank(message = "O telefone não pode estar em branco")
    @Size(min = 8, max = 16, message = "O telefone deve conter entre 8 a 16 caracteres")
    @Pattern(regexp = "^\\(?[0-9]{2,3}\\)?\\s[0-9]{4,5}-?[0-9]{4}$", message = "Telefone Invalido!")
    private String telefone; 
    
    @OneToOne
    private Endereco endereco;
    
    public Pessoa(){
        this.endereco = new Endereco();
    }

    public Pessoa(Integer id, String nome, String cpf, String email, String telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
    
    
    
}
