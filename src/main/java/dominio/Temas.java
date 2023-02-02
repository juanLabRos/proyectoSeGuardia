/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jon
 */
@Entity
@Table(name = "temas")
@NamedQueries({
    @NamedQuery(name = "Temas.findAll", query = "SELECT t FROM Temas t"),
    @NamedQuery(name = "Temas.findByIdtemas", query = "SELECT t FROM Temas t WHERE t.idtemas = :idtemas"),
    @NamedQuery(name = "Temas.findByNombreTema", query = "SELECT t FROM Temas t WHERE t.nombreTema = :nombreTema")})
public class Temas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtemas")
    private Integer idtemas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombreTema")
    private String nombreTema;
    @OneToMany(mappedBy = "idTema")
    private List<Examen> examenList;

    public Temas() {
    }

    public Temas(Integer idtemas) {
        this.idtemas = idtemas;
    }

    public Temas(Integer idtemas, String nombreTema) {
        this.idtemas = idtemas;
        this.nombreTema = nombreTema;
    }

    public Integer getIdtemas() {
        return idtemas;
    }

    public void setIdtemas(Integer idtemas) {
        this.idtemas = idtemas;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtemas != null ? idtemas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temas)) {
            return false;
        }
        Temas other = (Temas) object;
        if ((this.idtemas == null && other.idtemas != null) || (this.idtemas != null && !this.idtemas.equals(other.idtemas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Temas[ idtemas=" + idtemas + " ]";
    }
    
}
