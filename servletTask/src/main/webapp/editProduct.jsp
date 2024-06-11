<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="editProduct" method="post">
        <input type="hidden" name="productId" value="${product.id}">
        Product Name: <input type="text" name="productName" value="${product.name}"><br>
        Product Price: <input type="text" name="productPrice" value="${product.price}"><br>
        Product Quantity: <input type="text" name="productQuantity" value="${product.quantity}"><br>
        <input type="submit" value="Update Product">
    </form>
</body>
</html>