/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.ufpr.sistemapedidos.model.ItemDoPedido;
import org.ufpr.sistemapedidos.utils.JpaUtil;

/**
 *
 * @author LuanComputacao
 */
public class ItemDoPedidoDAO {

    public void salvar(ItemDoPedido itemDoPedido) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(itemDoPedido);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void excluir(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            ItemDoPedido itemDoPedido = entityManager.find(ItemDoPedido.class, id);
            entityManager.remove(itemDoPedido);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public ItemDoPedido consultarPorId(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        ItemDoPedido itemDoPedido = null;
        try {
            TypedQuery<ItemDoPedido> query = entityManager.createNamedQuery("ItemDoPedido.findAll", ItemDoPedido.class);
            query.setParameter("id", id);
            itemDoPedido = query.getSingleResult();
        } catch (Exception e) {
            itemDoPedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return itemDoPedido;
    }

    public ItemDoPedido consultarPorIdPedido(Long idPedido) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        ItemDoPedido itemDoPedido = null;
        try {
            TypedQuery<ItemDoPedido> query = entityManager.createNamedQuery("ItemDoPedido.findByIdPedido", ItemDoPedido.class);
            query.setParameter("id", idPedido);
            itemDoPedido = query.getSingleResult();
        } catch (Exception e) {
            itemDoPedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return itemDoPedido;
    }

    public ItemDoPedido consultarPorIdProduto(Long idProduto) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        ItemDoPedido itemDoPedido = null;
        try {
            TypedQuery<ItemDoPedido> query = entityManager.createNamedQuery("ItemDoPedido.findByIdProduto", ItemDoPedido.class);
            query.setParameter("id", idProduto);
            itemDoPedido = query.getSingleResult();
        } catch (Exception e) {
            itemDoPedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return itemDoPedido;
    }
}
