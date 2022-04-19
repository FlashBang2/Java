import java.util.logging.Level;
import java.util.logging.Logger;
public class CentralClock extends Thread implements Observer
{
    private volatile boolean Running = true;
    private volatile int ElapsedSeconds=0;
    Display[] DisplayArray;
    public void Transfer (Display[] displayArray)
    {
        DisplayArray=displayArray;
    }
    public void ResumeClock()
    {
        Running=true;
    }
    public void StopClock ()
    {
        Running=false;
    }
    public void run ()
    {
        while (Running)
        {
            try
            {
                ElapsedSeconds=ElapsedSeconds+5;
                if (ElapsedSeconds%60==0 && ElapsedSeconds!=0)
                {
                    Update(DisplayArray);
                }
                Thread.sleep(5000);
            }
            catch (InterruptedException Exception)
            {
                Logger.getLogger(CentralClock.class.getName()).log(Level.SEVERE, null, Exception);
            }
        }
    }
    public void Update(Display[] DisplayArray)
    {
        for (Display item: DisplayArray)
        {
            if (item!=null)
            {
                item.Change();
            }
        }
    }
}
