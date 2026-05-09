package entity;

public class DebitPayment {
    public void pay() {
        // Kiểm tra xem vượt hạn mức chưa
        boolean checkHanMuc = true;
        if (checkHanMuc) {
            System.out.println("Đã vượt hạn mức thành toán");
        } else {
            System.out.println("Thanh toán thành công");
        }
    }
}
