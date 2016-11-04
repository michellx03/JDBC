package br.com.k19.jdbc;

public class Livro {
    private Long id;
    private String titulo;
    private Double preco;
    private Long editora_id;
    
    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(Long editora_id) {
        this.editora_id = editora_id;
    }
    
}
