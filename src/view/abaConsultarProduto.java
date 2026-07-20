package view;

import controller.Estoque;
import model.Produto;

import javax.swing.*;
import java.awt.*;

public class abaConsultarProduto extends JPanel {
    private JTextField txtCodBarras;
    private JTextField txtRef;
    private Estoque estoque = new Estoque();


    public abaConsultarProduto() {
        setLayout(null);
        setBackground(Color.BLACK);
        gerenciarComponentes();
    }


    private void gerenciarComponentes() {

        JLabel labelCodBarras =  new JLabel("Código de Barras");
        labelCodBarras.setHorizontalTextPosition(JLabel.LEFT);
        labelCodBarras.setVerticalTextPosition(JLabel.CENTER);
        labelCodBarras.setBounds(20, 20, 200, 25);
        labelCodBarras.setForeground(Color.WHITE);

        txtCodBarras = new JTextField();
        txtCodBarras.setBounds(180, 20, 200, 25);

        JLabel labelRef = new JLabel("Referência");
        labelRef.setHorizontalTextPosition(JLabel.LEFT);
        labelRef.setVerticalTextPosition(JLabel.CENTER);
        labelRef.setBounds(20, 60, 200, 25);
        labelRef.setForeground(Color.white);

        txtRef = new JTextField();
        txtRef.setBounds(180, 60, 200, 25);

        JButton btnConsultarCodBarras = getBtnConsultarCodBarras();


        add(labelCodBarras);
        add(txtCodBarras);
        add(labelRef);
        add(txtRef);
        add(btnConsultarCodBarras);
    }

    private JButton getBtnConsultarCodBarras() {
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(40, 380, 100, 30);
        btnConsultar.addActionListener(e -> {
            try {
                if (txtCodBarras.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Insira as informações para consultar",
                            "Erro de Validação",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                Produto p = estoque.buscar_codigoBarras(txtCodBarras.getText());

                String resultado =
                        "Produto encontrado\n" +
                        "====================\n" +
                        "Nome: " + p.get_Nome() +
                        "Código: " + p.get_CodigoBarras() +
                        "Referência: " + p.get_Ref() +
                        "Nicho: " + p.get_NumNicho();

                JOptionPane.showMessageDialog(this,
                        resultado,
                        "Detalhes do Produto",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao consultar" + ex.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        return btnConsultar;
    }


}
