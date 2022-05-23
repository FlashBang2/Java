package Windows;

import Handlers.MouseMenu;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame
{
    JButton             Start=new JButton(), Exit=new JButton();
    ArrayList<JButton>  Buttonlist=new ArrayList<>();
    JLabel              Title=new JLabel();
    MouseMenu           mouseMenu=new MouseMenu(this);

    public Menu()
    {
        super("The Triumph");
        setUndecorated(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        Start.setBounds(700,900,250,50);
        Exit.setBounds(975,900,250,50);
        Title.setBounds(550,0,800,600);
        Start.setName("Start");
        Exit.setName("Exit");
        Buttonlist.add(Start);
        Buttonlist.add(Exit);
        for(JButton button : Buttonlist)
        {
            button.setIcon(new ImageIcon("Assets/Menu/"+button.getName()+".png"));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setBackground(Color.BLACK);
            button.addMouseListener(mouseMenu);
            add(button);
        }
        Title.setIcon(new ImageIcon("Assets/Menu/TheTriumph.png"));
        add(Title);
        setVisible(true);
    }
}
