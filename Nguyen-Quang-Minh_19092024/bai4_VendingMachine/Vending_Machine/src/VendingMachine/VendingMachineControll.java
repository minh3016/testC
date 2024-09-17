package VendingMachine;

import java.util.HashMap;
import java.util.Scanner;

public class VendingMachineControll {
    private HashMap<Integer, Product> products = new HashMap<>();
    private int nextProductId = 5; 

    public VendingMachineControll() {
        
        products.put(1, new Product("Khoai tây chiên", 50000, 10));
        products.put(2, new Product("Nước ngọt", 15000, 8));
        products.put(3, new Product("Kẹo", 22000, 15));
        products.put(4, new Product("Nước ép", 30000, 5));
    }

    // Hiển thị các sản phẩm còn hàng
    public void displayProducts() {
        System.out.println("Các sản phẩm có sẵn:");
        for (int id : products.keySet()) {
            Product product = products.get(id);
            if (product.isAvailable()) {
                System.out.println(id + ": " + product.getName() + " - Giá: " + product.getPrice() + " - Số lượng: " + product.getQuantity());
            }
        }
    }

    // Hiển thị tất cả sản phẩm, kể cả hết hàng
    public void displayAllProducts() {
        System.out.println("Danh sách tất cả sản phẩm:");
        for (int id : products.keySet()) {
            Product product = products.get(id);
            String availability = product.isAvailable() ? "Còn hàng" : "Hết hàng";
            System.out.println(id + ": " + product.getName() + " - Giá: " + product.getPrice() + " - Số lượng: " + product.getQuantity() + " (" + availability + ")");
        }
    }

    
    public void selectProduct(int productId, long payment,int buyQuantity) {
    	if (!products.containsKey(productId)) {
            System.out.println("Sản phẩm bạn chọn không hợp lệ.");
            return;
        }

        Product selectedProduct = products.get(productId);
        if (!selectedProduct.isAvailable()) {
            System.out.println("Xin lỗi, " + selectedProduct.getName() + " đã hết hàng.");
            return;
        }
        long totalPayment = payment;
        long totalPrice = selectedProduct.getPrice() * buyQuantity;
        Scanner scanner = new Scanner(System.in);
        while (totalPayment < totalPrice) {
            System.out.println("Bạn cần thanh toán " + totalPrice);
            

            if (totalPayment < totalPrice) {
            	long addPayment = totalPrice - totalPayment;
                System.out.println("Số tiền hiện tại không đủ. Bạn đã nạp: " + totalPayment + ". Vui lòng nạp thêm " + addPayment);
                System.out.println("Nạp thêm: ");
                addPayment = scanner.nextLong();
                totalPayment += addPayment;
            }
            
        }

        
        selectedProduct.dispense();
        long change = totalPayment - totalPrice;
        System.out.println("Đang phát " + selectedProduct.getName());
        if (change > 0) {
            System.out.println("Tiền thừa: " + change);
            System.out.println("Hoàn tất mua hàng!!!");
        }
    }

    
    public void addProduct(String name, int price, int quantity) {
        products.put(nextProductId, new Product(name, price, quantity));
        System.out.println("Đã thêm sản phẩm: " + name + " (ID: " + nextProductId + ")");
        nextProductId++;
    }

    
    public void updateProductQuantity(int productId, int newQuantity) {
        if (!products.containsKey(productId)) {
            System.out.println("Sản phẩm bạn chọn không tồn tại.");
            return;
        }
        Product product = products.get(productId);
        product.setQuantity(newQuantity);
        System.out.println("Đã cập nhật số lượng của " + product.getName() + " thành " + newQuantity);
    }

    public void removeProduct(int productId) {
        if (!products.containsKey(productId)) {
            System.out.println("Sản phẩm bạn chọn không tồn tại.");
            return;
        }
        products.remove(productId);
        System.out.println("Đã xóa sản phẩm có ID: " + productId);
    }
}
