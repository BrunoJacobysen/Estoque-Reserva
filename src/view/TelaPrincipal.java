package view;
import javax.swing.*;
import java.awt.*;


public class TelaPrincipal extends JFrame {

    public TelaPrincipal () {
        inicComponentes();

    }

    public void inicComponentes() {
        ImageIcon imageIcon = new ImageIcon(".idea/imagens/IconeReserva.png");

        setIconImage(imageIcon.getImage());
        setTitle("Estoque reserva v.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024, 860);
        setLocationRelativeTo(null);
        iniciarAbas();
        setVisible(true);


    }

    public void iniciarAbas() {
        JTabbedPane painelAbas = new JTabbedPane();

        abaCadastrarProduto abacadastro = new abaCadastrarProduto();
        painelAbas.addTab("Cadastro de Produtos", abacadastro);
        abaCadastrarNicho abaCadastrarNicho = new abaCadastrarNicho();
        painelAbas.addTab("Cadastro Nichos", abaCadastrarNicho);



        add(painelAbas);
    }

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
    }



}
