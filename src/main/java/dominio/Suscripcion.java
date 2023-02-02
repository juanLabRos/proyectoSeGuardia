/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jon
 */
@Entity
@Table(name = "suscripcion")
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s"),
    @NamedQuery(name = "Suscripcion.findByIdsuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.idsuscripcion = :idsuscripcion"),
    @NamedQuery(name = "Suscripcion.findByFechaInicio", query = "SELECT s FROM Suscripcion s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Suscripcion.findByFechaFin", query = "SELECT s FROM Suscripcion s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Suscripcion.findByPrecio", query = "SELECT s FROM Suscripcion s WHERE s.precio = :precio"),
    @NamedQuery(name = "Suscripcion.findByIdUsuario", query = "SELECT s FROM Suscripcion s WHERE s.usuarioIdusuario = :idUsuario")})
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsuscripcion")
    private Integer idsuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Suscripcion() {
    }

    public Suscripcion(Integer idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public Suscripcion(Integer idsuscripcion, Date fechaInicio, Date fechaFin, float precio) {
        this.idsuscripcion = idsuscripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    public Integer getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(Integer idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuscripcion != null ? idsuscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.idsuscripcion == null && other.idsuscripcion != null) || (this.idsuscripcion != null && !this.idsuscripcion.equals(other.idsuscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Suscripcion[ idsuscripcion=" + idsuscripcion + " ]";
    }

}
