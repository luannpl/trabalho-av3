package Model;

public class CategoriaItem {
    
    private Item item;
    private Categoria categoria;
    private int quantidade;

    public CategoriaItem(Item item, Categoria categoria, int quantidade) {
        this.item = item;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
    return "CategoriaItem{" +
            "item=" + item.getCodigo() +
            ", categoria=" + categoria.getCodigo() +
            ", quantidade=" + quantidade +
            '}';
}

    

    



}
