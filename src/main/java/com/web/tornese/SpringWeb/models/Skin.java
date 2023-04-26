package com.web.tornese.SpringWeb.models;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "skin")
public class Skin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "nome", length = 100, nullable = false)
  private String nome;

  @Column(name = "raridade", length = 180, nullable = false)
  private String raridade;

  @Column(name = "preco", length = 255, nullable = false)
  private String preco;

  @Column(name = "observacao")
  @Type(type = "text")
  private String observacao;

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRaridade() {
    return raridade;
  }

  public void setRaridade(String raridade) {
    this.raridade = raridade;
  }

  public String getPreco() {
    return preco;
  }

  public void setPreco(String preco) {
    this.preco = preco;
  }
}
