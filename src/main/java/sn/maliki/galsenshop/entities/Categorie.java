/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.maliki.galsenshop.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMC
 */
@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCode", query = "SELECT c FROM Categorie c WHERE c.code = :code"),
    @NamedQuery(name = "Categorie.findByLibelle", query = "SELECT c FROM Categorie c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Categorie.findByDescription", query = "SELECT c FROM Categorie c WHERE c.description = :description"),
    @NamedQuery(name = "Categorie.findByTva", query = "SELECT c FROM Categorie c WHERE c.tva = :tva")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TVA")
    private BigDecimal tva;

    public Categorie() {
    }

    public Categorie(String code) {
        this.code = code;
    }

    public Categorie(String code, String libelle, BigDecimal tva) {
        this.code = code;
        this.libelle = libelle;
        this.tva = tva;
    }

    public Categorie(String code, String libelle, String description, BigDecimal tva) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.tva = tva;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.maliki.galsenshop.entities.Categorie[ code=" + code + " ]";
    }
    
}
