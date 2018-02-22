/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LuanComputacao
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.pedidoPK.id = :id"),
    @NamedQuery(name = "Pedido.findByDataPedido", query = "SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedido.findByIdCliente", query = "SELECT p FROM Pedido p WHERE p.pedidoPK.idCliente = :idCliente")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoPK pedidoPK;
    
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Collection<ItemDoPedido> itemDoPedidoCollection;
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Pedido(int id, int idCliente) {
        this.pedidoPK = new PedidoPK(id, idCliente);
    }

    public PedidoPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @XmlTransient
    public Collection<ItemDoPedido> getItemDoPedidoCollection() {
        return itemDoPedidoCollection;
    }

    public void setItemDoPedidoCollection(Collection<ItemDoPedido> itemDoPedidoCollection) {
        this.itemDoPedidoCollection = itemDoPedidoCollection;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoPK != null ? pedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoPK == null && other.pedidoPK != null) || (this.pedidoPK != null && !this.pedidoPK.equals(other.pedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ufpr.sistemapedidos.model.Pedido[ pedidoPK=" + pedidoPK + " ]";
    }
    
}
