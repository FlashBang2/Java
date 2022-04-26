package Barracks;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Ghost extends JLabel implements UnitInterface
{
    Image Ghost;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Ghost (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Ghost=new ImageIcon("BarracksUnitImages/Battlefield/Player1/Ghost.jpg").getImage();
        else
            Ghost=new ImageIcon("BarracksUnitImages/Battlefield/Player2/Ghost.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint (Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Ghost,x,y,null);
    }
}
