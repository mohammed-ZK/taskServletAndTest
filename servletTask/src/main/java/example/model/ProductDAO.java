package example.model;
import java.util.ArrayList;
import java.util.List;

//public class ProductDAO {
//    private static List<Product> productList = new ArrayList<>();
//    private static int nextId = 1;
//
//    public static void addProduct(Product product) {
//        product.setId(nextId++);
//        productList.add(product);
//    }
//
//    public static List<Product> getAllProducts() {
//        return productList;
//    }
//
//    public static Product getProductById(int id) {
//        for (Product product : productList) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    public static void updateProduct(int id, Product updatedProduct) {
//        for (Product product : productList) {
//            if (product.getId() == id) {
//                product.setName(updatedProduct.getName());
//                product.setPrice(updatedProduct.getPrice());
//                return;
//            }
//        }
//    }
//
//    public static void deleteProduct(int id) {
//        productList.removeIf(product -> product.getId() == id);
//    }
//}
//
