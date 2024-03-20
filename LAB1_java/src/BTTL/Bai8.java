package BTTL;
import java.util.Scanner;
public class Bai8
{
    public static void main(String[] args)
    {
        System.out.println("Bang tinh Pythagoras:");
        System.out.println("----------------------");
        for(int i=0; i<=10 ; i++)
        {
            for(int j=0; j<=10 ; j++)
            {
                if (i == 0 && j == 0) System.out.print("X ");
                else if (i == 0) System.out.print(j + " ");
                else if (j == 0) System.out.print(i + " ");
                else System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
