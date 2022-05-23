package UIMessages;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NotEnoughGold extends JPanel implements ActionListener
{
    BufferedImage buffimage;
    float alpha=1f;
    Timer timer=new Timer(20,this);

    public NotEnoughGold()
    {
        setBackground(Color.BLACK);
        timer.start();
    }

    public void paint (Graphics g)
    {
        buffimage=null;
        try {
            buffimage = ImageIO.read(new File("Assets/Screens/Notification.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
        g2d.drawImage(buffimage,0,0,null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        alpha=alpha-0.02f;
        if (alpha<0)
        {
            alpha=0;
            setVisible(false);
            timer.stop();
        }
        repaint();
    }
}
