package Options;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Lock extends JLabel
{
    JLabel UnlockRequirement=new JLabel();

    public Lock (int count)
    {
        switch (count)
        {
            case 1:
                UnlockRequirement.setText("To Unlock DarkKnight win Game as Warrior");
                UnlockRequirement.setBounds(0,-50,300,600);
                break;
            case 2:
                UnlockRequirement.setText("To Unlock Medusa win Game as DarkKnight");
                UnlockRequirement.setBounds(0,-50,300,600);
                break;
            case 3:
                UnlockRequirement.setText("To Unlock Mage win Game as Medusa");
                UnlockRequirement.setBounds(15,-50,300,600);
                break;
        }
        UnlockRequirement.setFont(new Font("Arial",Font.PLAIN,15));
        UnlockRequirement.setForeground(Color.WHITE);
        add(UnlockRequirement);
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
