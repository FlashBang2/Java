import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WindowMenu extends JFrame implements ActionListener
{
    JLabel Background,CentralStatusDisplay;
    Display KitchenDisplay,RoomDisplay,GardenDisplay;
    JButton Kitchen,Room,Garden,CentralClock,Exit;
    Display[] DisplayArray;
    CentralClock centralClock=new CentralClock();
    boolean DisplayedKitchen=false,DisplayedRoom=false,DisplayedGarden=false,Startup=false,CentralClockStopped=true;
    final int DisplaySize=3;
    WindowMenu()
    {
        super("Clocks");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        DisplayArray=new Display[DisplaySize];
        Background=new JLabel();
        KitchenDisplay=new Display();
        RoomDisplay=new Display();
        GardenDisplay=new Display();
        CentralStatusDisplay=new JLabel();
        Kitchen=new JButton();
        Room=new JButton();
        Garden=new JButton();
        Exit=new JButton("Exit");
        CentralClock=new JButton("Run/Stop");
        Background.setIcon(new ImageIcon("CentralClockBackgroundImage.jpg"));
        Kitchen.setIcon(new ImageIcon("Kitchen.jpg"));
        Room.setIcon(new ImageIcon("Room.jpg"));
        Garden.setIcon(new ImageIcon("Garden.jpg"));
        KitchenDisplay.setFont(new Font("Arial",Font.BOLD,60));
        GardenDisplay.setFont(new Font("Arial",Font.BOLD,60));
        RoomDisplay.setFont(new Font("Arial",Font.BOLD,60));
        CentralStatusDisplay.setFont(new Font("Arial",Font.BOLD,60));
        Exit.setFont(new Font("Arial",Font.BOLD,20));
        CentralClock.setFont(new Font("Arial",Font.BOLD,20));
        CentralStatusDisplay.setBounds(800,100,500,100);
        Background.setBounds(0,0,1920,1080);
        Kitchen.setBounds(0,360,640,360);
        Garden.setBounds(1280,360,640,360);
        Room.setBounds(640,360,640,360);
        Exit.setBounds(860,940,250,25);
        CentralClock.setBounds(860,890,250,25);
        Kitchen.addActionListener(this);
        Garden.addActionListener(this);
        Room.addActionListener(this);
        Exit.addActionListener(this);
        CentralClock.addActionListener(this);
        Kitchen.setName("Kitchen");
        Garden.setName("Garden");
        Room.setName("Room");
        Exit.setName("Exit");
        CentralClock.setName("CentralClock");
        Kitchen.setLayout(null);
        Garden.setLayout(null);
        Room.setLayout(null);
        KitchenDisplay.setBounds(275,25,300,100);
        GardenDisplay.setBounds(275,25,300,100);
        RoomDisplay.setBounds(275,25,300,100);
        KitchenDisplay.setVisible(false);
        GardenDisplay.setVisible(false);
        RoomDisplay.setVisible(false);
        Kitchen.add(KitchenDisplay);
        Garden.add(GardenDisplay);
        Room.add(RoomDisplay);
        add(Kitchen);
        add(Room);
        add(Garden);
        add(Exit);
        add(CentralClock);
        add(CentralStatusDisplay);
        add(Background);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent Event)
    {
        JButton Clicked=(JButton) Event.getSource();
        switch (Clicked.getName())
        {
            case "Kitchen":
                if (DisplayedKitchen)
                {
                    DisplayArray[0]=null;
                    centralClock.Transfer(DisplayArray);
                    DisplayedKitchen=false;
                    KitchenDisplay.setVisible(false);
                }
                else
                {
                    DisplayArray[0]=KitchenDisplay;
                    centralClock.Transfer(DisplayArray);
                    DisplayedKitchen=true;
                    KitchenDisplay.setVisible(true);
                }
                break;
            case "Room":
                if (DisplayedRoom)
                {
                    DisplayArray[1]=null;
                    centralClock.Transfer(DisplayArray);
                    DisplayedRoom=false;
                    RoomDisplay.setVisible(false);
                }
                else
                {
                    DisplayArray[1]=RoomDisplay;
                    centralClock.Transfer(DisplayArray);
                    DisplayedRoom=true;
                    RoomDisplay.setVisible(true);
                }
                break;
            case "Garden":
                if (DisplayedGarden)
                {
                    DisplayArray[2]=null;
                    centralClock.Transfer(DisplayArray);
                    DisplayedGarden=false;
                    GardenDisplay.setVisible(false);
                }
                else
                {
                    DisplayArray[2]=GardenDisplay;
                    centralClock.Transfer(DisplayArray);
                    DisplayedGarden=true;
                    GardenDisplay.setVisible(true);
                }
                break;
            case "CentralClock":
                if (!Startup)
                    {
                        Startup=true;
                        centralClock.start();
                    }
                if (Startup && CentralClockStopped)
                    {
                        CentralClockStopped=false;
                        CentralStatusDisplay.setText("Clock is Ticking");
                        centralClock.ResumeClock();
                    }
                else
                    {
                        CentralClockStopped=true;
                        CentralStatusDisplay.setText("Clock is Stopped");
                        centralClock.StopClock();
                    }

                break;
            case "Exit":
                dispose();
                System.exit(0);
                break;
        }
    }
}
