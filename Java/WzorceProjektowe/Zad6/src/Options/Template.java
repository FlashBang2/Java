package Options;

import javax.swing.*;
import java.awt.*;

public class Template extends JPanel
{
    Lock  lock;

    public Template (boolean Lock,int i)
    {
        setLayout(null);
        if (!Lock)
        {
            lock=new Lock(i);
            lock.setBounds(0,0,300,600);
            add(lock);
        }
        setSize(300,600);
        setBackground(Color.BLACK);
    }
}
