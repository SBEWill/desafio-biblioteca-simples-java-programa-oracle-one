package models;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel = true;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;

    }

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void marcarComoEmprestado() {
        this.disponivel = false;
    }
    public void marcarComoDevolvido(){
         this.disponivel = true;
    }

    @Override
    public String toString() {
        return
                "Titulo do livro " + titulo +
                " Autor " + autor +
                " Disponivel " + disponivel;
    }
}
