public class MyCustomList<T> implements IMyList<T>
{
    T[] array=(T[]) new Object[100];
    T ostatni_element;
    boolean empty_array;
    public void add (T element)
    {
        for (int lastindex=array.length-1;lastindex>=0;lastindex--)
        {
            if (array[lastindex]!=null)
            {
                empty_array=false;
                array[lastindex+1]=element;
                break;
            }
            else
            {
                empty_array=true;
            }
        }
        if (empty_array)
        {
            array[0]=element;
        }
    }
    public void add(int index,T element)
    {
        array[index]=element;
    }
    public void clear ()
    {
       array=(T[]) new Object[100];
    }
    public T pop ()
    {
        ostatni_element=null;
        for (int lastindex=array.length-1;lastindex>=0;lastindex--)
        {
            if (array[lastindex]!=null)
            {
                ostatni_element=array[lastindex];
                array[lastindex]=null;
                break;
            }

        }
        return ostatni_element;
    }
    public T get (int index)
    {
        return array[index];
    }
    public int size ()
    {
        int size=0;
        for (int lastindex=array.length-1;lastindex>=0;lastindex--)
        {
            if (array[lastindex]!=null)
            {
               size=lastindex+1;
               break;
            }
        }
        return size;
    }
    public T remove (int index)
    {
        ostatni_element=array[index];
        array[index]=null;
        return ostatni_element;
    }
}
