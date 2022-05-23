package Handlers;

import Cards.Pickups.Enemy;
import Cards.Pickups.Foundation;
import Heroes.*;
import Heroes.Decorators.*;
import Threads.Dispose;
import Windows.Game;
import Windows.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class KeyboardGame implements KeyListener
{
    ArrayList<Foundation>   cards;
    Game                    myFrame;
    Thread                  Thread;
    HeroDecorator           heroDecorator;
    Base                    hero;
    boolean                 HasWorked=false, PossibleMove=false;
    int                     ZoneIndex=1;
    final int               NextColumn=225,NextRow=325,LeftSide=650,
                            RightSide=1100,Middle=875;
    FileOutputStream        SaveWrite;
    String                  Save="Save.bin";
    ObjectOutputStream      Write;

    public KeyboardGame (Game MyFrame)
    {
        myFrame=MyFrame;
    }

    public void getCards (ArrayList<Foundation> Cards, Base Hero)
    {
        cards=Cards;
        hero=Hero;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent Press)
    {
        switch (Press.getKeyCode())
        {
            case KeyEvent.VK_A:
                PressedMove(-NextColumn);
                GetAttacker();
                break;
            case KeyEvent.VK_D:
                PressedMove(NextColumn);
                GetAttacker();
                break;
            case KeyEvent.VK_W:
                PressedMove(0);
                GetAttacker();
                break;
            case KeyEvent.VK_ESCAPE:
                Thread=new Dispose(myFrame);
                Thread.start();
                new Menu();
                break;
        }
    }

    public void PressedMove (int X)
    {
        for (Foundation element : cards)
        {
            if (hero.getX()+X==element.getX() && hero.getY()==element.getY()+NextRow)
                PossibleMove=true;
        }
        if (PossibleMove)
        {
            hero.ChangeTakenMoves(hero.GetTakenMoves()+1);
            for (Foundation element : cards)
            {
                if (hero.getX()+X==element.getX() && hero.getY() == element.getY() + NextRow && !HasWorked)
                    {
                        HasWorked=true;
                        GetDecoratorType(element,X);
                    }
                if (element.getY() > 350)
                    element.setVisible(false);
                element.setLocation(element.getX(), element.getY() + NextRow);
            }
            if (hero.GetTakenMoves()<98)
                myFrame.GenereateCards(hero.getY(),hero.GetTakenMoves());
            if (hero.GetTakenMoves()==100 && hero.GetCurrentHealth()>0)
            {
                myFrame.Win();
                try
                {
                    SaveWrite=new FileOutputStream(Save);
                    Write=new ObjectOutputStream(SaveWrite);
                    if (myFrame.GetHeroIndex()==0);
                        {
                            Write.writeBoolean(true);
                            Write.writeBoolean(false);
                            Write.writeBoolean(false);
                        }
                    if (myFrame.GetHeroIndex()==1)
                    {
                        Write.writeBoolean(true);
                        Write.writeBoolean(true);
                        Write.writeBoolean(false);
                    }
                    if (myFrame.GetHeroIndex()==2)
                    {
                        Write.writeBoolean(true);
                        Write.writeBoolean(true);
                        Write.writeBoolean(true);
                    }
                    Write.close();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (hero.GetTakenMoves()%25==0 && hero.GetCurrentHealth()>0 && hero.GetTakenMoves()!=100)
            {
                myFrame.ItemReward(ZoneIndex*20);
                ZoneIndex++;
            }
            HasWorked=false;
            PossibleMove=false;
        }
    }

    public void GetDecoratorType (Foundation element,int X)
    {
        switch (element.getName())
        {
            case "Armor":
                heroDecorator = new Armor(hero);
                heroDecorator.Change(element.GetValue());
                hero.setLocation(hero.getX()+X, hero.getY());
                break;
            case "Health":
                heroDecorator = new Health(hero);
                heroDecorator.Change(element.GetValue());
                hero.setLocation(hero.getX()+X, hero.getY());
                break;
            case "Gold":
                heroDecorator = new Gold(hero);
                heroDecorator.Change(element.GetValue());
                myFrame.RefreshGold(String.valueOf(hero.GetGold()));
                heroDecorator=new Health(hero);
                heroDecorator.Change(hero.GetMidasPouches());
                hero.setLocation(hero.getX()+X, hero.getY());
                break;
            case "Enemy":
                heroDecorator = new Damage(hero,myFrame);
                heroDecorator.Change(element.GetValue());
                hero.ChangeMaxHealth(hero.GetMaxHealth()+hero.GetButcherKnife());
                heroDecorator = new Health(hero);
                heroDecorator.Change(hero.GetButcherKnife());
                hero.setLocation(hero.getX()+X, hero.getY());
                break;
        }
    }

    public void GetAttacker ()
    {
       switch (hero.getX())
       {
           case LeftSide:
               TakeForwardEnemy(LeftSide);
               TakeRightEnemy(LeftSide);
               break;
           case Middle:
               TakeForwardEnemy(Middle);
               TakeLeftEnemy(Middle);
               TakeRightEnemy(Middle);
               break;
           case RightSide:
               TakeForwardEnemy(RightSide);
               TakeLeftEnemy(RightSide);
               break;
       }
    }

    public void TakeForwardEnemy(int heroX)
    {
        for (Foundation element:cards)
        {
            if (heroX==element.getX() && hero.getY()==element.getY()+NextRow && element.getName().equals("Enemy"))
            {
                if(((Enemy)element).GetAttacks()[1])
                {
                    EnemyReplacement(element);
                }
            }
        }
    }

    public void TakeLeftEnemy(int heroX)
    {
        for (Foundation element:cards)
        {
            if (heroX-NextColumn==element.getX() && hero.getY()==element.getY()+NextRow && element.getName().equals("Enemy"))
            {
                if (((Enemy)element).GetAttacks()[2])
                {
                    EnemyReplacement(element);
                }
            }
        }
    }

    public void TakeRightEnemy(int heroX)
    {
        for (Foundation element:cards)
        {
            if (heroX+NextColumn==element.getX() && hero.getY()==element.getY()+NextRow && element.getName().equals("Enemy"))
            {
                if (((Enemy)element).GetAttacks()[0])
                {
                    EnemyReplacement(element);
                }
            }
        }
    }

    public void EnemyReplacement (Foundation element)
    {
        int index=cards.indexOf(element);
        Foundation Replacement=((Enemy)element).PlaceLoot(element);
        Replacement.UpdateValue(myFrame.GetScalingItems());
        if (Replacement.getName().equals("Armor"))
            Replacement.UpdateValue(hero.GetCopyRight());
        Replacement.BoxSpecial(hero.GetLootBoxes());
        cards.set(index,Replacement);
        myFrame.add(cards.get(index));
        element.setVisible(false);
        heroDecorator=new Damage(hero,myFrame);
        heroDecorator.Change(element.GetValue());
        hero.ChangeMaxHealth(hero.GetMaxHealth()+hero.GetButcherKnife());
        heroDecorator = new Health(hero);
        heroDecorator.Change(hero.GetButcherKnife());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}
