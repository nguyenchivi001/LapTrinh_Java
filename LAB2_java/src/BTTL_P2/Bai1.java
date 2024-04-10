package BTTL_P2;
import java.util.Scanner;
abstract class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return age;
    }

    public abstract void Show();
}

class Employee extends Person
{
    private double salary;

    public Employee(String name, int age, double salary)
    {
        super(name, age);
        this.salary = salary;
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public void addSalary()
    {
        salary = salary * 1.1;
    }

    public void addSalary(double amount)
    {
        salary = salary + amount;
    }
    public void Show()
    {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: " + getSalary());
    }
}

public class Bai1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = sc.nextInt();
        System.out.println("Nhap luong: ");
        double salary = sc.nextDouble();
        Employee employee = new Employee(name, age, salary);
        employee.Show();
        employee.addSalary();
        System.out.println("Sau khi tang luong co ban:");
        employee.Show();

        employee.addSalary(7000);
        System.out.println("Sau khi tang luong theo gia tri:");
        employee.Show();
    }
}
