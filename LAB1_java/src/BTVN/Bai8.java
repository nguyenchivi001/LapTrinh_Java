package BTVN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Bai8
{
    public static void main(String[] args)
    {
        try
        {
                Scanner scanner = new Scanner(new File("input.txt"));
                PrintWriter writer = new PrintWriter(new File("output.txt"));
                int numOfDay = Integer.parseInt(scanner.nextLine().trim());
                double sum_allday = 0.0;
                double []temp_max_arr = new double[numOfDay];
                double []temp_min_arr = new double[numOfDay];
                for (int i = 0; i < numOfDay; i++) {
                    String arrTemp[] = scanner.nextLine().trim().split(" ");
                    double sum = 0.0;
                    double temp_max = Double.parseDouble(arrTemp[0]);
                    double temp_min = Double.parseDouble(arrTemp[0]);
                    for (String temp : arrTemp) {
                        double temperature = Double.parseDouble(temp);
                        sum += temperature;
                        if (temp_max < temperature) temp_max = temperature;
                        if (temp_min > temperature) temp_min = temperature;
                    }
                    sum_allday += sum;
                    double avgTemp = sum/12;
                    temp_max_arr[i] = temp_max;
                    temp_min_arr[i] = temp_min;
                    writer.println("Nhiet do trung binh ngay " + (i+1) + ": " + avgTemp);
                    writer.println("Nhiet do cao nhat ngay " + (i+1) + ": " + temp_max);
                    writer.println("Nhiet do thap nhat ngay " + (i+1) + ": " + temp_min);
                }
                Arrays.sort(temp_min_arr);
                Arrays.sort(temp_max_arr);
                writer.println("Nhiet do trung binh tat ca cac ngay: " + sum_allday/(numOfDay*12));
                writer.println("Nhiet do cao nhat trong tat ca cac ngay: " + temp_max_arr[numOfDay-1]);
                writer.println("Nhiet do thap nhat trong tat ca cac ngay: " + temp_min_arr[0]);
                scanner.close();
                writer.close();

        } catch (FileNotFoundException e)
        {
                e.printStackTrace();
        }
    }
}
