//package example.controller;
//
//import example.model.ProductDAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//// DeleteProductServlet.java
//@WebServlet("/deleteProduct")
//public class DeleteProductServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve product ID to delete
//        int productId = Integer.parseInt(request.getParameter("id"));
//
//        // Delete product from data storage (e.g., database)
//        ProductDAO.deleteProduct(productId);
//
//        // Redirect back to product list
//           response.sendRedirect("products");
//    }
//}
