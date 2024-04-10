package BTTL_P2;
import java.util.*;

abstract class Robot
{
    private int M;

    public Robot(int M)
    {
        this.M = M;
    }

    public int getM()
    {
        return M;
    }

    public void setM(int M)
    {
        this.M = M;
    }
    public abstract int TinhNangLuong(int S);
    public abstract String InThongTin();
}

class Pedion extends Robot
{
    private int F;

    public Pedion(int M, int F)
    {
        super(M);
        this.F = F;
    }

    public int getF()
    {
        return F;
    }

    public void setF(int F)
    {
        this.F = F;
    }
    public int TinhNangLuong(int S)
    {
        return getM() * S + (F+1)*S/2;
    }
    public String InThongTin()
    {
        return "Pedion - M: " + getM() + " kg, F: " + F;
    }
}

class Zattacker extends Robot
{
    int P;
    public Zattacker(int M, int P)
    {
        super(M);
        this.P = P;
    }
    public int getP()
    {
        return P;
    }
    public void setP(int P)
    {
        this.P = P;
    }
    public int TinhNangLuong(int S)
    {
        return getM() * S + P*P*S;
    }
    public String InThongTin()
    {
        return "Zattacker - M: " + getM() + " kg, P: " + P;
    }
}

class Carrier extends Robot
{
    int E;
    public Carrier(int M, int E)
    {
        super(M);
        this.E = E;
    }
    public int getE()
    {
        return E;
    }
    public void setE(int E)
    {
        this.E = E;
    }
    public int TinhNangLuong(int S)
    {
        return getM() * S + 4*E*S;
    }
    public String InThongTin()
    {
        return "Carrier - M: " + getM() + " kg, E: " + E;
    }
}
public class Bai3
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of Pedion robots: ");
        int A = s.nextInt();
        System.out.print("Enter number of Zattacker robots: ");
        int B = s.nextInt();
        System.out.print("Enter number of Carrier robots: ");
        int C = s.nextInt();

        List<Robot> robotList = new ArrayList<>();

        for(int i = 0; i < A; i++)
        {
            int F = (int) (1 + (Math.random()*4));
            robotList.add(new Pedion(20, F));
        }
        for(int i = 0; i < B; i++)
        {
            int P = (int) (20 + (Math.random()*10));
            robotList.add(new Zattacker(50, P));
        }
        for(int i = 0; i < C; i++)
        {
            int E = (int) (50 + (Math.random()*50));
            robotList.add(new Carrier(30, E));
        }

        for(int i = 0; i < robotList.size(); i++)
        {
            String thongTin = robotList.get(i).InThongTin();
            int energy = robotList.get(i).TinhNangLuong(10);
            System.out.println(thongTin + ", Energy: " + energy);
        }

        int maxEnergyPedion = 0;
        int maxEnergyZattacker = 0;
        int maxEnergyCarrier = 0;
        String maxEnergyType = "";
        for(int i = 0; i < robotList.size(); i++)
        {
            int energy = robotList.get(i).TinhNangLuong(10);
            if(robotList.get(i) instanceof Pedion)
            {
                maxEnergyPedion += energy;
            }
            else if(robotList.get(i) instanceof Zattacker)
            {
                maxEnergyZattacker += energy;
            }
            else
            {
                maxEnergyCarrier += energy;
            }
        }

        int maxEnergy = maxEnergyPedion;
        maxEnergyType = "Pedion";
        if(maxEnergyCarrier > maxEnergy)
        {
            maxEnergy = maxEnergyCarrier;
            maxEnergyType = "Carrier";
        }
        if(maxEnergyZattacker > maxEnergy)
        {
            maxEnergy = maxEnergyZattacker;
            maxEnergyType = "Zattacker";
        }
        System.out.println("Loai robot tieu thu nhieu nang luong nhat la: "+ maxEnergyType);
        System.out.println("Voi muc nang luong la: " + maxEnergy);
    }
}
