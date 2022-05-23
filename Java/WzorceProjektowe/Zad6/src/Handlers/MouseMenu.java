package Handlers;

import Threads.Dispose;
import Windows.Select;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseMenu implements MouseListener
{
    JFrame myFrame;
    Thread  Thread;

    public MouseMenu(JFrame MyFrame)
    {
        myFrame=MyFrame;
    }

    @Override
    public void mouseClicked(MouseEvent Interacted)
    {
        JButton Pressed=(JButton) Interacted.getSource();
        switch (Pressed.getName())
        {
            case "Start":
                myFrame.removeMouseListener(this);
                Thread=new Dispose(myFrame);
                Thread.start();
                new Select();
                break;
            case "Continue":
                break;
            case "Credits":
                break;
            case "Exit":
                myFrame.dispose();
                System.exit(0);
                break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent Entered)
    {
        JButton Interacted=(JButton) Entered.getSource();
        Interacted.setBackground(Color.GRAY);
    }

    @Override
    public void mouseExited(MouseEvent Exited)
    {
        JButton Interacted=(JButton) Exited.getSource();
        Interacted.setBackground(Color.BLACK);
    }
}
