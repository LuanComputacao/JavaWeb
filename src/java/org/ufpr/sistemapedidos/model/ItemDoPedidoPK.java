/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LuanComputacao
 */
@Embeddable
public class ItemDoPedidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private int idPedido;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private int idProduto;

    public ItemDoPedidoPK() {
    }

    public ItemDoPedidoPK(int idPedido, int idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDoPedidoPK)) {
            return false;
        }
        ItemDoPedidoPK other = (ItemDoPedidoPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return this.idProduto == other.idProduto;
    }

    @Override
    public String toString() {
        return "org.ufpr.sistemapedidos.model.ItemDoPedidoPK[ idPedido=" + idPedido + ", idProduto=" + idProduto + " ]";
    }
    
}
