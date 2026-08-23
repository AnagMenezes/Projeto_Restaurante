package com.anagabriella.restaurante.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataPedido;
    private Double valorTotal;
    private String status;
  
   @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)///Ao colocar CascadeType.ALL na lista de itens do seu Pedido, quando você executa pedidoRepository.save(pedido), o Spring faz o trabalho sujo. Ele vai ao banco, salva os itens de forma invisível e depois salva o pedido, mantendo tudo amarrado.
    private List<ItemPedido> itens = new ArrayList<>();

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }


    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void atualizarValorTotal() {
    Double soma = 0.0; 
    
    for (ItemPedido item : this.itens) {
        soma = soma + item.calcularValorTotal();
    }
    this.valorTotal = soma;
}



}