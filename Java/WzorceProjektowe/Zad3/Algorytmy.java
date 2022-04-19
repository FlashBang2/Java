public abstract class Algorytmy
{
    Interface_Sorting interface_sorting;
    public Algorytmy (Interface_Sorting ls)
    {
        interface_sorting=ls;
    }
    public String sorting (int[] array)
    {
        return interface_sorting.sorting(array);
    }
}
