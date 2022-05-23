package Heroes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Base extends JPanel
{
    int     currenthealth,          maxhealth,  armor,
            gold,                   moveTaken=0,midasPouches=0,
            Lootboxes=1,            Shield=0;
    JLabel  Health=new JLabel(),    Armor=new JLabel();

    public Base ()
    {
        setLayout(null);
        Health.setBounds(133,225,64,64);
        Armor.setBounds(158,158,64,64);
        Health.setForeground(Color.WHITE);
        Armor.setForeground(Color.WHITE);
        Health.setFont(new Font("Arial",Font.PLAIN,20));
        Armor.setFont(new Font("Arial",Font.PLAIN,20));
        add(Health);
        add(Armor);
    }

    public void SetHealth(int CurrentHP,int MaxHP)
    {
        Health.setText(CurrentHP+" / "+MaxHP);
    }

    public void SetArmor(int Number)
    {
        Armor.setText(String.valueOf(Number));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Image Card=null;
        super.paintComponent(g);
        try
        {
            Card=ImageIO.read(new File("Assets/Cards/HeroClasses/"+getName()+".png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(Card,0,0,null);
    }

    public int GetGold()
    {
        return gold;
    }

    public int GetArmor()
    {
        return armor;
    }

    public int GetCurrentHealth()
    {
        return currenthealth;
    }

    public int GetMaxHealth()
    {
        return maxhealth;
    }

    public int GetTakenMoves()
    {
        return moveTaken;
    }

    public int GetMidasPouches()
    {
        return midasPouches;
    }

    public int GetLootBoxes()
    {
        return Lootboxes;
    }

    public int GetShield ()
    {
        return Shield;
    }

    public void ChangeShield ()
    {
        Shield++;
    }

    public void ChangeLootBoxes ()
    {
        Lootboxes++;
    }

    public void ChangeMidasPouches()
    {
        midasPouches ++;
    }

    public void ChangeArmor(int Armor)
    {
        armor=Armor;
        SetArmor(armor);
    }

    public void ChangeGold(int Gold)
    {
        gold=Gold;
    }

    public void ChangeCurrentHealth(int Health)
    {
        currenthealth=Health;
        SetHealth(currenthealth,maxhealth);
    }

    public void ChangeMaxHealth(int MaxHealth)
    {
        maxhealth=MaxHealth;
        SetHealth(currenthealth,maxhealth);
    }

    public void ChangeTakenMoves(int takenMoves)
    {
        moveTaken=takenMoves;
    }
}
