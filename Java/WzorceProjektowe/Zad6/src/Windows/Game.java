package Windows;

import Cards.Pickups.*;
import Handlers.*;
import Heroes.*;
import Heroes.Decorators.Buy;
import Heroes.Decorators.HeroDecorator;
import Heroes.Decorators.LifePotion;
import Screens.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JFrame
{
    Base                    Hero;
    Foundation Card;
    ArrayList<Foundation>   cards=new ArrayList<>();
    int                     i=0,                                        HeroX=875,                               HeroY=675,
                            HeroIndex,                                  ZoneIndex=1,                             ScalingEnemy=0,
                            ScalingItems=0,                             Value=0;
    final int               CardWidth=200,                              CardHeight=300,                          LeftSide=650,
                            RightSide=1100,                             Middle=875;
    boolean                 HasWorked=false,                            AfterBossSquare=false;
    KeyboardGame            keyboard=new KeyboardGame(this);
    JLabel                  Move=new JLabel(),                          MoveDescription=new JLabel("MOVE"), Menu=new JLabel(),
                            MenuDescription=new JLabel("MENU"),    Gold=new JLabel(),                       Items=new JLabel("ITEMS:"),
                            GoldValue=new JLabel(),                     Grey=new JLabel();
    JLayeredPane            Screen=new JLayeredPane();
    Random                  random=new Random();
    Items                   items;
    HeroDecorator           decorator;

    public void ChosenHero(int index)
    {
        switch (index)
        {
            case 0:
                Hero=new Warrior();
                break;
            case 1:
                Hero=new DarkKnight();
                break;
            case 2:
                Hero=new Medusa();
                break;
            case 3:
                Hero=new Mage();
                break;
        }
    }

    public Game (int index)
    {
        setUndecorated(true);
        setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        HeroIndex=index;
        ChosenHero(index);
        Screen.setBounds(0,0,1920,1080);
        Hero.setBounds(HeroX,HeroY,CardWidth,CardHeight);
        Gold.setBounds(1750,1000,64,64);
        Gold.setIcon(new ImageIcon("Assets/UIIcons/Gold.png"));
        Move.setBounds(400,925,138,138);
        Move.setIcon(new ImageIcon("Assets/Keys/MoveGame.png"));
        Menu.setBounds(1300,1000,64,64);
        Menu.setIcon(new ImageIcon("Assets/Keys/Menu.png"));
        MenuDescription.setBounds(1375,1010,250,50);
        MenuDescription.setFont(new Font("Arial",Font.PLAIN,40));
        MenuDescription.setForeground(Color.WHITE);
        MoveDescription.setBounds(560,975,250,50);
        MoveDescription.setFont(new Font("Arial",Font.PLAIN,40));
        MoveDescription.setForeground(Color.WHITE);
        GoldValue.setBounds(1810,1010,250,50);
        GoldValue.setText(String.valueOf(Hero.GetGold()));
        GoldValue.setForeground(Color.WHITE);
        GoldValue.setFont(new Font("Arial",Font.PLAIN,40));
        Items.setBounds(50,1000,250,50);
        Items.setFont(new Font("Arial",Font.PLAIN,40));
        Items.setForeground(Color.WHITE);
        Screen.add(GoldValue,Integer.valueOf(0));
        Screen.add(MenuDescription,Integer.valueOf(0));
        Screen.add(Menu,Integer.valueOf(0));
        Screen.add(Move,Integer.valueOf(0));
        Screen.add(MoveDescription,Integer.valueOf(0));
        Screen.add(Items,Integer.valueOf(0));
        Screen.add(Gold,Integer.valueOf(0));
        Screen.add(Hero);
        add(Screen);
        while (i<3)
        {
            if (i==0)
            {
                for (int j=0;j<3;j++)
                {
                    Card=GenerateTypeCardZone1();
                    if(Card.getName().equals("Enemy"))
                    {
                        Card=new Health();
                    }
                    Card.setBounds(LeftSide+j*225,HeroY-325,CardWidth,CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
            else
            {
                for (int j=0;j<3;j++)
                {
                    Card=GenerateTypeCardZone1();
                    if(Card.getName().equals("Enemy"))
                    {
                        ((Enemy)Card).SetAttacks(LeftSide+j*225);
                    }
                    Card.setBounds(LeftSide+j*225,HeroY-325-i*325,CardWidth,CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
            i++;
        }
        keyboard.getCards(cards,Hero);
        addKeyListener(keyboard);
        setVisible(true);
    }

    public void GenereateCards (int heroY,int MovesTaken)
    {
        if ((MovesTaken+3)%25==0)
        {
            GenerateBosses(heroY);
        }
        else if (AfterBossSquare)
        {
            AfterBossSquare=false;
            for (int j = 0; j < 3; j++)
            {
                int value=random.nextInt(100)+1;
                if (IsBetween(value,1,33))
                {
                    Card=new Health();
                    Card.UpdateValue(ScalingItems);
                }
                else if (IsBetween(value,34,67))
                {
                    Card=new Armor();
                    Card.UpdateValue(ScalingItems);
                }
                else
                {
                    Card=new Gold();
                    Card.UpdateValue(ScalingItems);
                }
                Card.setBounds(LeftSide + j * 225, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
            }
        }
        else
        {
            int value=random.nextInt(100)+1;
            if (IsBetween(value,1,5))
            {
               switch (ZoneIndex)
               {
                   case 1:
                       Card=GenerateTypeCardZone1();
                       break;
                   case 2:
                       Card=GenerateTypeCardZone2();
                       break;
                   case 3:
                       Card=GenerateTypeCardZone3();
                       break;
                   case 4:
                       Card=GenerateTypeCardZone4();
                       break;
               }
                if (Card.getName().equals("Enemy"))
                    ((Enemy)Card).SetAttacks(Middle);
                Card.setBounds(Middle, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
            }
            else if (IsBetween(value,6,20))
            {
                for (int j = 0; j < 3; j++)
                {
                    switch (ZoneIndex)
                    {
                        case 1:
                            Card = GenerateTypeCardZone1();
                            break;
                        case 2:
                            Card = GenerateTypeCardZone2();
                            break;
                        case 3:
                            Card = GenerateTypeCardZone3();
                            break;
                        case 4:
                            Card = GenerateTypeCardZone4();
                            break;
                    }
                    if (j == 1)
                        continue;
                    if (Card.getName().equals("Enemy"))
                        ((Enemy) Card).SetAttacks(LeftSide + j * 225);
                    Card.setBounds(LeftSide+j*225, heroY - 975, CardWidth, CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
            else if (IsBetween(value,21,35))
            {
                for (int j = 0; j < 2; j++)
                {
                    switch (ZoneIndex)
                    {
                        case 1:
                            Card = GenerateTypeCardZone1();
                            break;
                        case 2:
                            Card = GenerateTypeCardZone2();
                            break;
                        case 3:
                            Card = GenerateTypeCardZone3();
                            break;
                        case 4:
                            Card = GenerateTypeCardZone4();
                            break;
                    }
                    if (Card.getName().equals("Enemy"))
                        ((Enemy) Card).SetAttacks(LeftSide + j * 225);
                    Card.setBounds(LeftSide + j * 225, heroY - 975, CardWidth, CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
            else if (IsBetween(value,36,50))
            {
                for (int j = 0; j < 2; j++)
                {
                    switch (ZoneIndex)
                    {
                        case 1:
                            Card = GenerateTypeCardZone1();
                            break;
                        case 2:
                            Card = GenerateTypeCardZone2();
                            break;
                        case 3:
                            Card = GenerateTypeCardZone3();
                            break;
                        case 4:
                            Card = GenerateTypeCardZone4();
                            break;
                    }
                    if (Card.getName().equals("Enemy"))
                        ((Enemy) Card).SetAttacks(RightSide - j * 225);
                    Card.setBounds(RightSide - j * 225, heroY - 975, CardWidth, CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
            else {
                for (int j = 0; j < 3; j++)
                {
                    switch (ZoneIndex)
                    {
                        case 1:
                            Card = GenerateTypeCardZone1();
                            break;
                        case 2:
                            Card = GenerateTypeCardZone2();
                            break;
                        case 3:
                            Card = GenerateTypeCardZone3();
                            break;
                        case 4:
                            Card = GenerateTypeCardZone4();
                            break;
                    }
                    if (Card.getName().equals("Enemy"))
                        ((Enemy) Card).SetAttacks(LeftSide + j * 225);
                    Card.setBounds(LeftSide + j * 225, heroY - 975, CardWidth, CardHeight);
                    cards.add(Card);
                    Screen.add(Card,Integer.valueOf(0));
                }
            }
        }
    }
    public Foundation GenerateTypeCardZone1()
    {
        int value=random.nextInt(100)+1;
        if (IsBetween(value,1,15))
        {
            Foundation card=new Enemy();
            card.UpdateValue(ScalingEnemy);
            card.UpdateValue(-Hero.GetShield());
            return card;
        }
        else if (IsBetween(value,16,43))
        {
            Foundation card=new Armor();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else if (IsBetween(value,44,71))
        {
            Foundation card=new Gold();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else
        {
            Foundation card=new Health();
            card.UpdateValue(ScalingItems);
            return card;
        }
    }

    public Foundation GenerateTypeCardZone2()
    {
        int value=random.nextInt(100)+1;
        if (IsBetween(value,1,20))
        {
            Foundation card=new Enemy();
            card.UpdateValue(ScalingEnemy);
            card.UpdateValue(-Hero.GetShield());
            return card;
        }
        else if (IsBetween(value,21,47))
        {
            Foundation card=new Armor();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else if (IsBetween(value,48,73))
        {
            Foundation card=new Gold();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else
        {
            Foundation card=new Health();
            card.UpdateValue(ScalingItems);
            return card;
        }
    }

    public Foundation GenerateTypeCardZone3()
    {
        int value=random.nextInt(100)+1;
        if (IsBetween(value,1,30))
        {
            Foundation card=new Enemy();
            card.UpdateValue(ScalingEnemy);
            card.UpdateValue(-Hero.GetShield());
            return card;
        }
        else if (IsBetween(value,31,55))
        {
            Foundation card=new Armor();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else if (IsBetween(value,56,80))
        {
            Foundation card=new Gold();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else
        {
            Foundation card=new Health();
            card.UpdateValue(ScalingItems);
            return card;
        }
    }

    public Foundation GenerateTypeCardZone4()
    {
        int value=random.nextInt(100)+1;
        if (IsBetween(value,1,40))
        {
            Foundation card=new Enemy();
            card.UpdateValue(ScalingEnemy);
            card.UpdateValue(-Hero.GetShield());
            return card;
        }
        else if (IsBetween(value,41,65))
        {
            Foundation card=new Armor();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else if (IsBetween(value,66,80))
        {
            Foundation card=new Gold();
            card.UpdateValue(ScalingItems);
            return card;
        }
        else
        {
            Foundation card=new Health();
            card.UpdateValue(ScalingItems);
            return card;
        }
    }

    public boolean IsBetween (int Value, int LowerBound, int UpperBound)
    {
        return LowerBound<=Value && Value<=UpperBound;
    }

    public void DeadState ()
    {
        if (!HasWorked)
        {
            HasWorked=true;
            removeKeyListener(keyboard);
            GreyedOut();
            Dead dead=new Dead(this);
            dead.setBounds(650,250,650,500);
            Screen.add(dead,Integer.valueOf(1));
        }
    }

    public void RefreshGold(String Value)
    {
        GoldValue.setText(Value);
    }

    public void GreyedOut ()
    {
        Grey.setBackground(new Color(0,0,0,128));
        Grey.setBounds(0,0,200,299);
        Grey.setOpaque(true);
        Hero.add(Grey);
        for (Foundation element:cards)
        {
            JLabel Greyed=new JLabel();
            Greyed.setBackground(new Color(0,0,0,128));
            Greyed.setBounds(0,0,200,299);
            Greyed.setOpaque(true);
            element.add(Greyed);
        }
    }

    public void Win ()
    {
        if (!HasWorked)
        {
            HasWorked=true;
            removeKeyListener(keyboard);
            GreyedOut();
            Victory victory=new Victory(this);
            victory.setBounds(650,250,650,500);
            Screen.add(victory,Integer.valueOf(1));
        }
    }

    public int GetHeroIndex()
    {
        return HeroIndex;
    }

    public void GenerateBosses (int heroY)
    {
        Card = new Enemy();
        AfterBossSquare=true;
        ScalingEnemy+=((Card.GetUpperBound()+ScalingEnemy)/2);
        switch (ZoneIndex)
        {
            case 1:
                ((Enemy) Card).Boss1();
                Card.setBounds(Middle, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
                break;
            case 2:
                ((Enemy) Card).Boss2();
                Card.setBounds(Middle, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
                ScalingItems+=((Card.GetUpperBound()+ScalingItems)/2);
                break;
            case 3:
                ((Enemy) Card).Boss3();
                Card.setBounds(Middle, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
                break;
            case 4:
                ((Enemy) Card).Boss4();
                Card.setBounds(Middle, heroY - 975, CardWidth, CardHeight);
                cards.add(Card);
                Screen.add(Card,Integer.valueOf(0));
                break;
        }
        ZoneIndex++;
    }

    public int GetScalingItems()
    {
        return ScalingItems;
    }

    public void ItemReward(int ZoneIndex)
    {
        if (!HasWorked)
        {
            HasWorked=true;
            removeKeyListener(keyboard);
            GreyedOut();
            items=new Items(this,ZoneIndex);
            items.setBounds(650,250,650,500);
            Screen.add(items,Integer.valueOf(1));
        }
    }

    public void LightUp()
    {
        Screen.remove(items);
        Hero.remove(Grey);
        for (Foundation element:cards)
        {
            element.remove(element.getComponentCount()-1);
        }
        addKeyListener(keyboard);
        repaint();
        requestFocus();
        HasWorked=false;
    }

    public void IncreaseMaxHealth()
    {
        decorator=new LifePotion(Hero);
        decorator.Change(1);
    }

    public void GetValue(int value)
    {
        Value=value;
    }

    public void Reroll ()
    {
        if (Hero.GetGold()>=20)
        {
            decorator=new Buy(Hero);
            decorator.Change(Value);
            RefreshGold(String.valueOf(Hero.GetGold()));
            items.Swap();
        }
        else
        {
            items.Notification();
        }
    }

    public void IncrementLootBoxesCount()
    {
        Hero.ChangeLootBoxes();
    }

    public void IncrementMidasPouchCount()
    {
        Hero.ChangeMidasPouches();
    }

    public void IncrementShieldCount()
    {
        Hero.ChangeShield();
    }

    public void ReferenceToDescription (JButton Interacted)
    {
        items.DescriptionOfItem(Interacted);
    }

    public void RefrenceToHideDescription()
    {
        items.HideDescription();
    }
}
