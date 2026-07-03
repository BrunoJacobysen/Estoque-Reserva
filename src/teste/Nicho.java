package teste;

public class Nicho {

    public String codigo;
    public int quantidadePecas;
    public String descricao;                //descrição de qual tipo de peça vai ser colocado no nicho

    public Nicho(String codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }


    public boolean isValid() {
        return isValidCodig() && isValidDesc();
    }

    public String getErrorValidacao() {
        if (!isValidDesc()) return "Descrição do nicho inválida.";
        if (isValidCodig()) return "Código do nicho inválida.";
        return null;
    }

    public int get_quantPc() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public String get_Descricao() {
        return descricao;
    }


    public String get_Codigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isValidDesc() {
        return descricao != null && !descricao.trim().isEmpty();
    }

    public boolean isValidCodig() {
        return codigo != null && !codigo.trim().isEmpty();
    }
}
