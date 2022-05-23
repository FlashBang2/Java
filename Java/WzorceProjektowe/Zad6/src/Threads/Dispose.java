package Threads;

import javax.swing.*;

public class Dispose extends Thread
{
    JFrame DisposableWindow;

    public Dispose (JFrame disposableWindow)
    {
        DisposableWindow=disposableWindow;
    }

    public void run()
    {
        try
        {
            Thread.sleep(250);
            DisposableWindow.dispose();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
