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
        for (int i=0;i<3;i++)
        {
            int value=random.nextInt(4)+1;
            switch(value)
            {
                case 1:
                    card = new LifePotion();
                    break;
                case 2:
                    card = new MidasPouch();
                    break;
                case 3:
                    card = new LootBox();
                    break;
                case 4:
                    card = new Shield();
                    break;
            }
            card.setBounds(i*CardSpacing,75,WidthCard,HeightCard);
            card.setBackground(Color.BLACK);
            card.addMouseListener(mouseScreens);
            card.setBorder(BorderFactory.createEmptyBorder());
            cards.add(card);
            Screen.add(card,Integer.valueOf(0));
        }
    }

    public void Swap()
    {
        for (int i=0;i<3;i++)
        {
            cards.get(i).setVisible(false);
        }
        for (int i=0;i<3;i++)
        {
            int value=random.nextInt(4)+1;
            switch(value)
            {
                case 1:
                    card = new LifePotion();
                    break;
                case 2:
                    card = new MidasPouch();
                    break;
                case 3:
                    card = new LootBox();
                    break;
                case 4:
                    card = new Shield();
                    break;
            }
            card.setBounds(i*CardSpacing,75,WidthCard,HeightCard);
            card.setBackground(Color.BLACK);
            card.addMouseListener(mouseScreens);
            card.setBorder(BorderFactory.createEmptyBorder());
            cards.add(card);
            Screen.add(card,Integer.valueOf(0));
        }
    }

    public void Notification ()
    {
        notEnoughGold=new NotEnoughGold();
        notEnoughGold.setBounds(75,175,500,50);
        Screen.add(notEnoughGold,Integer.valueOf(1));
    }

    public void DescriptionOfItem (JButton Interacted)
    {
        Description.setVisible(true);
        switch (Interacted.getName())
        {
            case "LifePotion":
                Description.setIcon(new ImageIcon("Assets/Descriptions/LifePotion.png"));
                Screen.add(Description,Integer.valueOf(1));
                break;
            case "LootBox":
                Description.setIcon(new ImageIcon("Assets/Descriptions/LootBox.png"));
                Screen.add(Description,Integer.valueOf(1));
                break;
            case "Shield":
                Description.setIcon(new ImageIcon("Assets/Descriptions/Shield.png"));
                Screen.add(Description,Integer.valueOf(1));
                break;
            case "MidasPouch":
                Description.setIcon(new ImageIcon("Assets/Descriptions/MidasPouch.png"));
                Screen.add(Description,Integer.valueOf(1));
                break;
        }
        Description.setBounds(Interacted.getX()+1,Interacted.getY(),200,300);
    }

    public void HideDescription()
    {
        Description.setVisible(false);
    }
}
