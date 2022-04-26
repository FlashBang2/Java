package Factory;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class SiegeTank extends JLabel implements UnitInterface
{
    Image SiegeTank;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    SiegeTank (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            SiegeTank=new ImageIcon("FactoryUnitImages/Battlefield/Player1/SiegeTank.jpg").getImage();
        else
            SiegeTank=new ImageIcon("FactoryUnitImages/Battlefield/Player2/SiegeTank.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(SiegeTank,x,y,null);
    }
}
