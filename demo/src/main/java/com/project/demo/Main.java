/* Integrantes: 
Camille Barbosa Meireles Mota - 10746106; 
Lucas dos Santos Manoel Sperandio Locateli - 10734907 ; 
Maria Luiza Ciola - 10734889; 
Miguel Trezza Ferreira - 10734908; 
Sophia de Abreu Cruz - 10254162 */
package com.project.demo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.demo.classes.Emprestimo;
import com.project.demo.classes.Exemplar;
import com.project.demo.classes.Funcionario;
import com.project.demo.classes.Livro;
import com.project.demo.classes.Usuario;

public class Main {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Livro> livros = new ArrayList<>();
    static ArrayList<Exemplar> exemplares = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // DADOS INICIAIS (importante pro relatório)
        Usuario u1 = new Usuario("Sophia", LocalDate.of(2000, 1, 1), "11999999999", 1);
        Usuario u2 = new Usuario("Carlos", LocalDate.of(1998, 5, 10), "11888888888", 2);
        usuarios.add(u1);
        usuarios.add(u2);

        Livro l1 = new Livro(100, "Java Básico", "Autor X", 2020);
        Livro l2 = new Livro(101, "POO Java", "Autor Y", 2021);
        livros.add(l1);
        livros.add(l2);

        Exemplar e1 = new Exemplar(1, l1);
        Exemplar e2 = new Exemplar(2, l1);
        Exemplar e3 = new Exemplar(3, l2);

        exemplares.add(e1);
        exemplares.add(e2);
        exemplares.add(e3);

        l1.adicionarExemplar(e1);
        l1.adicionarExemplar(e2);
        l2.adicionarExemplar(e3);

        int opcao;

        do {
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Funcionário");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Cadastrar Exemplar");
            System.out.println("5 - Buscar Livro por Código");
            System.out.println("6 - Buscar Exemplar por Código");
            System.out.println("7 - Listar Usuários");
            System.out.println("8 - Listar Livros");
            System.out.println("9 - Listar Exemplares Disponíveis de um Livro");
            System.out.println("10 - Registrar Empréstimo");
            System.out.println("11 - Registrar Devolução");
            System.out.println("12 - Ver livros de um usuário"); // EXTRA
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> cadastrarFuncionario();
                    case 3 -> cadastrarLivro();
                    case 4 -> cadastrarExemplar();
                    case 5 -> buscarLivro();
                    case 6 -> buscarExemplar();
                    case 7 -> listarUsuarios();
                    case 8 -> listarLivros();
                    case 9 -> listarExemplaresDisponiveis();
                    case 10 -> registrarEmprestimo();
                    case 11 -> registrarDevolucao();
                    case 12 -> listarLivrosUsuario();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                sc.nextLine();
                opcao = -1;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                opcao = -1;
            }

        } while (opcao != 0);

        sc.close();
    }

    static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        sc.nextLine();

        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getRegistroUsuario() == id) {
                throw new IllegalArgumentException("ID já existe.");
            }
        }

        usuarios.add(new Usuario(nome, LocalDate.of(ano, mes, dia), tel, id));
    }

    static void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        sc.nextLine();

        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Funcionario f : funcionarios) {
            if (f.getIdFuncionario() == id) {
                throw new IllegalArgumentException("ID já existe.");
            }
        }

        funcionarios.add(new Funcionario(nome, LocalDate.of(ano, mes, dia), tel, id));
    }

    static void cadastrarLivro() {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Livro l : livros) {
            if (l.getCodigoLivro() == codigo) {
                throw new IllegalArgumentException("Código já existe.");
            }
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        livros.add(new Livro(codigo, titulo, autor, ano));
    }

    static void cadastrarExemplar() {
        System.out.print("Código do Livro: ");
        int codLivro = sc.nextInt();
        sc.nextLine();

        Livro livro = null;
        for (Livro l : livros) {
            if (l.getCodigoLivro() == codLivro) {
                livro = l;
                break;
            }
        }

        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado.");
        }

        System.out.print("Código do Exemplar: ");
        int codEx = sc.nextInt();
        sc.nextLine();

        for (Exemplar e : exemplares) {
            if (e.getCodigoExemplar() == codEx) {
                throw new IllegalArgumentException("Exemplar já existe.");
            }
        }

        Exemplar e = new Exemplar(codEx, livro);
        exemplares.add(e);
        livro.adicionarExemplar(e);
    }

    static void buscarLivro() {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Livro l : livros) {
            if (l.getCodigoLivro() == codigo) {
                System.out.println(l);
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    static void buscarExemplar() {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Exemplar e : exemplares) {
            if (e.getCodigoExemplar() == codigo) {
                System.out.println(e);
                return;
            }
        }

        System.out.println("Exemplar não encontrado.");
    }

    static void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getRegistroUsuario() +
                    " | Nome: " + u.getNomeCompleto());
        }
    }

    static void listarLivros() {
        for (Livro l : livros) {
            System.out.println("Código: " + l.getCodigoLivro() +
                    " | Título: " + l.getTitulo() +
                    " | Autor: " + l.getAutor());
        }
    }

    static void listarExemplaresDisponiveis() {
        System.out.print("Código do livro: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Livro l : livros) {
            if (l.getCodigoLivro() == codigo) {
                l.listarExemplaresDisponiveis();
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    static void registrarEmprestimo() {
        System.out.print("ID usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getRegistroUsuario() == id) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        System.out.print("Código exemplar: ");
        int cod = sc.nextInt();
        sc.nextLine();

        Exemplar exemplar = null;
        for (Exemplar e : exemplares) {
            if (e.getCodigoExemplar() == cod) {
                exemplar = e;
                break;
            }
        }

        if (exemplar == null) {
            throw new IllegalArgumentException("Exemplar não encontrado.");
        }

        emprestimos.add(new Emprestimo(usuario, exemplar));
        System.out.println("Empréstimo realizado com sucesso!");
    }

    static void registrarDevolucao() {
        System.out.print("Código exemplar: ");
        int cod = sc.nextInt();
        sc.nextLine();

        for (Emprestimo e : emprestimos) {
            if (e.getExemplar().getCodigoExemplar() == cod && e.getDataDevolucaoReal() == null) {
                e.registrarDevolucao();
                System.out.println("Devolução realizada com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    static void listarLivrosUsuario() {
        System.out.print("ID usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getRegistroUsuario() == id) {
                System.out.println("Quantidade de livros: " + u.getQuantidadeLivrosEmprestados());

                System.out.println("Livros emprestados:");
                for (Exemplar e : u.getLivrosEmprestados()) {
                    System.out.println("- " + e.getLivro().getTitulo());
                }
                return;
            }
        }

        System.out.println("Usuário não encontrado.");
    }
}