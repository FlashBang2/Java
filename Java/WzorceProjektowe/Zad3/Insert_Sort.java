public class Insert_Sort implements Interface_Sorting
{
    public String sorting (int[] array)
    {
        String wypis="";
        int n = array.length;
        for (int i = 1; i < n; ++i)
        {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        for (int x:array)
        {
            wypis+=x+",";
        }
        return wypis;
    }
}
