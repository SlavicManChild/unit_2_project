import java.util.Scanner;
class LinearEquationLogic {
    private Scanner scan;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }
    public void start() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Welcome to the linear equation calculator! \n");
            System.out.println("Enter the first coordinate: ");
            String cord1 = scan.nextLine();
            System.out.println("Enter the second coordinate: ");
            String cord2 = scan.nextLine();

            LinearEquation line1 = new LinearEquation(cord1, cord2);

            System.out.println(line1.lineInfo());

            System.out.println("Enter the x value to find the corresponding y: ");
            double x = scan.nextDouble();
            System.out.println("Coordinate point on the line: " + line1.theEquation(x));

            System.out.println("Do you want to enter more coordinates? (yes/no): ");
            String response = scan.next();
            repeat = response.equals("yes");
            scan.nextLine();
        }
        scan.close();
    }
}