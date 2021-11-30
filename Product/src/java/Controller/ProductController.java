package Controller;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class ProductController extends HttpServlet {

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
        try{            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductPU");
            EntityManager em = factory.createEntityManager();
            
            Query query = em.createNamedQuery("Product.findAll", Product.class);
            
            List<Product> productList = query.getResultList();
            
            request.setAttribute("ProductList", productList);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product/product.jsp");
            dispatcher.forward(request, response);
        }catch(Exception e){
            System.err.println("error");
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
         String id_delete = request.getParameter("id_delete");
        if(id_delete != null && !id_delete.isEmpty()){
            int id = Integer.parseInt(id_delete);
            // thuc hien xoa
            
            EntityManagerFactory factory =  Persistence.createEntityManagerFactory("ProductPU");
            EntityManager em = factory.createEntityManager();
            
            Product pro = em.find(Product.class, id);
            
            em.getTransaction().begin();
            em.remove(pro);
            em.getTransaction().commit();
        }           
            
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
        String name = request.getParameter("name").toString();
        String price = request.getParameter("price").toString();
        String quantity = request.getParameter("quantity").toString();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductPU");
        EntityManager em = factory.createEntityManager();
        
        Product pro = new Product();
        pro.setProductName(name);
        pro.setPrice(Double.parseDouble(price));        
        pro.setQuantity(Integer.parseInt(quantity));
        
        em.getTransaction().begin();
        em.persist(pro);
        em.getTransaction().commit();
        
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
