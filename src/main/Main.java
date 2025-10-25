package main;

import models.Biblioteca;
import models.Livro;
import models.Usuario;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


       Biblioteca biblioteca = new Biblioteca();

        int opcao = 1;

        while (opcao != 0) {

            System.out.println("PARA CADASTRAR UM LIVRO DIGITE - 1 ");
            System.out.println("PARA CADASTRAR UM CLIENTE DIGITE - 2 ");
            System.out.println("PARA PEGAR UM LIVRO DIGITE - 3 ");
            System.out.println("PARA DEVOLVER UM LIVRO DIGITE - 4 ");
            System.out.println("PARA VER LISTA DE LIVROS DISPONÍVEIS - 5 ");
            System.out.println("PARA VER LISTA DE LIVROS EMPRESTADOS - 6 ");
            System.out.println("PARA SAIR DIGITE - 0 ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                System.out.println("Digite o título do livro.");
                String titulo = scanner.nextLine();

                System.out.println("Digite o nome do autor.");
                String autor = scanner.nextLine();


                Livro livro = new Livro(titulo,autor);
                biblioteca.adicinarLivroAoAcervo(livro);

                System.out.println(biblioteca);


            } else if (opcao == 2) {
                System.out.println("Digite o nome do usuário.");
                Usuario usuario = new Usuario(scanner.nextLine());
                //String nome; = ;

                biblioteca.adicinaUsuario(usuario);


            } else if (opcao == 3) {
                System.out.println("Digite o nome do livro.");
                String titulo = scanner.nextLine();
                biblioteca.buscarLivro(titulo);

                System.out.println("Digite o nome do usuário.");
                String nome = scanner.nextLine();
                biblioteca.buscarUsuario(nome);

                Livro livroParaEmprestar = biblioteca.buscarLivro(titulo);
                Usuario usuarioRequerente = biblioteca.buscarUsuario(nome);

                if ( livroParaEmprestar != null && usuarioRequerente != null){
                    biblioteca.emprestarLivro(livroParaEmprestar, usuarioRequerente);
                    System.out.println("\nEmpréstimo processado. Detalhes:");
                    System.out.println(usuarioRequerente);
                }else {
                    // 4. PASSO: FEEDBACK DE ERRO
                    System.out.println("\n🚨 ATENÇÃO: Falha no Empréstimo!");

                    if (livroParaEmprestar == null) {
                        System.out.println("  - Livro com título '" + titulo + "' não encontrado.");
                    }

                    if (usuarioRequerente == null) {
                        System.out.println("  - Usuário com nome '" + nome + "' não cadastrado.");
                    }
                }



                System.out.println(biblioteca);

            }   else if (opcao == 4) {

                System.out.println("Digite o nome do livro.");
                String titulo = scanner.nextLine();
                biblioteca.buscarLivro(titulo);

                System.out.println("Digite o nome do usuário.");
                String nome = scanner.nextLine();
                biblioteca.buscarUsuario(nome);

                Livro livroParaDevolver = biblioteca.buscarLivro(titulo);
                Usuario usuarioRequerente = biblioteca.buscarUsuario(nome);

                biblioteca.devolverLivro(livroParaDevolver, usuarioRequerente);


            }else if (opcao == 5) {

                biblioteca.getAcervo().sort(Comparator.comparing(Livro::getTitulo));
                biblioteca.livrosDisponiveis();


            }  else if (opcao == 6) {

            biblioteca.getAcervo().sort(Comparator.comparing(Livro::getTitulo));
            biblioteca.livrosEmprestados();        }


            else if (opcao == 0) {
                System.out.println("Encerrando...");

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }






    }

