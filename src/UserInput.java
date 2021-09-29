import java.util.Scanner;
public class UserInput {
    public String getString() {
        System.out.print("> ");
        Scanner getkboard = new Scanner(System.in);
        return getkboard.nextLine();
    }
}
