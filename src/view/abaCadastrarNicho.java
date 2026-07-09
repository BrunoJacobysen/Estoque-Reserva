package view;

import controller.Estoque;
import model.Nicho;

import javax.swing.*;
import java.awt.*;

public class abaCadastrarNicho extends JPanel {
    private JTextField txtTag;
    private JTextField txtCodigo;
    private final Estoque estoque = new Estoque();


    abaCadastrarNicho () {
        setLayout(null);
        setBackground(Color.BLACK);
        gerenciarComponentes();
    }

    public void gerenciarComponentes() {

        JLabel labelTag = new JLabel("Tag");
        labelTag.setHorizontalTextPosition(JLabel.LEFT);
        labelTag.setVerticalTextPosition(JLabel.CENTER);
        labelTag.setBounds(20, 20, 200, 25);
        labelTag.setForeground(Color.WHITE);

        txtTag = new JTextField();
        txtTag.setBounds(180, 20, 200, 25);

        JLabel labelCodigo = new JLabel("Código:");
        labelCodigo.setHorizontalTextPosition(JLabel.LEFT);
        labelCodigo.setVerticalTextPosition(JLabel.CENTER);
        labelCodigo.setBounds(20, 60, 200, 25);
        labelCodigo.setForeground(Color.WHITE);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 60, 200, 25);


        JButton btnSalvar = getBtnSalvar();



        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(240, 380, 100, 30);
        btnClear.addActionListener(e -> {
            txtTag.setText("");
            txtCodigo.setText("");
        });

        add(labelTag);
        add(labelCodigo);
        add(txtTag);
        add(txtCodigo);
        add(btnSalvar);
        add(btnClear);
    }

    private JButton getBtnSalvar () {
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(40, 380, 100, 30);
        btnSalvar.addActionListener(e -> {
            try {
                if (txtTag.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Informe a Tag do nicho.",
                            "Erro de Validação",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtTag.requestFocus();
                    return;
                }

                if (txtCodigo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Informe o Código do nicho.",
                            "Erro de validação",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtCodigo.requestFocus();
                    return;
                }

                Nicho novoNicho = new Nicho(
                        txtCodigo.getText(),
                        txtTag.getText());

                estoque.adicionarNicho(novoNicho);

                JOptionPane.showMessageDialog(this,
                        "Nicho adicionado!",
                        "Cadastro Efetuado",
                        JOptionPane.INFORMATION_MESSAGE);

                txtCodigo.setText("");
                txtTag.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao Cadastrar o nicho",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        return btnSalvar;
    }

}
