package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List <Livro> livrosEmprestados;

    public Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();

    }


    public String getNome() {
        return nome;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adicionarLivro(Livro livro){

       this.livrosEmprestados.add(livro);
    }

    public  void removerLivro(Livro livro){
        this.livrosEmprestados.remove(livro);
    }

    @Override
    public String toString() {
        return
                "Nome do usuário= " + nome +
                        " Livros emprestados" + livrosEmprestados;
    }
}

