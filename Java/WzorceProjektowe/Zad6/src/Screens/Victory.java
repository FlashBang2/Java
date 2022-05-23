package Screens;

import Handlers.MouseScreens;
import Windows.Game;
import javax.swing.*;
import java.awt.*;

public class Victory extends JPanel
{
    JLabel Message=new JLabel();
    JButton Menu=new JButton();
    Game myFrame;

    public Victory (Game MyFrame)
    {
        myFrame=MyFrame;
        MouseScreens mouseScreens=new MouseScreens(myFrame);
        setSize(650,500);
        setBackground(Color.BLACK);
        setLayout(null);
        Message.setBounds(195,150,250,50);
        Message.setIcon(new ImageIcon("Assets/Screens/Victory.png"));
        Menu.setBounds(200,275,250,50);
        Menu.setIcon(new ImageIcon("Assets/Screens/Menu.png"));
        Menu.setName("Menu");
        Menu.addMouseListener(mouseScreens);
        Menu.setBorder(BorderFactory.createEmptyBorder());
        Menu.setBackground(Color.BLACK);
        add(Menu);
        add(Message);
    }
}
