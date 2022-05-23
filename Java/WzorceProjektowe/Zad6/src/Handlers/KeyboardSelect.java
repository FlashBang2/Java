package Handlers;

import Options.Template;
import Threads.Dispose;
import Windows.Game;
import Windows.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.nio.file.*;

public class KeyboardSelect implements KeyListener
{
    JFrame              myFrame;
    Thread              Thread;
    ArrayList<Template> selektor=new ArrayList<>();
    int                 index=0;
    boolean             UnlockedDarkKnight=false,UnlockedMedusa=false,UnlockedMage=false;
    String              Save="Save.bin";
    FileInputStream     SaveRead;
    ObjectInputStream   Read;
    Path                path;

    public KeyboardSelect(JFrame MyFrame)
    {
        myFrame=MyFrame;
        path=Paths.get(Save);
        if (Files.exists(path))
        {
            try
            {
                SaveRead=new FileInputStream(Save);
                Read=new ObjectInputStream(SaveRead);
                UnlockedDarkKnight=Read.readBoolean();
                UnlockedMedusa=Read.readBoolean();
                UnlockedMage=Read.readBoolean();
                Read.close();
            }
            catch (FileNotFoundException e)
            {

            }
            catch (IOException e)
            {

            }
        }
    }

    public void Chooser(ArrayList<Template> Selektor)
    {
        selektor=Selektor;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent Pressed)
    {
        switch(Pressed.getKeyCode())
        {
            case KeyEvent.VK_A:
                index--;
                if (index==-1)
                {
                    index=3;
                    ((Template)selektor.toArray()[0]).setBackground(Color.BLACK);
                    ((Template)selektor.toArray()[index]).setBackground(Color.WHITE);
                }
                else
                {
                    ((Template)selektor.toArray()[index+1]).setBackground(Color.BLACK);
                    ((Template)selektor.toArray()[index]).setBackground(Color.WHITE);
                }
                break;
            case KeyEvent.VK_D:
                index++;
                if (index==4)
                {
                    index=0;
                    ((Template)selektor.toArray()[3]).setBackground(Color.BLACK);
                    ((Template)selektor.toArray()[index]).setBackground(Color.WHITE);
                }
                else
                {
                    ((Template) selektor.toArray()[index - 1]).setBackground(Color.BLACK);
                    ((Template) selektor.toArray()[index]).setBackground(Color.WHITE);
                }
                break;
            case KeyEvent.VK_ENTER:
                if(index==0)
                {
                    Thread=new Dispose(myFrame);
                    Thread.start();
                    new Game(index,true);

                }
                else if (index==1 && UnlockedDarkKnight)
                {
                    Thread=new Dispose(myFrame);
                    Thread.start();
                    new Game(index,false);
                }
                else if (index==2 && UnlockedMedusa)
                {
                    Thread=new Dispose(myFrame);
                    Thread.start();
                    new Game(index,false);
                }
                else if (index==3 && UnlockedMage)
                {
                    Thread=new Dispose(myFrame);
                    Thread.start();
                    new Game(index,false);
                }
                break;
            case KeyEvent.VK_ESCAPE:
                Thread=new Dispose(myFrame);
                Thread.start();
                new Menu();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
