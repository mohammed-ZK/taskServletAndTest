//package example.controller;
//
//import example.model.Product;
//import example.model.ProductDAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//// EditProductServlet.java
//@WebServlet("/editProduct")
//public class EditProductServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve updated product information from form
//
//
//        int productId = Integer.parseInt(request.getParameter("id"));
//        String productName = request.getParameter("name");
//        double productPrice = Double.parseDouble(request.getParameter("price"));
//        int productQuantity = Integer.getInteger("quantity");
//
//        // Update product in data storage (e.g., database)
//        ProductDAO.updateProduct(productId, new Product(productName, productPrice,productQuantity));
//
//        // Redirect back to product lis
//            response.sendRedirect("products");
//    }
//}
