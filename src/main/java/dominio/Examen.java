/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jon
 */
@Entity
@Table(name = "examen")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdexamen", query = "SELECT e FROM Examen e WHERE e.idexamen = :idexamen"),
    @NamedQuery(name = "Examen.findByNombreExamen", query = "SELECT e FROM Examen e WHERE e.nombreExamen = :nombreExamen"),
    @NamedQuery(name = "Examen.findExamenByTema", query = "SELECT e FROM Examen e WHERE e.idTema = :idTema")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamen")
    private Integer idexamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombreExamen")
    private String nombreExamen;
    @JoinColumn(name = "idTema", referencedColumnName = "idtemas")
    @ManyToOne
    private Temas idTema;

    public Examen() {
    }

    public Examen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Examen(Integer idexamen, String nombreExamen) {
        this.idexamen = idexamen;
        this.nombreExamen = nombreExamen;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public Temas getIdTema() {
        return idTema;
    }

    public void setIdTema(Temas idTema) {
        this.idTema = idTema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Examen[ idexamen=" + idexamen + " ]";
    }

}
