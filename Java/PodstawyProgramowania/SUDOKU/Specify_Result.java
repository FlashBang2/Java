package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Specify_Result extends JFrame implements ActionListener
{
    public Specify_Result()
    {
        setSize(getMaximumSize());
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wynik Wyszukiwania");
        JLabel ID_opis=new JLabel("ID");
        JLabel Imie_opis=new JLabel("IMIE");
        JLabel ImieID_opis=new JLabel("IMIEID");
        JLabel Difficulty_opis=new JLabel("DIFFICULTY");
        JLabel Start_Date_opis=new JLabel("START DATE");
        JLabel Status_opis=new JLabel("STATUS");
        JLabel End_Date_opis=new JLabel("END DATE");
        JLabel Time_opis=new JLabel("TIME");
        ID_opis.setFont(new Font("Arial", Font.BOLD, 22));
        Imie_opis.setFont(new Font("Arial", Font.BOLD, 22));
        ImieID_opis.setFont(new Font("Arial", Font.BOLD, 22));
        Difficulty_opis.setFont(new Font("Arial", Font.BOLD, 22));
        Start_Date_opis.setFont(new Font("Arial", Font.BOLD, 22));
        Status_opis.setFont(new Font("Arial", Font.BOLD, 22));
        End_Date_opis.setFont(new Font("Arial", Font.BOLD, 22));
        Time_opis.setFont(new Font("Arial", Font.BOLD, 22));
        JPanel panelglowny=new JPanel();
        panelglowny.add(ID_opis);
        panelglowny.add(Imie_opis);
        panelglowny.add(ImieID_opis);
        panelglowny.add(Difficulty_opis);
        panelglowny.add(Start_Date_opis);
        panelglowny.add(Status_opis);
        panelglowny.add(End_Date_opis);
        panelglowny.add(Time_opis);
        panelglowny.setLayout(new FlowLayout(FlowLayout.LEFT, 95, 20));
        add(panelglowny);
        try
        {
           RandomAccessFile plik = new RandomAccessFile("plik.dat","r");
            JLabel ID=new JLabel(String.valueOf(plik.readInt()));
            JLabel Imie=new JLabel(plik.readUTF());
            JLabel ImieID=new JLabel(String.valueOf(plik.readInt()));
            JLabel Difficulty=new JLabel(plik.readUTF());
            JLabel Start_Date=new JLabel(plik.readUTF());
            JLabel Status=new JLabel(plik.readUTF());
            JLabel End_Date=new JLabel(plik.readUTF());
            JLabel Time=new JLabel(String.valueOf(plik.readInt()));
            ID.setFont(new Font("Arial", Font.BOLD, 22));
            Imie.setFont(new Font("Arial", Font.BOLD, 22));
            ImieID.setFont(new Font("Arial", Font.BOLD, 22));
            Difficulty.setFont(new Font("Arial", Font.BOLD, 22));
            Start_Date.setFont(new Font("Arial", Font.BOLD, 22));
            Status.setFont(new Font("Arial", Font.BOLD, 22));
            End_Date.setFont(new Font("Arial", Font.BOLD, 22));
            Time.setFont(new Font("Arial", Font.BOLD, 22));
            JPanel panel1=new JPanel();
            panel1.add(ID);
            panel1.add(Imie);
            panel1.add(ImieID);
            panel1.add(Difficulty);
            panel1.add(Start_Date);
            panel1.add(Status);
            panel1.add(End_Date);
            panel1.add(Time);
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 20));
            add(panel1);
        }
        catch(FileNotFoundException x)
        {
          System.out.print("Błąd");
        }
        catch(IOException a)
        {
          System.out.print("Błąd2");
        }
        JButton button2 = new JButton("MENU");
        button2.setFont(new Font("Arial", Font.BOLD, 22));
        button2.addActionListener(this);
        add(button2);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
        new Menu();
    }
}
