package Cards.Pickups;

import javax.swing.*;
import java.util.Random;

public class Enemy extends Foundation
{
    JLabel             LeftAttack=new JLabel(),ForwardAttack=new JLabel(),RightAttack=new JLabel();
    Random             random=new Random();
    final int          LeftSide=650,           RightSide=1100,            Middle=875;
    boolean            HasLeftAttack=false,    HasRightAttack=false,      HasForwardAttack=false;
    boolean[]          Attacks=new boolean[3];

    public Enemy ()
    {
        setName("Enemy");
        DisplayValue.setBounds(176,228,250,50);
        LeftAttack.setIcon(new ImageIcon("Assets/Cards/Arrows/LeftAttack.png"));
        LeftAttack.setBounds(1,234,64,64);
        RightAttack.setIcon(new ImageIcon("Assets/Cards/Arrows/RightAttack.png"));
        RightAttack.setBounds(135,234,64,64);
        ForwardAttack.setIcon(new ImageIcon("Assets/Cards/Arrows/ForwardAttack.png"));
        ForwardAttack.setBounds(68,234,64,64);
    }

    public void SetAttacks (int EnemyX)
    {
        switch (EnemyX)
        {
            case LeftSide:
                switch (random.nextInt(3)+1)
                {
                    case 1:
                        add(ForwardAttack);
                        HasForwardAttack=true;
                        break;
                    case 2:
                        add(ForwardAttack);
                        add(RightAttack);
                        HasForwardAttack=true;
                        HasRightAttack=true;
                        break;
                    case 3:
                        add(RightAttack);
                        HasRightAttack=true;
                        break;
                }
                break;
            case Middle:
                switch(random.nextInt(7)+1)
                {
                    case 1:
                        add(RightAttack);
                        add(LeftAttack);
                        add(ForwardAttack);
                        HasRightAttack=true;
                        HasForwardAttack=true;
                        HasLeftAttack=true;
                        break;
                    case 2:
                        add(RightAttack);
                        HasRightAttack=true;
                        break;
                    case 3:
                        add(ForwardAttack);
                        HasForwardAttack=true;
                        break;
                    case 4:
                        add(LeftAttack);
                        HasLeftAttack=true;
                        break;
                    case 5:
                        add(RightAttack);
                        add(LeftAttack);
                        HasRightAttack=true;
                        HasLeftAttack=true;
                        break;
                    case 6:
                        add(ForwardAttack);
                        add(RightAttack);
                        HasForwardAttack=true;
                        HasRightAttack=true;
                        break;
                    case 7:
                        add(ForwardAttack);
                        add(LeftAttack);
                        HasForwardAttack=true;
                        HasLeftAttack=true;
                        break;
                }
                break;
            case RightSide:
                switch (random.nextInt(3)+1)
                {
                    case 1:
                        add(ForwardAttack);
                        HasForwardAttack=true;
                        break;
                    case 2:
                        add(LeftAttack);
                        HasLeftAttack=true;
                        break;
                    case 3:
                        add(ForwardAttack);
                        add(LeftAttack);
                        HasForwardAttack=true;
                        HasLeftAttack=true;
                        break;
                }
                break;

        }
    }

    public void Boss1 ()
    {
        Value=16;
        DisplayValue.setBounds(156,228,250,50);
        DisplayValue.setText(String.valueOf(Value));
    }

    public void Boss2 ()
    {
        Value=25;
        DisplayValue.setText(String.valueOf(Value));
        DisplayValue.setBounds(156,228,250,50);
    }

    public void Boss3 ()
    {
        Value=37;
        DisplayValue.setText(String.valueOf(Value));
        DisplayValue.setBounds(156,228,250,50);
    }

    public void Boss4 ()
    {
        Value=50;
        DisplayValue.setText(String.valueOf(Value));
        DisplayValue.setBounds(156,228,250,50);
    }

    public boolean[] GetAttacks ()
    {
        Attacks[0]=HasLeftAttack;
        Attacks[1]=HasForwardAttack;
        Attacks[2]=HasRightAttack;
        return Attacks;
    }

    public boolean IsBetween (int Value, int LowerBound, int UpperBound)
    {
        return LowerBound<=Value && Value<=UpperBound;
    }

    @Override
    public void UpdateValue(int Additive)
    {
        super.UpdateValue(Additive);
        if (Value>=10)
            DisplayValue.setBounds(156,228,250,50);
    }

    public Foundation PlaceLoot (Foundation enemy)
    {
       int value=random.nextInt(100)+1;
       if (IsBetween(value,1,40))
       {
            Foundation Gold=new Gold();
            Gold.setBounds(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
            return Gold;
       }
       else if (IsBetween(value,41,70))
       {
           Foundation Health=new Health();
           Health.setBounds(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
           return Health;
       }
       else
       {
           Foundation Armor=new Armor();
           Armor.setBounds(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
           return Armor;
       }
    }
}
