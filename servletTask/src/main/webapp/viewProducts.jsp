<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="example.model.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
    <style>
            body {
                font-family: Arial, sans-serif;
            }
            h1 {
                color: #333;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid #ddd;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            a {
                color: #007bff;
                text-decoration: none;
            }
            a:hover {
                text-decoration: underline;
            }
        </style>
</head>
<body>
    <h1>Products List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
                <%
                    List<Product> products = (List<Product>) request.getAttribute("products");
                    if (products != null) {
                        for (int i = 0; i < products.size(); i++) {
                            Product product = products.get(i);
                %>
                <tr>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                    <td>
                        <a href="editProduct.jsp?productId=${product.id}">Edit</a>
                        <a href="deleteProduct?productId=${product.id}">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
    </table>
    <br>
    <a href="addProduct">Add New Product</a>
</body>
</html>