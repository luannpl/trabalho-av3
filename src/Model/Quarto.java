package Model;
public class Quarto {
    
    private String codigo;
    private Categoria categoria;
    private String status;

    public Quarto(String codigo, Categoria categoria, String status) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
    return "Quarto{" +
            "codigo='" + codigo + '\'' +
            ", categoria=" + categoria.getDescricao() + 
            ", status='" + status + '\'' +
            '}';
}
    
}
