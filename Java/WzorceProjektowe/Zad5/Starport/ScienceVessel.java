package Starport;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class ScienceVessel extends JLabel implements UnitInterface
{
    Image ScienceVessel;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    ScienceVessel (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            ScienceVessel=new ImageIcon("StarportUnitImages/Battlefield/Player1/ScienceVessel.jpg").getImage();
        else
            ScienceVessel=new ImageIcon("StarportUnitImages/Battlefield/Player2/ScienceVessel.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(ScienceVessel,x,y,null);
    }
}
