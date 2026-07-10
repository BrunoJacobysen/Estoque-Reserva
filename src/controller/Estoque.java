package controller;

import model.*;


import javax.swing.*;

public class Estoque extends JPanel {
    public Produto[] produtos;
    public Nicho[] nichos;
    private int totalProdutos;
    private int totalNichos;

    public Estoque() {
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
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].get_CodigoBarras().equalsIgnoreCase(novoProduto.get_CodigoBarras())) {

                JOptionPane.showMessageDialog(this,
                        "Produto já cadastrado!",
                        "Erro de cadastro",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else if (totalProdutos < produtos.length && novoProduto.isValid()) {
                produtos[totalProdutos] = novoProduto;
                totalProdutos++;
            }
        }
   }

   public void adicionarNicho(Nicho novoNicho) {
        if (totalNichos < nichos.length || novoNicho.isValid()) {
            nichos[totalNichos] = novoNicho;
            totalNichos++;
        }
   }

    //busca os produtos pelo codigo de barra
    public Produto buscar_codigoBarras(String codigoBuscado) {

        //verifica se há produtos

        if (totalProdutos == 0) {
            return null;
        }

        //busca segura
        for (int i = 0; i < totalProdutos; i++) {
            Produto produtoAtual = produtos[i];

            if (produtoAtual != null &&
                produtoAtual.get_CodigoBarras() != null &&
                produtoAtual.get_CodigoBarras().equals(codigoBuscado)) {
                return produtoAtual;
            }
        }
        return null;
    }

    public Produto buscar_ref(String refBuscada) {

        //busca os produtos pela referencia


        if (totalProdutos == 0) {
            return null;
        }

        for (int i = 0; i < totalProdutos; i++) {
            Produto produtoAtual = produtos[i];

            if (produtoAtual != null &&
                produtoAtual.get_Ref() != null &&
                produtoAtual.get_Ref().equals(refBuscada)) {
                return produtoAtual;
            }
        }

        return null;
    }

   public String listarProdutos() {

        if (totalProdutos == 0) {
            JOptionPane.showMessageDialog(null, "❌ Nenhum produto cadastrado no sistema! Por favor cadastrar");

        } else {
            for (int i = 0; i < totalProdutos; i++) {
                Produto p = produtos[i];
            }
        }
       return listarProdutos();
   }

   public String listarNichos () {

        if ( totalNichos == 0) {
            JOptionPane.showMessageDialog(this,"Nenhum nicho cadastrado no sistema! Por favor cadastrar.");

        } else {
            for (int i = 0; i < totalNichos; i++) {
                Nicho n = nichos[i];
            }
        }
       return listarNichos();
   }
}


