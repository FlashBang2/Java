package UIMessages;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstTimeMessage extends JLabel implements ActionListener
{
    BufferedImage image;
    float alpha=0f;
    Timer timer=new Timer(20,this), timer2=new Timer(1000,this);
    boolean FirstTimerRunning,SecondTimerRunning;
    int seconds=0;

    public FirstTimeMessage ()
    {
        setBackground(Color.BLACK);
        FirstTimerRunning=true;
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        image=null;
        super.paintComponent(g);
        try
        {
            image= ImageIO.read(new File("Assets/UIICons/Goal.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Graphics2D g2d=(Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
        g2d.drawImage(image,0,0,null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (FirstTimerRunning)
        {
            alpha = alpha + 0.02f;
            if (alpha > 1)
            {
                alpha = 1;
                timer.stop();
                FirstTimerRunning=false;
                SecondTimerRunning=true;
                timer2.start();
            }
            repaint();
        }
        if (!FirstTimerRunning && SecondTimerRunning)
        {
            seconds++;
        }
        if (seconds==5 && SecondTimerRunning)
        {
            timer2.stop();
            SecondTimerRunning=false;
            timer.start();
        }
        if (!FirstTimerRunning && !SecondTimerRunning)
        {
            alpha = alpha - 0.02f;
            if (alpha<0)
            {
                alpha=0;
                setVisible(false);
                timer.stop();
            }
            repaint();
        }
    }
}
