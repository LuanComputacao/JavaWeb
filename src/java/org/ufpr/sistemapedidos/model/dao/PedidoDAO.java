/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.ufpr.sistemapedidos.model.Pedido;
import org.ufpr.sistemapedidos.utils.JpaUtil;

/**
 *
 * @author LuanComputacao
 */
public class PedidoDAO {

    public void salvar(Pedido pedido) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
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
            Pedido pedido = entityManager.find(Pedido.class, id);
            entityManager.remove(pedido);
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

    public List consultarTodos() {
        EntityManager entityManager = JpaUtil.getEntityManager();

        List<Pedido> pedidos = null;
        try {
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.findAll", Pedido.class);
            pedidos = query.getResultList();
        } catch (Exception e) {
            pedidos = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return pedidos;
    }

    public Pedido consultarPorId(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Pedido pedido = null;
        try {
            TypedQuery<Pedido> query = entityManager.createNamedQuery("ItemDoPedido.findAll", Pedido.class);
            query.setParameter("id", id);
            pedido = query.getSingleResult();
        } catch (Exception e) {
            pedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return pedido;
    }

    public Pedido consultarPorDataPedido(Date dataPedido) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Pedido pedido = null;
        try {
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.findByDataPedido", Pedido.class);
            query.setParameter("id", dataPedido);
            pedido = query.getSingleResult();
        } catch (Exception e) {
            pedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return pedido;
    }

    public Pedido consultarPorIdCliente(Long idCliente) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Pedido pedido = null;
        try {
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.findByIdCliente", Pedido.class);
            query.setParameter("id", idCliente);
            pedido = query.getSingleResult();
        } catch (Exception e) {
            pedido = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return pedido;
    }
}
