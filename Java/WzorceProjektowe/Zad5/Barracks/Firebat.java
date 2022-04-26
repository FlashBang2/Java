package Barracks;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Firebat extends JLabel implements UnitInterface
{
    Image Firebat;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Firebat(JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Firebat=new ImageIcon("BarracksUnitImages/Battlefield/Player1/Firebat.jpg").getImage();
        else
            Firebat=new ImageIcon("BarracksUnitImages/Battlefield/Player2/Firebat.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint   (Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Firebat,x,y,null);
    }
}
