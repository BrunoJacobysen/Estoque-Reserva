package controller;

import model.*;


import javax.swing.*;

public class Estoque {
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

        if (totalProdutos < produtos.length && novoProduto.isValid()) {
            produtos[totalProdutos] = novoProduto;
            totalProdutos++;
        }
    }

    public void adicionarNicho(Nicho novoNicho) {

        if (totalNichos < nichos.length && novoNicho.isValid()) {
            nichos[totalNichos] = novoNicho;
            totalNichos++;
        }
    }

    public Produto buscar_codigoBarras(String codigoBuscado) {

        if (totalProdutos != 0) {
            for (int i = 0; i < totalProdutos; i++) {
                Produto produtoAtual = produtos[i];

                if (produtoAtual != null &&
                    produtoAtual.get_CodigoBarras() != null &&
                    produtoAtual.get_CodigoBarras().equals(codigoBuscado))
                {
                    return produtoAtual;
                }
            }
        }
        return null;
    }

    public Produto buscar_ref(String refBuscada) {

        if (totalProdutos != 0) {
            for (int i = 0; i < totalProdutos; i++) {
                Produto produtoAtual = produtos[i];

                if (produtoAtual != null &&
                        produtoAtual.get_Ref() != null &&
                        produtoAtual.get_Ref().equals(refBuscada))
                {
                    return produtoAtual;
                }
            }
        }
        return null;
    }

    public String listarProdutos() {

        if (totalProdutos != 0) {
            for (int i = 0; i < totalProdutos; i++) {
                Produto p = produtos[i];
            }
        } else
            return null;

        return listarProdutos();
    }

    public String listarNichos() {

        if (totalNichos != 0) {
            for (int i = 0; i < totalNichos; i++) {
                Nicho n = nichos[i];
            }

        } else
            return null;

        return listarNichos();
    }
}




