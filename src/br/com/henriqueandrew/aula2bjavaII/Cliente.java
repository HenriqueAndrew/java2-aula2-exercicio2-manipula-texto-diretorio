//Henrique Andrew da Silva

package br.com.henriqueandrew.aula2bjavaII;

import java.io.Serializable;

public class Cliente {
    
    private static final long serialVersionUID = 1L;
    private String nome;
    private String fone;
    private int idade;
    
    Cliente() {
        nome = "";
        fone = "";
        idade = 0;
    }
    
    public Cliente (String nome, String fone, int idade){
        this.nome = nome;
        this.fone = fone;
        this.idade = idade;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
