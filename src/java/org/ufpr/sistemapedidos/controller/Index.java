/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ufpr.sistemapedidos.model.Cliente;
import org.ufpr.sistemapedidos.model.ItemDoPedido;
import org.ufpr.sistemapedidos.model.Pedido;
import org.ufpr.sistemapedidos.model.Produto;
import org.ufpr.sistemapedidos.model.dao.ClienteDAO;
import org.ufpr.sistemapedidos.model.dao.ItemDoPedidoDAO;
import org.ufpr.sistemapedidos.model.dao.ProdutoDAO;

/**
 *
 * @author LuanComputacao
 */
public class Index extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCpf("00000000000");
        cliente.setNome("Luan Roger");
        cliente.setSobrenome("Santana");
        System.out.println(cliente.getId());
        clienteDao.persist(cliente);

        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setDescricao("Lápis B2");
        produtoDao.persist(produto);

        Produto produto2 = new Produto();
        produto2.setDescricao("Lápis B6");
        produtoDao.persist(produto2);

        ItemDoPedidoDAO itemDoPedidoDao = new ItemDoPedidoDAO();
        ItemDoPedido itemDoPedido = new ItemDoPedido();
        itemDoPedido.setProduto(produto);
        itemDoPedidoDao.persist(itemDoPedido);
        Collection<ItemDoPedido> itemDoPedidoCollection = new HashSet<>();
        boolean addedItemDoPedido = itemDoPedidoCollection.add(itemDoPedido);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(new Date());
        pedido.setItemDoPedidoCollection(itemDoPedidoCollection);


        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Index</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Index at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
