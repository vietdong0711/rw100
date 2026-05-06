package entity;

public class TransferPayment {
    public void pay() {
        // Kiểm tra tài khoản có đủ tiền ko
        boolean checkTaiKhoan = true;
        if (checkTaiKhoan) {
            System.out.println("Thanh toán thành công");
        } else {
            System.out.println("Tài khoản không đủ");
        }
    }
}
