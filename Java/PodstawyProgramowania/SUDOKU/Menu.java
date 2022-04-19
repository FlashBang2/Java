package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Menu extends JFrame implements ActionListener {
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    private final JButton button6;
    private final JButton button7;
    int [] [] tabel=new int[9][9];
    String level="";
    Path path=Paths.get("plik.dat");
    Path path2=Paths.get("plik2.dat");
    public Menu()
    {
        super("SUDOKU");
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        JPanel title_screen = new Title_Screen();
        add(title_screen);
        button1 = new JButton("GRAJ");
        button1.setFont(new Font("Arial", Font.BOLD, 22));
        button2 = new JButton("ZAŁADUJ OSTATNIĄ GRĘ");
        button2.setFont(new Font("Arial", Font.BOLD, 22));
        button3 = new JButton("WYBIERZ ZAPISANĄ GRĘ");
        button3.setFont(new Font("Arial", Font.BOLD, 22));
        button4 = new JButton("TABLICA WYNIKÓW");
        button4.setFont(new Font("Arial", Font.BOLD, 22));
        button5 = new JButton("WYSZUKAJ GRĘ");
        button5.setFont(new Font("Arial", Font.BOLD, 22));
        button6 = new JButton("ZAIMPORTUJ GRĘ");
        button6.setFont(new Font("Arial", Font.BOLD, 22));
        button7 = new JButton("RANKING");
        button7.setFont(new Font("Arial", Font.BOLD, 22));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == button1)
        {
            dispose();
            new Rejestracja();
        }
        if (zrodlo == button2)
        {
            Path path= Paths.get("plik2.dat");
            Path path2=Paths.get("plik.dat");
            if(Files.exists(path) && Files.exists(path2))
            {
                try {
                    dispose();
                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                    RandomAccessFile plik2 = new RandomAccessFile("plik2.dat","r");
                    plik.seek(0);
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        plik.readUTF();
                        plik.readInt();
                        level=plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                    }
                    while(plik2.length()>plik2.getFilePointer())
                    {
                        plik2.readInt();
                        for(int i=0;i< tabel.length;i++)
                        {
                            for(int j=0;j<tabel[i].length;j++)
                            {
                                plik2.read();
                            }
                        }
                    }
                    new Glowny_Ekran(level,1);
                }
                catch(FileNotFoundException x)
                {
                    System.out.print("Błąd");
                }
                catch(IOException a)
                {
                    System.out.print("Błąd2");
                }

            }
        }
        if (zrodlo == button3 && Files.exists(path) && Files.exists((path2)))
        {
            dispose();
            new Lista_Zapisanych_Gier(path,path2);
        }
        if (zrodlo == button4 && Files.exists(path))
        {
            dispose();
            new Tablica_Wynikow();
        }
        if (zrodlo == button5 && Files.exists(path))
        {
            dispose();
            new Wyszukaj_Gre();
        }
        if (zrodlo == button6)
        {
            dispose();
            new Import_Text();
        }
        if (zrodlo == button7 && Files.exists(path))
        {
            dispose();
            new  Rank();
        }
    }
}