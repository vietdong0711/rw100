//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        System.out.println("Department ID: " + department1.id);
        System.out.println("Department Name: " + department1.name);

    }
}