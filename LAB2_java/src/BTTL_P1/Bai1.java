package BTTL_P1;
import java.util.Scanner;

class Pointer
{
    private double x,y;
    public Pointer(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void PrintPointer()
    {
        System.out.println("(" + this.x + "," + this.y + ")");
    }
    public double distance(Pointer other)
    {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

}
public class Bai1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap pointer thu nhat (x, y): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.println("Nhap pointer thu hai (x, y): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        Pointer p1 = new Pointer(x1, y1);
        Pointer p2 = new Pointer(x2, y2);
        System.out.print("Pointer 1: ");
        p1.PrintPointer();
        System.out.print("Pointer 2: ");
        p2.PrintPointer();
        System.out.println("Khoang cach giua 2 pointer: " + p1.distance(p2));
    }
}

