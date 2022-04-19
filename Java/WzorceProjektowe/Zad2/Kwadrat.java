public class Kwadrat implements Selektor
{
    public double a;
    public String typ = "Kwadrat";
    public Kwadrat(double a)
    {
        this.a = a;
    }
    public void Rysuj ()
    {
        for (int j=0;j<a;j++)
        {
            for (int i=0;i<a;i++)
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}

