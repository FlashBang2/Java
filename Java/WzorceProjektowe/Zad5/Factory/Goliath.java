package Factory;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Goliath extends JLabel implements UnitInterface
{
    Image Goliath;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Goliath (JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Goliath=new ImageIcon("FactoryUnitImages/Battlefield/Player1/Goliath.jpg").getImage();
        else
            Goliath=new ImageIcon("FactoryUnitImages/Battlefield/Player2/Goliath.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Goliath,x,y,null);
    }
}
