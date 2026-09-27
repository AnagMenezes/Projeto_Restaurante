package com.anagabriella.restaurante.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagem;
    private Boolean disponivel;

    @OneToMany(mappedBy = "produto") ///objeto referenciado no itenproduto
    private List<ItemPedido> itensPedido;

    @ManyToOne
    private Categoria categoria;


    public Integer getId() {
        return id;
}
    public String getNome(){
        return nome;
}
    public void setNome(String nome) {
        this.nome = nome;
}
    public String getDescricao(){
        return descricao;
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
}
    public Double getPreco(){
        return preco;
}
    public void setPreco(Double preco) {
        this.preco = preco;
}
public String getImagem() {
    return imagem;
}
public void setImagem(String imagem) {
    this.imagem = imagem;
}
public Categoria getCategoria() {
    return categoria;
}
public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
}
    public Boolean getDisponivel() {
        return disponivel;
}
public void setDisponivel(Boolean disponivel) {
    this.disponivel = disponivel;
}
}
