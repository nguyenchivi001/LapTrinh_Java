package BTVN;
import java.util.Scanner;
public class Bai5 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap do dai (m): ");
        double meters = scanner.nextDouble();

        System.out.print("Nhap nhiet do (C): ");
        double celsius = scanner.nextDouble();

        double feet = meters * 3.281;

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Do dai trong ft&inch: " + feet + " ft ");
        System.out.println("Nhiet do trong Fahrenheit: " + fahrenheit + " độ F");
    }
}

