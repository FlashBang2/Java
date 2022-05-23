package Options;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Lock extends JLabel
{
    public Lock ()
    {

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Image Lock = null;
        super.paintComponent(g);
        try
        {
            Lock= ImageIO.read(new File("Assets/Select/Lock.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(Lock,67,125,null);
    }
}
