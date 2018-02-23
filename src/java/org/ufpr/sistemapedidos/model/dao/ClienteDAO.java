/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.ufpr.sistemapedidos.model.Cliente;
import org.ufpr.sistemapedidos.utils.JpaUtil;

/**
 *
 * @author LuanComputacao
 */
public class ClienteDAO {

    public void salvar(Cliente cliente) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
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
            Cliente cliente = entityManager.find(Cliente.class, id);
            entityManager.remove(cliente);
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

        List <Cliente> clientes = null;
        try {
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.findAll", Cliente.class);
            clientes = query.getResultList();
        } catch (Exception e) {
            clientes = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return clientes;
    }
    
    public Cliente consultarPorId(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = null;
        try {
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.findById", Cliente.class);
            query.setParameter("id", id);
            cliente = query.getSingleResult();
        } catch (Exception e) {
            cliente = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return cliente;
    }

    public Cliente consultarPorCpf(String cpf) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = null;
        try {
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.findByCpf", Cliente.class);
            query.setParameter("cpf", cpf);
            cliente = query.getSingleResult();
        } catch (Exception e) {
            cliente = null;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return cliente;
    }
}
