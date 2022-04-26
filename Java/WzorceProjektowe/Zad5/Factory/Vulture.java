package Factory;
import Main.UnitInterface;
import javax.swing.*;
import java.awt.*;
public class Vulture extends JLabel implements UnitInterface
{
    Image Vulture;
    final int MaxSpawnAreaWidth=600,MaxSpawnAreaHeight=1080,MaxSpawnPointWidth=550,MaxSpawnPointHeight=1030;
    int x=(int)Math.floor(Math.random()*(MaxSpawnPointWidth+1)),y=((int)Math.floor(Math.random()*(MaxSpawnPointHeight+1)));
    Vulture(JLabel SpawnArea)
    {
        if (SpawnArea.getName().equals("Player1AreaSpawn"))
            Vulture=new ImageIcon("FactoryUnitImages/Battlefield/Player1/Vulture.jpg").getImage();
        else
            Vulture=new ImageIcon("FactoryUnitImages/Battlefield/Player2/Vulture.jpg").getImage();
        setBounds(0,0,MaxSpawnAreaWidth,MaxSpawnAreaHeight);
        this.setVisible(true);
        SpawnArea.add(this);
    }
    public void paint(Graphics graphic)
    {
        super.paint(graphic);
        Graphics2D Icon=(Graphics2D) graphic;
        Icon.drawImage(Vulture,x,y,null);
    }
}
