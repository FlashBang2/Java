package Starport;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Battlecruiser extends JLabel implements UnitInterface
{
    Image Battlecruiser;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Battlecruiser (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Battlecruiser=new ImageIcon("StarportUnitImages/Battlefield/Player1/Battlecruiser.jpg").getImage();
        else
            Battlecruiser=new ImageIcon("StarportUnitImages/Battlefield/Player2/Battlecruiser.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Battlecruiser,x,y,null);
    }
}
