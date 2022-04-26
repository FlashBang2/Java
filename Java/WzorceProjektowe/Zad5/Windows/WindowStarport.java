package Windows;
import Starport.UnitCreation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowStarport extends JFrame implements ActionListener
{
    JButton Wraith=new JButton(),Dropship=new JButton(),ScienceVessel=new JButton()
           ,Valkyrie=new JButton(),Battlecruiser=new JButton(),Exit=new JButton();
    JLabel Title=new JLabel("Starport"),SpawnArea;
    JFrame MainScreen;
    Starport.UnitCreation UnitCreation=new UnitCreation();
    final int UnitButtonWidth=64,UnitButtonHeight=80;
    public WindowStarport (JButton Pressed,JFrame mainscreen,JLabel spawnarea)
    {
        super("Starport");
        MainScreen=mainscreen;
        SpawnArea=spawnarea;
        setSize(192,200);
        setLayout(null);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(Pressed);
        Wraith.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Wraith.jpg"));
        Dropship.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Dropship.jpg"));
        ScienceVessel.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/ScienceVessel.jpg"));
        Valkyrie.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Valkyrie.jpg"));
        Battlecruiser.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Battlecruiser.jpg"));
        Exit.setIcon(new ImageIcon("Exit.jpg"));
        Title.setFont(new Font("Arial",Font.BOLD,35));
        Wraith.setBounds(0,40,UnitButtonWidth,UnitButtonHeight);
        Dropship.setBounds(64,40,UnitButtonWidth,UnitButtonHeight);
        ScienceVessel.setBounds(128,40,UnitButtonWidth,UnitButtonHeight);
        Valkyrie.setBounds(0,120,UnitButtonWidth,UnitButtonHeight);
        Battlecruiser.setBounds(64,120,UnitButtonWidth,UnitButtonHeight);
        Title.setBounds(0,0,150,35);
        Exit.setBounds(145,0,50,40);
        Wraith.setName("Wraith");
        Dropship.setName("Dropship");
        Valkyrie.setName("Valkyrie");
        Battlecruiser.setName("Battlecruiser");
        ScienceVessel.setName("ScienceVessel");
        Exit.setName("Exit");
        Exit.addActionListener(this);
        ScienceVessel.addActionListener(this);
        Battlecruiser.addActionListener(this);
        Dropship.addActionListener(this);
        Wraith.addActionListener(this);
        Valkyrie.addActionListener(this);
        add(Title);
        add(Exit);
        add(Wraith);
        add(Dropship);
        add(ScienceVessel);
        add(Valkyrie);
        add(Battlecruiser);
        setVisible(true);
    }
    public void Swap(JLabel spawnarea,boolean Swapped)
    {
        SpawnArea=spawnarea;
        if (Swapped)
        {
            Wraith.setIcon(new ImageIcon("StarportUnitImages/Interface/Player2/Wraith.jpg"));
            Dropship.setIcon(new ImageIcon("StarportUnitImages/Interface/Player2/Dropship.jpg"));
            ScienceVessel.setIcon(new ImageIcon("StarportUnitImages/Interface/Player2/ScienceVessel.jpg"));
            Valkyrie.setIcon(new ImageIcon("StarportUnitImages/Interface/Player2/Valkyrie.jpg"));
            Battlecruiser.setIcon(new ImageIcon("StarportUnitImages/Interface/Player2/Battlecruiser.jpg"));
        }
        else
        {
            Wraith.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Wraith.jpg"));
            Dropship.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Dropship.jpg"));
            ScienceVessel.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/ScienceVessel.jpg"));
            Valkyrie.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Valkyrie.jpg"));
            Battlecruiser.setIcon(new ImageIcon("StarportUnitImages/Interface/Player1/Battlecruiser.jpg"));
        }
    }
    public void actionPerformed(ActionEvent Event)
    {
        JButton Pressed=(JButton) Event.getSource();
        switch (Pressed.getName())
        {
            case "Wraith":
                UnitCreation.CreateUnit("Wraith",SpawnArea);
                MainScreen.repaint();
                break;
            case "Dropship":
                UnitCreation.CreateUnit("Dropship",SpawnArea);
                MainScreen.repaint();
                break;
            case "ScienceVessel":
                UnitCreation.CreateUnit("ScienceVessel",SpawnArea);
                MainScreen.repaint();
                break;
            case "Valkyrie":
                UnitCreation.CreateUnit("Valkyrie",SpawnArea);
                MainScreen.repaint();
                break;
            case "Battlecruiser":
                UnitCreation.CreateUnit("Battlecruiser",SpawnArea);
                MainScreen.repaint();
                break;
            case "Exit":
                dispose();
                break;
        }
    }
}
