
# 📚 Sistema de Gerenciamento de Biblioteca (CLI - Java)

Este é um projeto simples de console desenvolvido em Java para simular as operações básicas de uma biblioteca, focado na aplicação e demonstração de conceitos fundamentais da **Programação Orientada a Objetos (POO)**.

## 🎯 Objetivo do Projeto

Gerenciar o empréstimo e devolução de livros, mantendo o controle de quais livros estão disponíveis e quais usuários estão com itens emprestados. O foco principal foi na arquitetura de software, aplicando:

  * **Composição:** Relação entre a `Biblioteca` e seu `Acervo`, e entre o `Usuario` e sua lista de `LivrosEmprestados`.
  * **Encapsulamento:** Cada classe (Livro, Usuário) é responsável por gerenciar e alterar seu próprio estado interno.
  * **Delegação de Responsabilidade:** A classe `Biblioteca` atua como um **Controlador (Orquestrador)**, delegando ações específicas para `Livro` e `Usuario`.
  * **Validação:** Controle de tentativas de empréstimo de livros já emprestados e checagem de objetos `null` antes de transações.

## 🏗️ Estrutura do Projeto (Classes e Responsabilidades)

O sistema é composto por três classes principais no pacote `models` e uma classe de execução `Main`.

### 1\. `Livro`

Responsável por armazenar dados e controlar seu próprio estado de disponibilidade.

| Atributo | Tipo | Responsabilidade |
| :--- | :--- | :--- |
| `titulo` | `String` | Nome do livro. |
| `autor` | `String` | Nome do autor. |
| `disponivel` | `boolean` | **Estado interno:** `true` se estiver na prateleira. |
| **Métodos** | `marcarComoEmprestado()`, `marcarComoDevolvido()` | Altera o `disponivel` para `false` ou `true`, respectivamente. |

### 2\. `Usuario`

Responsável por armazenar dados do leitor e controlar a lista de livros em sua posse (Composição).

| Atributo | Tipo | Responsabilidade |
| :--- | :--- | :--- |
| `nome` | `String` | Nome do usuário. |
| `livrosEmprestados` | `List<Livro>` | **Composição:** Lista de livros que o usuário atualmente possui. |
| **Métodos** | `adicionarLivro()`, `removerLivro()` | Atualiza a lista interna de posse do usuário. |

### 3\. `Biblioteca`

A classe central de gerenciamento. Orquestra todas as transações e mantém o registro do acervo e dos usuários.

| Atributo | Tipo | Responsabilidade |
| :--- | :--- | :--- |
| `acervo` | `List<Livro>` | O acervo total de livros da biblioteca. |
| `listaDeUsuarios` | `List<Usuario>` | O registro de todos os clientes cadastrados. |
| **Métodos** | `emprestarLivro()`, `devolverLivro()` | Implementa a lógica de negócio (validações e delegação de ações a `Livro` e `Usuario`). |
| **Métodos** | `buscarLivro()`, `buscarUsuario()` | Procura objetos por nome/título dentro de suas listas internas. |

## 🚀 Funcionalidades

O menu interativo na classe `Main` permite as seguintes operações:

1.  **Cadastrar Livro:** Adiciona um novo livro ao acervo.
2.  **Cadastrar Cliente:** Adiciona um novo usuário ao registro.
3.  **Emprestar Livro:** Realiza a transação de empréstimo após validações de disponibilidade.
4.  **Devolver Livro:** Realiza a transação de devolução.
5.  **Listar Livros Disponíveis:** Mostra **apenas** os livros que podem ser emprestados.
6.  **Exibir Livros Emprestados:** Mostra **apenas** os livros que estão atualmente com usuários.
7.  **Sair:** Encerra a aplicação.

## ⚙️ Como Executar

O projeto é um aplicativo de console (CLI) em Java.

1.  **Clone o Repositório:**
    ```bash
    git clone [LINK_DO_SEU_REPOSITORIO]
    cd sistema-biblioteca
    ```
2.  **Compile e Execute:**
    Se estiver usando uma IDE (IntelliJ, Eclipse), basta executar a classe `main/Main`.


Este projeto foi desenvolvido como um exercício prático de Programação Orientada a Objetos (POO) em Java.

## 👨‍💻 Autor

| **Nome** | Willian Diniz Menezes |
| **LinkedIn** | https://www.linkedin.com/in/willian-diniz-2360b74b/ |
| **GitHub** | https://github.com/SBEWill |



*Feito com ☕ e Java.*
