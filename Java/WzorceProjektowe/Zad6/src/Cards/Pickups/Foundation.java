package Cards.Pickups;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class Foundation extends JPanel
{
    int    Value, UpperBound=5,LowerBound=1;
    Random random=new Random();
    JLabel DisplayValue=new JLabel();

    public Foundation ()
    {
        Value=random.nextInt(UpperBound)+LowerBound;
        setLayout(null);
        DisplayValue.setText(String.valueOf(Value));
        DisplayValue.setFont(new Font("Arial",Font.PLAIN,40));
        DisplayValue.setForeground(Color.WHITE);
        add(DisplayValue);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Image Card=null;
        super.paintComponent(g);
        try
        {
            Card=ImageIO.read(new File("Assets/Cards/Pickups/"+getName()+".png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(Card,0,0,null);
    }

    public int GetValue()
    {
        return Value;
    }

    public int GetUpperBound()
    {
        return UpperBound;
    }

    public void UpdateValue(int Additive)
    {
        Value+=Additive;
        DisplayValue.setText(String.valueOf(Value));
    }

    public void BoxSpecial(int Multiplier)
    {
        Value=Value*Multiplier;
        DisplayValue.setText(String.valueOf(Value));
    }
}
