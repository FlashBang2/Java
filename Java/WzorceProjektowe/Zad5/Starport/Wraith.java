package Starport;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Wraith extends JLabel implements UnitInterface
{
    Image Wraith;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Wraith (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Wraith=new ImageIcon("StarportUnitImages/Battlefield/Player1/Wraith.jpg").getImage();
        else
            Wraith=new ImageIcon("StarportUnitImages/Battlefield/Player2/Wraith.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Wraith,x,y,null);
    }
}

