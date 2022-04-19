package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Title_Screen extends JPanel
{
    private BufferedImage title;
    public Title_Screen()
    {
        super();
        File screen =new File("TitleScreen.png");
        try
        {
            title=ImageIO.read(screen);

        }
            catch(IOException e)
        {
            System.out.print("Błąd odczytu obrazka");
        }

        Dimension wymiar=new Dimension(title.getWidth(),title.getHeight());
        setPreferredSize(wymiar);

    }
     @Override
    public void paintComponent(Graphics g)
     {
         Graphics2D obrazek_Menu= (Graphics2D)g;
         obrazek_Menu.drawImage(title,0,0,this);
     }


}
