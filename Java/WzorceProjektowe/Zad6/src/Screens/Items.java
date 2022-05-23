package Screens;

import Cards.Items.*;
import Handlers.MouseScreens;
import UIMessages.NotEnoughGold;
import Windows.Game;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Items extends JPanel
{
    JLabel                Message=new JLabel(),           GoldIcon=new JLabel(),  Value=new JLabel(),
                          Description=new JLabel();
    Blueprint             card;
    JPanel                notEnoughGold;
    JButton               Reroll=new JButton();
    ArrayList<Blueprint>  cards=new ArrayList<>();
    JLayeredPane          RerollRow=new JLayeredPane(),   Screen=new JLayeredPane();
    Game                  myFrame;
    Random                random=new Random();
    MouseScreens          mouseScreens;
    final int             CardSpacing=225,                WidthCard=200,          HeightCard=300;
    boolean               Blocked=false;
    boolean[]             ItemOptions=new boolean[6];

    public Items (Game MyFrame,int value)
    {
        myFrame=MyFrame;
        myFrame.GetValue(value);
        Value.setText(String.valueOf(value));
        mouseScreens=new MouseScreens(myFrame);
        Screen.setBounds(0,0,650,500);
        setSize(650,500);
        setLayout(null);
        Message.setBounds(150,0,300,50);
        RandomizeCards();
        RerollRow.setBounds(175,400,250,50);
        Reroll.setBounds(0,0,250,50);
        GoldIcon.setBounds(175,10,32,32);
        Value.setBounds(200,0,50,50);
        Value.setForeground(Color.WHITE);
        Value.setFont(new Font("Arial",Font.PLAIN,40));
        Message.setIcon(new ImageIcon("Assets/Screens/Choice.png"));
        GoldIcon.setIcon(new ImageIcon("Assets/UIIcons/MiniGoldIcon.png"));
        Reroll.setIcon(new ImageIcon("Assets/Screens/Reroll.png"));
        Reroll.setBackground(Color.BLACK);
        Reroll.addMouseListener(mouseScreens);
        Reroll.setName("Reroll");
        Reroll.setBorder(BorderFactory.createEmptyBorder());
        setBackground(Color.BLACK);
        Screen.add(Message,Integer.valueOf(0));
        RerollRow.add(GoldIcon,Integer.valueOf(1));
        RerollRow.add(Reroll,Integer.valueOf(0));
        RerollRow.add(Value,Integer.valueOf(2));
        Screen.add(RerollRow,Integer.valueOf(0));
        add(Screen);
    }

    public void RandomizeCards()
    {
        for (boolean element:ItemOptions)
        {
            element=false;
        }
        for (int i=0;i<3;i++)
        {
            int value=random.nextInt(6)+1;
            Blocked=false;
            switch(value)
            {
                case 1:
                    if (!ItemOptions[0])
                    {
                        ItemOptions[0]=true;
                        card = new LifePotion();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 2:
                    if (!ItemOptions[1])
                    {
                        ItemOptions[1]=true;
                        card = new MidasPouch();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 3:
                    if (!ItemOptions[2])
                    {
                        ItemOptions[2]=true;
                        card = new LootBox();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 4:
                    if (!ItemOptions[3])
                    {
                        ItemOptions[3]=true;
                        card = new Shield();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 5:
                    if (!ItemOptions[4])
                    {
                        ItemOptions[4]=true;
                        card = new ButcherKnife();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 6:
                    if (!ItemOptions[5])
                    {
                        ItemOptions[5]=true;
                        card = new Copyright();
                    }
                    else
                    {
                        i--;
                        Blocked=true;
                    }
                    break;
                case 7:
                    card = new InfinityStone();
                    break;
                case 8:
                    card = new CharonsCoin();
                    break;
                case 9:
                    card = new MidasTouch();
                    break;
            }
            if (!Blocked)
            {
                card.setBounds(i*CardSpacing,75,WidthCard,HeightCard);
                card.setBackground(Color.BLACK);
                card.addMouseListener(mouseScreens);
                card.setBorder(BorderFactory.createEmptyBorder());
                cards.add(card);
                Screen.add(card,Integer.valueOf(0));
            }
        }
    }

    public void Swap()
    {
        for (int i=0;i<3;i++)
        {
            cards.get(i).setVisible(false);
        }
        for (boolean element:ItemOptions)
        {
            element=false;
        }
        for (int i=0;i<3;i++)
        {
            int value=random.nextInt(6)+1;
            Blocked=false;
            switch(value)
            {
                case 1:
                    if (!ItemOptions[0])
                    {
                        ItemOptions[0] = true;
                        card = new LifePotion();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
                case 2:
                    if (!ItemOptions[1])
                    {
                        ItemOptions[1] = true;
                        card = new MidasPouch();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
                case 3:
                    if (!ItemOptions[2])
                    {
                        ItemOptions[2] = true;
                        card = new LootBox();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
                case 4:
                    if (!ItemOptions[3])
                    {
                        ItemOptions[3] = true;
                        card = new Shield();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
                case 5:
                    if (!ItemOptions[4])
                    {
                        ItemOptions[4] = true;
                        card = new ButcherKnife();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
                case 6:
                    if (!ItemOptions[5])
                    {
                        ItemOptions[5] = true;
                        card = new Copyright();
                    }
                    else
                    {
                        i--;
                        Blocked = true;
                    }
                    break;
            }
            if (!Blocked)
            {
                card.setBounds(i*CardSpacing,75,WidthCard,HeightCard);
                card.setBackground(Color.BLACK);
                card.addMouseListener(mouseScreens);
                card.setBorder(BorderFactory.createEmptyBorder());
                cards.add(card);
                Screen.add(card,Integer.valueOf(0));
            }
        }
    }

    public void Notification ()
    {
        notEnoughGold=new NotEnoughGold();
        notEnoughGold.setBounds(75,175,500,50);
        Screen.add(notEnoughGold,Integer.valueOf(1));
    }

}
