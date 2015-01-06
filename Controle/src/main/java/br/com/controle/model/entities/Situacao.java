/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author provider
 */
@Entity
@Table(name="situacao")
public class Situacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name ="id", unique = true, nullable = false)
    private int id;
    @Column (name ="desc",  nullable = false)
    private String desc;
    
    @OneToMany(mappedBy = "situacao", fetch = FetchType.LAZY)
    @ForeignKey(name="SituaaoLocacao")
    private List<Locacao> locacoes;

    public Situacao() {
    }
    

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.controle.model.entities.Situacao[ id=" + id + " ]";
    }
    
}
