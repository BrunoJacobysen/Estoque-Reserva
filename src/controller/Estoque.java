package controller;

import model.*;


import javax.swing.*;

public class Estoque extends JPanel {
    private final JLabel labelStatus;
    public Produto[] produtos;
    public Nicho[] nichos;
    private int totalProdutos;
    private int totalNichos;

    public Estoque() {
        labelStatus = new JLabel(" ");
        add(labelStatus);
        produtos = new Produto[300];
        nichos = new Nicho[75];
        totalProdutos = 0;
        totalNichos = 0;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(int totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public int getTotalNichos() {
        return totalNichos;
    }

    public void setTotalNichos(int totalNichos) {
        this.totalNichos = totalNichos;
    }

    public void adicionarProduto(Produto novoProduto) {
        if (totalProdutos < produtos.length && novoProduto.isValid()) {
            produtos[totalProdutos] = novoProduto;
            totalProdutos++;

        } else
            labelStatus.setText("Erro");
   }

   public void adicionarNicho(Nicho novoNicho) {
        if (totalNichos < nichos.length) {
            nichos[totalNichos] = novoNicho;
            totalNichos++;
        }
   }

    //busca os produtos pelo codigo de barra
    public Produto buscar_codigoBarras(String codigoBuscado) {

        //verifica se há produtos

        if (totalProdutos == 0) {
            labelStatus.setText("❌ Nenhum produto cadastrado!");
            return null;
        }

        //busca segura
        for (int i = 0; i < totalProdutos; i++) {
            Produto produtoAtual = produtos[i];

            if (produtoAtual != null &&
                produtoAtual.get_CodigoBarras() != null &&
                produtoAtual.get_CodigoBarras().equals(codigoBuscado)) {

                labelStatus.setText("==== PRODUTO ENCONTRADO ====");
                labelStatus.setText("Nome: " + produtos[i].get_Nome());
                labelStatus.setText("Código: " + produtos[i].get_CodigoBarras());
                labelStatus.setText("Referêmcia: " + produtos[i].get_Ref());
                labelStatus.setText("Tamanho: " + produtos[i].get_Tamanho());
                labelStatus.setText("Cor: " + produtos[i].get_Cor());
                labelStatus.setText("teste.Nicho: " + produtos[i].get_NumNicho());
                return produtoAtual;
            }
        }
        labelStatus.setText("❌ teste.Produto não encontrado com código " + codigoBuscado + " ou produto não cadastrado.");
        return null;
    }

    public Produto buscar_ref(String refBuscada) {

        //busca os produtos pela referencia


        if (totalProdutos == 0) {
            labelStatus.setText("❌ Nenhum produto cadastrado!");
            return null;
        }

        for (int i = 0; i < totalProdutos; i++) {
            Produto produtoAtual = produtos[i];

            if (produtoAtual != null &&
                produtoAtual.get_Ref() != null &&
                produtoAtual.get_Ref().equals(refBuscada)) {

                labelStatus.setText("=== PRODUTO ENCONTRADO ===");
                labelStatus.setText("Nome: " + produtos[i].get_Nome());
                labelStatus.setText("Código: " + produtos[i].get_CodigoBarras());
                labelStatus.setText("Referêmcia: " + produtos[i].get_Ref());
                labelStatus.setText("Tamanho: " + produtos[i].get_Tamanho());
                labelStatus.setText("Cor: " + produtos[i].get_Cor());
                labelStatus.setText("teste.Nicho: " + produtos[i].get_NumNicho());
                return produtoAtual;
            }
        }

        labelStatus.setText("❌ teste.Produto não encontrado com referencia " + refBuscada + " ou produto não cadastrado." );
        return null;
    }

   public String listarProdutos() {

        if (totalProdutos == 0) {
            JOptionPane.showMessageDialog(null, "❌ Nenhum produto cadastrado no sistema! Por favor cadastrar");

        } else {
            labelStatus.setText("========= LISTA DE PRODUTOS =========");
            for (int i = 0; i < totalProdutos; i++) {
                Produto p = produtos[i];
                labelStatus.setText((i + 1) + "- " + p.get_Nome() +
                        " | teste.Nicho: " + p.get_NumNicho() +
                        " | Ref: " + p.get_Ref() +
                        " | Código: " + p.get_CodigoBarras());

            }
        }
       return listarProdutos();
   }

   public String listarNichos () {

        if ( totalNichos == 0) {
            JOptionPane.showMessageDialog(null,"Nenhum nicho cadastrado no sistema! Por favor cadastrar.");

        } else {
            labelStatus.setText("========= LISTA DE NICHOS =========");
            for (int i = 0; i < totalNichos; i++) {
                Nicho n = nichos[i];
                labelStatus.setText((i + 1) + "Código: " + n.get_Codigo() + "\n" +
                        " | Descrição: " + n.get_Descricao() + "\n" +
                        " | Quantidade de Peças: " + n.get_quantPc());
            }
        }
       return listarNichos();
   }
}


