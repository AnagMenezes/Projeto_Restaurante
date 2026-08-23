package com.anagabriella.restaurante.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn (name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Double getPrecoUnitario() {
    return precoUnitario;
}

    public Integer getQuantidade() {
    return quantidade;
}

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double calcularValorTotal() {
        return this.precoUnitario * this.quantidade;
}

    public void validarQuantidade (Integer quantidade ){
        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade inválida.");
    }
}
}