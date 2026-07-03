import controller.Estoque;
import teste.Produto;

public class TesteEstoque {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto produto1 = new Produto("12345", "0035603", "Pica-Pau Bordado",
                "GG", "Preto", "B1");
        Produto produto2 = new Produto("4321", "0031092", "Camiseta Simples Cores",
                "3G", "Roxo", "C4");

        Produto produto3;
        produto3 = new Produto("1231", "09q8735", "ajkhdgfa", "fas", "asda", "123");
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);

        Produto encontrado1 = estoque.buscar_codigoBarras("12345");
        Produto encontrado2 = estoque.buscar_codigoBarras("4321");

        System.out.println("Item: " + encontrado1.get_Nome());
        System.out.println("Item: " + encontrado2.get_Nome());



    }
}
