package Windows;
import Barracks.UnitCreation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowBarracks extends JFrame implements ActionListener
{
    JButton Marine=new JButton(),Firebat=new JButton(),Ghost=new JButton()
           ,Medic=new JButton(),Exit=new JButton();
    JLabel Title=new JLabel("Barracks"),SpawnArea;
    JFrame MainScreen;
    UnitCreation UnitCreation=new UnitCreation();
    final int UnitButtonWidth=64,UnitButtonHeight=80;
    public WindowBarracks(JButton Pressed,JFrame mainscreen,JLabel spawnarea)
    {
        super("Barracks");
        SpawnArea=spawnarea;
        MainScreen=mainscreen;
        setSize(192,200);
        setLayout(null);
        setLocationRelativeTo(Pressed);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        Marine.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Marine.jpg"));
        Firebat.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Firebat.jpg"));
        Ghost.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Ghost.jpg"));
        Medic.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Medic.jpg"));
        Exit.setIcon(new ImageIcon("Exit.jpg"));
        Title.setFont(new Font("Arial",Font.BOLD,35));
        Exit.setBounds(145,0,50,40);
        Title.setBounds(0,0,150,35);
        Marine.setBounds(0,40,UnitButtonWidth,UnitButtonHeight);
        Firebat.setBounds(64,40,UnitButtonWidth,UnitButtonHeight);
        Ghost.setBounds(128,40,UnitButtonWidth,UnitButtonHeight);
        Medic.setBounds(0,120,UnitButtonWidth,UnitButtonHeight);
        Marine.addActionListener(this);
        Firebat.addActionListener(this);
        Ghost.addActionListener(this);
        Medic.addActionListener(this);
        Exit.addActionListener(this);
        Marine.setName("Marine");
        Firebat.setName("Firebat");
        Medic.setName("Medic");
        Ghost.setName("Ghost");
        Exit.setName("Exit");
        add(Exit);
        add(Title);
        add(Marine);
        add(Firebat);
        add(Ghost);
        add(Medic);
        setVisible(true);
    }
    public void Swap (JLabel spawnarea,boolean Swapped)
    {
        SpawnArea=spawnarea;
        if (Swapped)
        {
            Marine.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player2/Marine.jpg"));
            Firebat.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player2/Firebat.jpg"));
            Ghost.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player2/Ghost.jpg"));
            Medic.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player2/Medic.jpg"));
        }
        else
        {
            Marine.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Marine.jpg"));
            Firebat.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Firebat.jpg"));
            Ghost.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Ghost.jpg"));
            Medic.setIcon(new ImageIcon("BarracksUnitImages/Interface/Player1/Medic.jpg"));
        }

    }
    public void actionPerformed(ActionEvent Event)
    {
        JButton Pressed=(JButton) Event.getSource();
        switch (Pressed.getName()) {
            case "Marine":
                UnitCreation.CreateUnit("Marine", SpawnArea);
                MainScreen.repaint();
                break;
            case "Firebat":
                UnitCreation.CreateUnit("Firebat",SpawnArea);
                MainScreen.repaint();
                break;
            case "Ghost":
                UnitCreation.CreateUnit("Ghost",SpawnArea);
                MainScreen.repaint();
                break;
            case "Medic":
                UnitCreation.CreateUnit("Medic",SpawnArea);
                MainScreen.repaint();
                break;
            case "Exit":
                dispose();
                break;
        }
    }
}
