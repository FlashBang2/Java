public class Main
{
    public static void main (String[] args)
    {
        MyCustomList<String> Zwierze= new MyCustomList<>();
        Zwierze.add(4,"Krokodyl");
        Zwierze.add("Pelikan");
        System.out.print(Zwierze.pop());
        System.out.print('\n');
        System.out.print(Zwierze.size());
        System.out.print('\n');
        System.out.print(Zwierze.get(4));
        System.out.print('\n');
        System.out.print(Zwierze.remove(4));
        System.out.print('\n');
        System.out.print(Zwierze.size());
        Zwierze.add("Sokol");
        Zwierze.add(6,"Wieprz");
        Zwierze.clear();
        System.out.print('\n');
        System.out.print(Zwierze.pop());
        System.out.print('\n');
        System.out.print(Zwierze.size());
    }
}
