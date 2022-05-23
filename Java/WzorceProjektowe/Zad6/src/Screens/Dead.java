package Screens;

import Handlers.MouseScreens;
import Windows.Game;
import javax.swing.*;
import java.awt.*;

public class Dead extends JPanel
{
    JLabel Announce=new JLabel();
    JButton Respawn=new JButton(),Exit=new JButton();
    Game myFrame;

    public Dead (Game MyFrame)
    {
        myFrame=MyFrame;
        MouseScreens mouseScreens=new MouseScreens(myFrame);
        setSize(650,500);
        setLayout(null);
        setBackground(Color.BLACK);
        Announce.setBounds(185,100,250,50);
        Announce.setIcon(new ImageIcon("Assets/Screens/Message.png"));
        Respawn.setBounds(200,200,250,50);
        Exit.setBounds(200,275,250,50);
        Respawn.setBorder(BorderFactory.createEmptyBorder());
        Exit.setBorder(BorderFactory.createEmptyBorder());
        Respawn.setIcon(new ImageIcon("Assets/Screens/Respawn.png"));
        Exit.setIcon(new ImageIcon("Assets/Screens/Menu.png"));
        Respawn.addMouseListener(mouseScreens);
        Exit.addMouseListener(mouseScreens);
        Respawn.setName("Respawn");
        Exit.setName("Menu");
        Respawn.setBackground(Color.BLACK);
        Exit.setBackground(Color.BLACK);
        add(Announce);
        add(Respawn);
        add(Exit);
    }

}
