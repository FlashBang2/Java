public class JavaApplication1
{
    public static void main(String[] args)
    {
        Rysownik rysownik = new Rysownik();
        Trojkat trojkat=new Trojkat(6);
        Kwadrat kwadrat=new Kwadrat(6);
        Prostokat prostokat=new Prostokat(6,8);
        rysownik.Rysuj(trojkat);
        System.out.print("\n");
        rysownik.Rysuj(kwadrat);
        System.out.print("\n");
        rysownik.Rysuj(prostokat);
    }
}
