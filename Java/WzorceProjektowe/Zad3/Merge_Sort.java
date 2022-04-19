public class Merge_Sort implements Interface_Sorting
{
    public String sorting (int[] array)
    {
        String wypis="";
        helper(array,0,array.length-1);
        for (int x:array)
        {
            wypis+=x+",";
        }
        return wypis;
    }
    public void helper (int[] array,int lowestindex,int bigestindex)
    {
        if (lowestindex < bigestindex) {
            // Find the middle point
            int m =lowestindex+ (bigestindex-lowestindex)/2;

            // Sort first and second halves
            helper(array,lowestindex, m);
            helper(array,m + 1, bigestindex);

            // Merge the sorted halves
            merge(array,lowestindex,m,bigestindex);
        }
    }
    void merge (int arr[],int lowestindex,int m,int bigestindex)
    {
        int n1 = m - lowestindex + 1;
        int n2 = bigestindex - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[lowestindex + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = lowestindex;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
