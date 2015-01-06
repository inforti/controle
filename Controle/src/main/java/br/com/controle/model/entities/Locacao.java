/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author provider
 */
@Entity
@Table (name ="locacao")
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name ="id", unique = true, nullable = false)
    private int id;
    @Column (name ="locador",nullable = false)
    private String locador;
    @Column (name ="quantidade",nullable = false)
    private int quantidade;
  
        
    @ManyToOne(optional = false)
    @ForeignKey(name="ProdutoLocacao")
    @JoinColumn(name ="id",referencedColumnName = "id")
    private Produto produtos;
    
    
    @ManyToOne(optional = false)
    @ForeignKey(name="SetorLocacao")
    @JoinColumn(name ="id",referencedColumnName = "id")
    private Setor setor;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name="SituaaoLocacao")
    @JoinColumn(name ="id",referencedColumnName = "id")
    private Situacao situacao;

    public Locacao(Produto produtos, Setor setor, Situacao situacao) {
        this.produtos = produtos;
        this.setor = setor;
        this.situacao = situacao;
    }
   
          
 
   

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

   
  
    

    public int getId() {
        return id;
           }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.controle.model.entities.Locacao[ id=" + id + " ]";
    }
    
}
