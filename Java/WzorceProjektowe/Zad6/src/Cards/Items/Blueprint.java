package Cards.Items;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Blueprint extends JButton
{
    @Override
    protected void paintComponent(Graphics g)
    {
        Image Card=null;
        super.paintComponent(g);
        try
        {
            Card= ImageIO.read(new File("Assets/Cards/Items/"+getName()+".png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(Card,67,125,null);
    }
}
