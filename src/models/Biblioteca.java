package models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List <Livro> acervo;
    private List <Usuario> listaDeUsuarios;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.listaDeUsuarios =  new ArrayList<>();
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void adicinarLivroAoAcervo(Livro livro){
        acervo.add(livro);

    }

    public void emprestarLivro(Livro livro, Usuario usuario){

     if (livro.isDisponivel()){
         usuario.adicionarLivro(livro);
         livro.marcarComoEmprestado();
         System.out.println("🎉 Sucesso! Livro emprestado.");

     }else {

         System.err.println("❌ Erro: O livro '" + livro.getTitulo() + "' já está emprestado.");
     }
    }

    public void devolverLivro(Livro livro, Usuario usuario){

        if (!livro.isDisponivel()){
            usuario.removerLivro(livro);
            livro.marcarComoDevolvido();
            System.out.println("🎉 Sucesso! Livro devolvido.");
        }

    }

    public void livrosDisponiveis() {

        System.out.println("\n--- LIVROS DISPONÍVEIS ---");

        boolean encontrouDisponivel = false;

        for (Livro livro : this.acervo) {


            if (livro.isDisponivel()) {
                System.out.println("  - " + livro.toString());
                encontrouDisponivel = true;
            }
        }

        if (!encontrouDisponivel) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public void livrosEmprestados() {

        System.out.println("--- LIVROS EMPRESTADOS ---");
        boolean emprestado = false;

        for (Livro livro : this.acervo) {


            if (!livro.isDisponivel()) {
                System.out.println(" - " + livro.toString());
                emprestado = true;
            }
        }

        if (!emprestado) {
            System.out.println("Nenhum livro emprestado.");
        }
    }

    public void adicinaUsuario(Usuario usuario){
        this.listaDeUsuarios.add(usuario);

    }




    public Livro buscarLivro(String titulo) {
        for (Livro livro : acervo) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }


    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null; // Não encontrado
    }

    @Override
    public String toString() {
        return "Acervo da biblioteca= " + acervo +
                "listaDeUsuarios= " + listaDeUsuarios;
    }
}
