package com.company;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Wyszukaj_Gre extends JFrame implements ActionListener
{
    JList Kryteria;
    JButton button;
    private static String[] Wybory={"ID","Imie","ImieID","Difficulty","Start Date","Status","End Date","Time"};
    String a;
    public Wyszukaj_Gre ()
    {
        setSize(600,600);
        setTitle("Wyszukiwarka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        JLabel opis=new JLabel("Wybierz interesujące Ciebie kryterium");
        opis.setFont(new Font("Arial", Font.BOLD, 22));
        add(opis);
        Kryteria=new JList(Wybory);
        Kryteria.setFont(new Font("Arial", Font.BOLD, 22));
        Kryteria.setVisibleRowCount(1);
        Kryteria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(Kryteria);
        Kryteria.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event)
                    {
                        a=Wybory[Kryteria.getSelectedIndex()];
                    }
                }
        );
        button=new JButton("DALEJ");
        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD, 22));
        add(button);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object przycisk=e.getSource();
        if(button==przycisk && !Kryteria.isSelectionEmpty())
        {
            dispose();
            new Wczytanie_Konkretnej_Gry(a);
        }
    }
}
