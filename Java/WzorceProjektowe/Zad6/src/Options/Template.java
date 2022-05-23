package Options;

import javax.swing.*;
import java.awt.*;

public class Template extends JPanel
{
    Lock  lock;

    public Template (boolean Lock)
    {
        setLayout(null);
        if (!Lock)
        {
            lock=new Lock();
            lock.setBounds(0,0,300,600);
            add(lock);
        }
        setSize(300,600);
        setBackground(Color.BLACK);
    }
}
