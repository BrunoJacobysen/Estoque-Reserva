package view;
import controller.Estoque;
import model.Produto;
import javax.swing.*;
import java.awt.*;



public class abaCadastrarProduto extends JPanel {
    private JTextField txtNome;
    private JTextField txtNicho;
    private JTextField txtCodigoBarras;
    private JTextField txtReferencia;
    private JTextField txtCor;
    private String txtTamanho;
    private final String[] tamanhos = {"Selecione o tamanho", "PP", "P", "M", "G", "GG", "3G"};
    private final JComboBox<String> boxTamanhos = new JComboBox<>(tamanhos);
    private final Estoque estoque = new Estoque();



    public abaCadastrarProduto() {
        setLayout(null);
        setBackground(Color.BLACK);
        compCadastroProduto();
    }

    public void compCadastroProduto() {

        JLabel labelNome = new JLabel("Nome");
        labelNome.setHorizontalTextPosition(JLabel.LEFT);
        labelNome.setVerticalTextPosition(JLabel.CENTER);
        labelNome.setBounds(20, 20, 200, 25);
        labelNome.setForeground(Color.WHITE);

        txtNome = new JTextField();
        txtNome.setBounds(180, 20, 200, 25);

        JLabel labelNicho = new JLabel("Nicho");
        labelNicho.setHorizontalTextPosition(JLabel.LEFT);
        labelNicho.setVerticalTextPosition(JLabel.CENTER);
        labelNicho.setBounds(20, 60, 200, 25);
        labelNicho.setForeground(Color.WHITE);

        txtNicho = new JTextField();
        txtNicho.setBounds(180, 60, 200, 25);

        JLabel labelCodBarras = new JLabel("Código de Barras");
        labelCodBarras.setHorizontalTextPosition(JLabel.LEFT);
        labelCodBarras.setVerticalTextPosition(JLabel.CENTER);
        labelCodBarras.setBounds(20, 100, 200, 25);
        labelCodBarras.setForeground(Color.WHITE);

        txtCodigoBarras = new JTextField();
        txtCodigoBarras.setBounds(180, 100, 200, 25);

        JLabel labelRef = new JLabel("Referência");
        labelRef.setHorizontalTextPosition(JLabel.LEFT);
        labelRef.setVerticalTextPosition(JLabel.CENTER);
        labelRef.setBounds(20, 140, 200, 25);
        labelRef.setForeground(Color.WHITE);

        txtReferencia = new JTextField();
        txtReferencia.setBounds(180, 140, 200, 25);

        JLabel labelCor = new JLabel("Cor");
        labelCor.setHorizontalTextPosition(JLabel.LEFT);
        labelCor.setVerticalTextPosition(JLabel.CENTER);
        labelCor.setBounds(20, 180, 200, 25);
        labelCor.setForeground(Color.WHITE);

        txtCor = new JTextField();
        txtCor.setBounds(180, 180, 200, 25);


        JLabel labelTamanho = new JLabel("Tamanho");
        labelTamanho.setHorizontalTextPosition(JLabel.LEFT);
        labelTamanho.setVerticalTextPosition(JLabel.CENTER);
        labelTamanho.setBounds(20, 220, 200, 25);
        labelTamanho.setForeground(Color.WHITE);


        boxTamanhos.setBounds(180, 220, 200, 25);
        boxTamanhos.setSelectedIndex(0);
        boxTamanhos.addActionListener(e -> {
            txtTamanho = (String) boxTamanhos.getSelectedItem();
        });


        JButton btnSalvar = getBtnSalvar();

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(240, 380, 100, 30);
        btnClear.addActionListener(e -> {
            txtNome.setText("");
            txtNicho.setText("");
            txtCodigoBarras.setText("");
            txtReferencia.setText("");
            txtCor.setText("");
            boxTamanhos.setSelectedIndex(0);
        } );


        add(labelNome);
        add(txtNome);
        add(labelNicho);
        add(txtNicho);
        add(labelCodBarras);
        add(txtCodigoBarras);
        add(labelRef);
        add(txtReferencia);
        add(labelCor);
        add(txtCor);
        add(labelTamanho);
        add(labelTamanho);
        add(boxTamanhos);
        add(btnSalvar);
        add(btnClear);


    }

    private JButton getBtnSalvar() {
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(40, 380, 100, 30);
        btnSalvar.addActionListener(e -> {
            try {
                if (txtNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "O campo NOME é obrigatório!",
                            "Informe o Nome do produto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtNome.requestFocus();
                    return;

                    //configurar para o campo voltar a cor padrão
                    //txtNome.setBackground(Color.GRAY);

                }

                if (txtCodigoBarras.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "O campo Código de Barras é obrigatório!",
                            "Informe o Código Barras do produto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtCodigoBarras.requestFocus();
                    return;

                    //configurar para o campo voltar a cor padrão
                    //txtCodigoBarras.setBackground(Color.GRAY);
                }

                if (txtNicho.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "O campo Nicho é obrigatório!",
                            "Informe o Nicho do produto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtNicho.requestFocus();
                    return;

                    //configurar para o campo voltar a cor padrão
                    //txtNicho.setBackground(Color.GRAY);
                }

                if (txtReferencia.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "O campo Referência é obrigatório!",
                            "Informe o Referência do produto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtReferencia.requestFocus();
                    return;

                    //configurar para o campo voltar a cor padrão
                    //txtReferencia.setBackground(Color.GRAY);
                }

                if (txtCor.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "O campo Cor é obrigatório!",
                            "Informe o Cor do produto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    txtCor.requestFocus();
                    return;

                    //configurar para o campo voltar a cor padrão
                    //txtCor.setBackground(Color.GRAY);
                }

                if (txtTamanho.equals("Selecione o tamanho")) {
                    JOptionPane.showMessageDialog(this,
                            "Selecione o tamanho do produto",
                            "Erro de cadastro",
                            JOptionPane.WARNING_MESSAGE

                    );
                    return;
                }

                Produto novoProduto = new Produto(
                        txtNome.getText(),
                        txtCodigoBarras.getText(),
                        txtNicho.getText(),
                        txtReferencia.getText(),
                        txtTamanho);


                estoque.adicionarProduto(novoProduto);
                JOptionPane.showMessageDialog(this,
                            "Produto adicionado!",
                            "Cadastro efetuado",
                            JOptionPane.INFORMATION_MESSAGE);

                txtNome.setText("");
                txtNicho.setText("");
                txtCodigoBarras.setText("");
                txtReferencia.setText("");
                txtCor.setText("");
                boxTamanhos.setSelectedIndex(0);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao cadastrar o Produto" + ex.getMessage(),
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        return btnSalvar;
    }


}

