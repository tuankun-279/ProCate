/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class ActionController extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product std = new Product(0);
        
        if(request.getParameter("id") != null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductPU");
            EntityManager em = factory.createEntityManager();
            
            int id = Integer.parseInt(request.getParameter("id"));
            std = em.find(Product.class, id);
        }
        request.setAttribute("std", std);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product/action.jsp");
            dispatcher.forward(request, response);
        
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name").toString();
        String price = request.getParameter("price").toString();
        String quantity = request.getParameter("quantity").toString();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductPU");
        EntityManager em = factory.createEntityManager();
        
        if(id == 0){
            Product pro = new Product();
            pro.setProductName(name);
            pro.setPrice(Double.parseDouble(price));        
            pro.setQuantity(Integer.parseInt(quantity));

            em.getTransaction().begin();
            em.persist(pro);
            em.getTransaction().commit();
        }else{
            Product proEdit = em.find(Product.class, id);
            
            em.getTransaction().begin();
            proEdit.setProductName(name);
            proEdit.setPrice(Double.parseDouble(price));        
            proEdit.setQuantity(Integer.parseInt(quantity));
            em.getTransaction().commit();
        }
        
        response.sendRedirect("/Product/products-list");
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
