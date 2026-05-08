package demo;

public class TransferPayment implements INganHang, INganHang1 {


    @Override
    public void pay1(int a) {

    }

    @Override
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
