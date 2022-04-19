package com.company;
import javax.swing.*;
public class LFajerwerk extends JPanel
{
    public LFajerwerk()
    {
        super();
        Icon imgIcon = new ImageIcon(this.getClass().getResource("Fajerwerki.gif"));
        JLabel LFajerwerki = new JLabel(imgIcon);
        add(LFajerwerki);

    }
}
