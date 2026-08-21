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
}