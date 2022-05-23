package Handlers;

import Cards.Items.Blueprint;
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
                new Game(myFrame.GetHeroIndex(),false);
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
            case "ButcherKnife":
                myFrame.LightUp();
                myFrame.IncrementButcherKnife();
                break;
            case "CopyRight":
                myFrame.LightUp();
                myFrame.IncrementCopyRights();
                break;
            case "PandorasBox":
                break;
        }
        myFrame.CreateCollectedItemIcon(Interacted.getName());
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
        Interacted.setBackground(Color.GRAY);
        if (!Interacted.getName().equals("Reroll") && !Interacted.getName().equals("Menu") && !Interacted.getName().equals("Respawn"))
            ((Blueprint)Interacted).RevealDescription();
    }

    @Override
    public void mouseExited(MouseEvent Exited)
    {
        JButton Interacted=(JButton) Exited.getSource();
        Interacted.setBackground(Color.BLACK);
        if (!Interacted.getName().equals("Reroll") && !Interacted.getName().equals("Menu") && !Interacted.getName().equals("Respawn"))
            ((Blueprint)Interacted).HideDescription();
    }
}
