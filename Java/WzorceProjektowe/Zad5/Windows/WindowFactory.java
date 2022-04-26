package Windows;
import Factory.UnitCreation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowFactory extends JFrame implements ActionListener
{
    JButton Vulture=new JButton(),SiegeTank=new JButton(),Goliath=new JButton()
           ,Exit=new JButton();
    JLabel Title=new JLabel("Factory"),SpawnArea;
    JFrame MainScreen;
    UnitCreation UnitCreation=new UnitCreation();
    final int UnitButtonWidth=64,UnitButtonHeight=80;
    public WindowFactory(JButton Pressed,JFrame mainscreen, JLabel spawnarea)
    {
        super("Factory");
        MainScreen=mainscreen;
        SpawnArea=spawnarea;
        setSize(192,200);
        setLayout(null);
        setLocationRelativeTo(Pressed);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        Vulture.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/Vulture.jpg"));
        SiegeTank.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/SiegeTank.jpg"));
        Goliath.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/Goliath.jpg"));
        Exit.setIcon(new ImageIcon("Exit.jpg"));
        Title.setFont(new Font("Arial",Font.BOLD,35));
        Vulture.setBounds(0,40,UnitButtonWidth,UnitButtonHeight);
        SiegeTank.setBounds(64,40,UnitButtonWidth,UnitButtonHeight);
        Goliath.setBounds(128,40,UnitButtonWidth,UnitButtonHeight);
        Exit.setBounds(145,0,50,40);
        Title.setBounds(0,0,150,35);
        Exit.setName("Exit");
        Vulture.setName("Vulture");
        Goliath.setName("Goliath");
        SiegeTank.setName("SiegeTank");
        Vulture.addActionListener(this);
        Goliath.addActionListener(this);
        SiegeTank.addActionListener(this);
        Exit.addActionListener(this);
        add(Title);
        add(Vulture);
        add(SiegeTank);
        add(Goliath);
        add(Exit);
        setVisible(true);
    }
    public void Swap(JLabel spawnarea,boolean Swapped)
    {
        SpawnArea=spawnarea;
        if (Swapped)
        {
            Vulture.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player2/Vulture.jpg"));
            SiegeTank.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player2/SiegeTank.jpg"));
            Goliath.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player2/Goliath.jpg"));
        }
        else
        {
            Vulture.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/Vulture.jpg"));
            SiegeTank.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/SiegeTank.jpg"));
            Goliath.setIcon(new ImageIcon("FactoryUnitImages/Interface/Player1/Goliath.jpg"));
        }
    }
    public void actionPerformed(ActionEvent Event)
    {
        JButton Pressed=(JButton) Event.getSource();
        switch (Pressed.getName())
        {
            case "Vulture":
                UnitCreation.CreateUnit("Vulture",SpawnArea);
                MainScreen.repaint();
                break;
            case "SiegeTank":
                UnitCreation.CreateUnit("SiegeTank",SpawnArea);
                MainScreen.repaint();
                break;
            case "Goliath":
                UnitCreation.CreateUnit("Goliath",SpawnArea);
                MainScreen.repaint();
                break;
            case "Exit":
                dispose();
                break;
        }
    }
}
