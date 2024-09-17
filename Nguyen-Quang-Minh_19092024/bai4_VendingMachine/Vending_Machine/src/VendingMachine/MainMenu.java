package VendingMachine;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        VendingMachineControll vm = new VendingMachineControll();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Máy Bán Hàng Tự Động ---");
            System.out.println("1. Mua sản phẩm");
            System.out.println("2. Quản lý kho hàng");
            System.out.println("3. Hiển thị tất cả sản phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Mua sản phẩm
                    vm.displayProducts();
                    System.out.print("Chọn sản phẩm : ");
                    int productId = scanner.nextInt();
                    System.out.println("Chọn số lượng muốn mua: ");
                    int buyQuantity = scanner.nextInt();
                    
                    System.out.print("Nạp tiền: ");
                    long payment = scanner.nextLong();

                    vm.selectProduct(productId, payment, buyQuantity);
                    break;

                case 2:
                    // Quản lý kho hàng
                    System.out.println("\n--- Quản lý kho hàng ---");
                    System.out.println("1. Thêm sản phẩm");
                    System.out.println("2. Cập nhật số lượng sản phẩm");
                    System.out.println("3. Xóa sản phẩm");
                    System.out.println("4. Quay lại");
                    System.out.print("Chọn tùy chọn: ");
                    int manageOption = scanner.nextInt();

                    switch (manageOption) {
                        case 1:
                            // Thêm sản phẩm
                            System.out.print("Nhập tên sản phẩm: ");
                            String name = scanner.next();
                            System.out.print("Nhập giá sản phẩm: ");
                            int price = scanner.nextInt();
                            System.out.print("Nhập số lượng sản phẩm: ");
                            int quantity = scanner.nextInt();
                            vm.addProduct(name, price, quantity);
                            break;

                        case 2:
                            // Cập nhật số lượng sản phẩm
                            System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                            int updateId = scanner.nextInt();
                            System.out.print("Nhập số lượng mới: ");
                            int newQuantity = scanner.nextInt();
                            vm.updateProductQuantity(updateId, newQuantity);
                            break;

                        case 3:
                            // Xóa sản phẩm
                            System.out.print("Nhập ID sản phẩm cần xóa: ");
                            int removeId = scanner.nextInt();
                            vm.removeProduct(removeId);
                            break;

                        case 4:
                            // Quay lại
                            break;

                        default:
                            System.out.println("Tùy chọn không hợp lệ.");
                    }
                    break;

                case 3:
                    // Hiển thị tất cả sản phẩm
                    vm.displayAllProducts();
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Cảm ơn bạn đã sử dụng máy bán hàng!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Tùy chọn không hợp lệ.");
            }
        }
    }
}
