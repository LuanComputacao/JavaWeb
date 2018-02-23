/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.ufpr.sistemapedidos.model.Pedido;
import org.ufpr.sistemapedidos.model.Produto;
import org.ufpr.sistemapedidos.utils.JpaUtil;

/**
 *
 * @author LuanComputacao
 */
public class ProdutoDAO {

    public void persist(Produto produto) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
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
            Produto produto = entityManager.find(Produto.class, id);
            entityManager.remove(produto);
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

        List<Produto> produtos = null;
        try {
            TypedQuery<Produto> query = entityManager.createNamedQuery("Pedido.findAll", Produto.class);
            produtos = query.getResultList();
        } catch (Exception e) {
            produtos = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return produtos;
    }

    public Produto consultarPorId(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Produto produto = null;
        try {
            TypedQuery<Produto> query = entityManager.createNamedQuery("ItemDoPedido.findAll", Produto.class);
            query.setParameter("id", id);
            produto = query.getSingleResult();
        } catch (Exception e) {
            produto = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return produto;
    }
}
