/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LuanComputacao
 */
@Entity
@Table(name = "item_do_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemDoPedido.findAll", query = "SELECT i FROM ItemDoPedido i"),
    @NamedQuery(name = "ItemDoPedido.findByQtdade", query = "SELECT i FROM ItemDoPedido i WHERE i.qtdade = :qtdade"),
    @NamedQuery(name = "ItemDoPedido.findByIdPedido", query = "SELECT i FROM ItemDoPedido i WHERE i.itemDoPedidoPK.idPedido = :idPedido"),
    @NamedQuery(name = "ItemDoPedido.findByIdProduto", query = "SELECT i FROM ItemDoPedido i WHERE i.itemDoPedidoPK.idProduto = :idProduto")})
public class ItemDoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemDoPedidoPK itemDoPedidoPK;
    
    @Size(max = 11)
    @Column(name = "qtdade", length = 11)
    private String qtdade;
   
    @JoinColumns({
        @JoinColumn(name = "id_pedido", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false),
    })
    @ManyToOne(optional = false)
    private Pedido pedido;
    
    @JoinColumn(name = "id_produto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public ItemDoPedido() {
    }

    public ItemDoPedido(ItemDoPedidoPK itemDoPedidoPK) {
        this.itemDoPedidoPK = itemDoPedidoPK;
    }

    public ItemDoPedido(int idPedido, int idProduto) {
        this.itemDoPedidoPK = new ItemDoPedidoPK(idPedido, idProduto);
    }

    public ItemDoPedidoPK getItemDoPedidoPK() {
        return itemDoPedidoPK;
    }

    public void setItemDoPedidoPK(ItemDoPedidoPK itemDoPedidoPK) {
        this.itemDoPedidoPK = itemDoPedidoPK;
    }

    public String getQtdade() {
        return qtdade;
    }

    public void setQtdade(String qtdade) {
        this.qtdade = qtdade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemDoPedidoPK != null ? itemDoPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDoPedido)) {
            return false;
        }
        ItemDoPedido other = (ItemDoPedido) object;
        if ((this.itemDoPedidoPK == null && other.itemDoPedidoPK != null) || (this.itemDoPedidoPK != null && !this.itemDoPedidoPK.equals(other.itemDoPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ufpr.sistemapedidos.model.ItemDoPedido[ itemDoPedidoPK=" + itemDoPedidoPK + " ]";
    }
    
}
