package model;

public class Produto {
    public String nome;
    public String codigoBarras;
    public String ref;
    public String tamanho;
    public String cor;
    public String numNicho;


    public Produto(String nome, String ref, String codigoBarras, String tamanho,
                   String cor, String numNicho) {
        isValid();
        this.codigoBarras = codigoBarras;
        this.ref = ref;
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.numNicho = numNicho;
    }

    public Produto(String nome, String codigoBarras, String ref,
                   String nicho, String tamanho) {

        this.codigoBarras = codigoBarras;
        this.ref = ref;
        this.nome = nome;
        this.numNicho = nicho;
        this.tamanho = tamanho;
    }

    //valida os parametros para criação do produto
    public boolean isValid() {
        return isValidNome() && isValidTamanho() && isValidCor() &&
                isValidNicho() && isValidCodBarras() && isValidRef();
    }

    public String get_CodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String get_Ref() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String get_Nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String get_Tamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String get_Cor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String get_NumNicho() {
        return numNicho;
    }

    public void setNumNicho(String numNicho) {
        this.numNicho = numNicho;
    }

    //funçoes para b
    private boolean isValidNome() {
        return nome != null && !nome.trim().isEmpty();
    }
    private boolean isValidNicho () {
        return numNicho != null && !numNicho.trim().isEmpty();
    }
    private boolean isValidCodBarras() {
        return  codigoBarras != null && !codigoBarras.trim().isEmpty();
        /*
        colocar mais uma condição no cod.barrar para sempre ter 13 caracteres codigoBarras.lenght() != 13;
         */
    }
    private boolean isValidRef() {
        return ref != null && !ref.trim().isEmpty();
    }
    private boolean isValidCor () {
        return cor != null && !cor.trim().isEmpty();
    }
    private boolean isValidTamanho() {
        return tamanho != null && !tamanho.trim().isEmpty();
    }
}
