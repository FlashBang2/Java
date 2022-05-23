package Handlers;

import Threads.Dispose;
import Windows.Game;
import Windows.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseScreens implements MouseListener
{
    Game myFrame;
    Thread Dispose;

    public MouseScreens (Game MyFrame)
    {
        myFrame=MyFrame;
    }

    @Override
    public void mouseClicked(MouseEvent Clicked)
    {
        JButton Interacted=(JButton) Clicked.getSource();
        switch (Interacted.getName())
        {
            case "Respawn":
                Dispose=new Dispose(myFrame);
                Dispose.start();
                new Game(myFrame.GetHeroIndex());
                break;
            case "Menu":
                Dispose=new Dispose(myFrame);
                Dispose.start();
                new Menu();
                break;
            case "Reroll":
                myFrame.Reroll();
                break;
            case "LifePotion":
                myFrame.LightUp();
                myFrame.IncreaseMaxHealth();
                break;
            case "MidasPouch":
                myFrame.LightUp();
                myFrame.IncrementMidasPouchCount();
                break;
            case "LootBox":
                myFrame.LightUp();
                myFrame.IncrementLootBoxesCount();
                break;
            case "Shield":
                myFrame.LightUp();
                myFrame.IncrementShieldCount();
                break;
            case "PandorasBox":
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent Entered)
    {
        JButton Interacted=(JButton) Entered.getSource();
        if (!Interacted.getName().equals("Reroll"))
            myFrame.ReferenceToDescription(Interacted);
        Interacted.setBackground(Color.GRAY);

    }

    @Override
    public void mouseExited(MouseEvent Exited)
    {
        JButton Interacted=(JButton) Exited.getSource();
        if (!Interacted.getName().equals("Reroll"))
            myFrame.RefrenceToHideDescription();
        Interacted.setBackground(Color.BLACK);
    }
}
