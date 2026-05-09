package entity;


public class GiangVien extends Account {
    private Integer expInYear;


    public Integer getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(Integer expInYear) {
        this.expInYear = expInYear;
    }

    public void anTrua() {
        System.out.println("Giang viên về nhà ăn với gia đình");
    }

}
