public class Prostokat implements Selektor
{
        public double a;
        public double b;
        public String typ = "Prostokat";
        public Prostokat(double a, double b)
        {
                this.a = a;
                this.b = b;

        }
        public void Rysuj ()
        {
                for (int j=0;j<b;j++)
                {
                        for (int i=0;i<a;i++)
                        {
                                System.out.print("* ");
                        }
                        System.out.print("\n");
                }
        }

}
