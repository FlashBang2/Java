package Windows;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowMenu extends JFrame implements ActionListener
{
    JButton Barracks=new JButton(),Factory=new JButton(),Starport=new JButton()
           ,Exit=new JButton("Exit"),Swap=new JButton("Change Player");
    JLabel Player1AreaSpawn=new JLabel(),Player2AreaSpawn=new JLabel();
    boolean Swapped=false;
    WindowBarracks WindowBarracks;
    WindowFactory WindowFactory;
    WindowStarport WindowStarport;
    final int MenuButtonWidth=200,MenuButtonHeight=25,SpawnAreaWidth=600,SpawnAreaHeight=1080;
    public WindowMenu ()
    {
        super("Starcraft");
        setUndecorated(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(new JLabel(new ImageIcon("Background.jpg")));
        Barracks.setIcon(new ImageIcon("Buildings/Player1/Barracks.jpg"));
        Factory.setIcon(new ImageIcon("Buildings/Player1/Factory.jpg"));
        Starport.setIcon(new ImageIcon("Buildings/Player1/Starport.jpg"));
        Barracks.setBorder(BorderFactory.createEmptyBorder());
        Factory.setBorder(BorderFactory.createEmptyBorder());
        Starport.setBorder(BorderFactory.createEmptyBorder());
        Barracks.setBounds(910,150,131,112);
        Factory.setBounds(916,350,119,108);
        Starport.setBounds(921,550,110,111);
        Exit.setBounds(865,800,MenuButtonWidth,MenuButtonHeight);
        Swap.setBounds(865,750,MenuButtonWidth,MenuButtonHeight);
        Player1AreaSpawn.setBounds(0,0,SpawnAreaWidth,SpawnAreaHeight);
        Player2AreaSpawn.setBounds(1200,0,SpawnAreaWidth,SpawnAreaHeight);
        Player1AreaSpawn.setName("Player1AreaSpawn");
        Player2AreaSpawn.setName("Player2AreaSpawn");
        Barracks.setName("Barracks");
        Factory.setName("Factory");
        Starport.setName("Starport");
        Exit.setName("Exit");
        Swap.setName("Swap");
        Barracks.addActionListener(this);
        Factory.addActionListener(this);
        Starport.addActionListener(this);
        Exit.addActionListener(this);
        Swap.addActionListener(this);
        add(Player1AreaSpawn);
        add(Player2AreaSpawn);
        add(Barracks);
        add(Factory);
        add(Starport);
        add(Exit);
        add(Swap);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent Event)
    {
        JButton Pressed=(JButton) Event.getSource();
        switch (Pressed.getName())
        {
            case "Barracks":
                if (Swapped)
                {
                    WindowBarracks=new WindowBarracks(Pressed,this,Player2AreaSpawn);
                    WindowBarracks.Swap(Player2AreaSpawn,Swapped);
                }
                else
                {
                    WindowBarracks=new WindowBarracks(Pressed,this,Player1AreaSpawn);
                }
                break;
            case "Factory":
                if (Swapped)
                {
                    WindowFactory = new WindowFactory(Pressed,this,Player2AreaSpawn);
                    WindowFactory.Swap(Player2AreaSpawn,Swapped);
                }
                else
                    WindowFactory = new WindowFactory(Pressed,this,Player1AreaSpawn);
                break;
            case "Starport":
                if (Swapped)
                {
                    WindowStarport=new WindowStarport(Pressed,this,Player2AreaSpawn);
                    WindowStarport.Swap(Player2AreaSpawn,Swapped);
                }
                else
                    WindowStarport=new WindowStarport(Pressed,this,Player1AreaSpawn);
                break;
            case "Swap":
                if (Swapped)
                {
                    Swapped=false;
                    if (WindowBarracks!=null)
                        WindowBarracks.Swap(Player1AreaSpawn,Swapped);
                    if (WindowFactory!=null)
                        WindowFactory.Swap(Player1AreaSpawn,Swapped);
                    if (WindowStarport!=null)
                        WindowStarport.Swap(Player1AreaSpawn,Swapped);
                    Barracks.setIcon(new ImageIcon("Buildings/Player1/Barracks.jpg"));
                    Factory.setIcon(new ImageIcon("Buildings/Player1/Factory.jpg"));
                    Starport.setIcon(new ImageIcon("Buildings/Player1/Starport.jpg"));
                }
                else
                {
                    Swapped=true;
                    if (WindowBarracks!=null)
                        WindowBarracks.Swap(Player2AreaSpawn,Swapped);
                    if (WindowFactory!=null)
                        WindowFactory.Swap(Player2AreaSpawn,Swapped);
                    if (WindowStarport!=null)
                        WindowStarport.Swap(Player2AreaSpawn,Swapped);
                    Barracks.setIcon(new ImageIcon("Buildings/Player2/Barracks.jpg"));
                    Factory.setIcon(new ImageIcon("Buildings/Player2/Factory.jpg"));
                    Starport.setIcon(new ImageIcon("Buildings/Player2/Starport.jpg"));
                }
                break;
            case "Exit":
                dispose();
                System.exit(0);
                break;
        }
    }
}
