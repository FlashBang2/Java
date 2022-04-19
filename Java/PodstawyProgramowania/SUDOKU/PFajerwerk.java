package com.company;
import javax.swing.*;
public class PFajerwerk extends JPanel
{
    public PFajerwerk()
    {
        super();
        Icon imgIcon = new ImageIcon(this.getClass().getResource("Fajerwerki.gif"));
        JLabel PFajerwerki = new JLabel(imgIcon);
        add(PFajerwerki);
    }
}
