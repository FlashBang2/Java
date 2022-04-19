public class Bubble_Sort implements Interface_Sorting
{
    public String sorting (int[] array)
    {
        int n = array.length;
        String wypis="";
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        for (int x:array)
        {
            wypis+=x+",";
        }
        return wypis;
    }
}
