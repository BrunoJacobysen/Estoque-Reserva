import controller.*;
import teste.*;
import view.*;
import javax.swing.*;
import java.util.Scanner;



public class Main extends JFrame{
    public static void main(String[] args) {

        TelaPrincipal testeTela = new TelaPrincipal();
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======== ESTOQUE RESERVA ========");
            System.out.println("   ======== MAIN MENU ========   ");
            System.out.printf(
                            "1. Consultar Produtos %n" +
                            "2. Cadastrar teste.Produto %n" +
                            "3. Listar Produtos %n" +
                            "4. Cadastrar teste.Nicho %n" +
                            "5. Listar Nichos %n" +
                            "0. Sair %n" +
                            "\n");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    try {
                        System.out.println("===== SELECIONE A FORMA DE BUSCA =====");
                        System.out.println("1. Código de Barras");
                        System.out.println("2. Referência");
                        int consulta = scanner.nextInt();
                        scanner.nextLine();


                        if (estoque.getTotalProdutos() == 0) {
                            System.out.println("controller.Estoque Vazio!");

                        } else if (consulta == 1) {
                            System.out.println("Informe o código de barras: ");
                            String produtoConsultado = scanner.nextLine();
                            Produto produtoEncontrado = estoque.buscar_codigoBarras(produtoConsultado);
                            System.out.println("Nome: " + produtoEncontrado.get_Nome());
                            System.out.println("teste.Nicho: " + produtoEncontrado.get_NumNicho());

                        } else if (consulta == 2) {
                            System.out.println("Informe a referência: ");
                            String produtoConsultado = scanner.nextLine();
                            Produto produtoEncontrado = estoque.buscar_ref(produtoConsultado);
                            System.out.println("Nome: " + produtoEncontrado.get_Nome());
                            System.out.println("teste.Nicho: " + produtoEncontrado.get_NumNicho());
                        } else {
                            System.out.println("ERRO INESPERADO! Tente novamente.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao buscar produto." + e.getMessage());
                    }
                    break;

                case 2:

                    try {
                        String continuar;
                        do {
                            System.out.println("===== CADASTRO DE PRODUTOS =====");
                            System.out.println(" ");
                            System.out.println("Informações com '*' são obrigatórias.");
                            System.out.println(" ");
                            System.out.println("Digite as seguintes informações: ");
                            System.out.println(" ");

                            System.out.print("*Nome: ");
                            String nome = scanner.nextLine();

                            System.out.print("Tamanho: ");
                            String tamanho = scanner.nextLine();

                            System.out.print("Cor: ");
                            String cor = scanner.nextLine();

                            System.out.print("*Referência: ");
                            String referencia = scanner.nextLine();

                            System.out.print("*Código de barras: ");
                            String codigo = scanner.nextLine();

                            System.out.print("*teste.Nicho: ");
                            String nicho = scanner.nextLine();

                            if (nome.isEmpty() || referencia.isEmpty() || codigo.isEmpty() || nicho.isEmpty()){
                                System.out.println("Falha ao cadastrar o produto! Informações inválidas.");

                            } else {
                                Produto novoProduto = new Produto(codigo, referencia, nome, tamanho, cor, nicho);
                                estoque.adicionarProduto(novoProduto);
                                System.out.println("teste.Produto cadastrado!");
                            }
                            System.out.println("\nDeseja cadastrar outro produto? (S/N): ");
                            continuar = scanner.nextLine().trim().toUpperCase();

                        } while (continuar.equals("S") || continuar.equals("SIM"));

                    } catch (Exception e) {
                        System.out.println("❌ ERRO! Não foi possível cadastrar esse produto." + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        estoque.listarProdutos();
                        break;

                    } catch (Exception e) {
                        System.out.println("❌ ERRO! Não foi possível listar os produtos do estoque");
                    }
                    break;

                case 4:
                    try {
                        System.out.println("===== CADASTRO DE NICHOS ====");
                        System.out.println("Digite as seguintes informações: ");

                        System.out.println("Descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.println("Código: ");
                        String codigo = scanner.nextLine();

                        Nicho novoNicho = new Nicho(codigo, descricao);
                        estoque.adicionarNicho(novoNicho);


                    } catch (Exception e) {
                        System.out.println("ERRO! Não foi possível cadastrar esse nicho.");
                    }
                    break;

                case 5:
                    try{
                        System.out.println("===== LISTA DE NICHOS =====");
                        estoque.listarNichos();
                        break;

                    } catch (Exception e) {
                        System.out.println("Não foi possível executar essa ação. :( ");
                    }
                    break;

                case 0:
                    System.out.println("Fechando Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }

            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);
        scanner.close();
    }
}