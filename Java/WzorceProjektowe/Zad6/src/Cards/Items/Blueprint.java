package Cards.Items;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Blueprint extends JButton
{
    JLabel Description=new JLabel();

    public Blueprint ()
    {

        setLayout(null);
        Description.setBounds(0,0,200,300);
        Description.setVisible(false);
        add(Description);
    }

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

    public void RevealDescription()
    {
        Description.setVisible(true);
    }

    public void HideDescription()
    {
        Description.setVisible(false);
    }
}
