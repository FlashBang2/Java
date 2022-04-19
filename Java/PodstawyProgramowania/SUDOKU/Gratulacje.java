package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Gratulacje extends JFrame implements ActionListener
{
    JButton Dalej;
    int [][]tabel=new int[9][9];
    public Gratulacje (String a, String b,int c,int d,int g)
    {
        super("Gratulacje!");
        Path plik2 =Paths.get("plik2.dat");
        if(Files.exists(plik2))
        {
            try
            {
                RandomAccessFile plik = new RandomAccessFile("plik2.dat", "rw");
                plik.seek(0);
                int r=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        r=plik.readInt();
                        for(int i=0;i<tabel.length;i++)
                        {
                            for(int j=0;j<tabel[i].length;j++)
                            {
                                plik.read();
                            }
                        }
                    }
                    plik.close();
                    if(r==g)
                    {
                        File file=new File("plik2.dat");
                        file.delete();
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JPanel lFajerwerk = new LFajerwerk();
                        add(lFajerwerk, BorderLayout.LINE_START);
                        JPanel Gratuluje = new JPanel();
                        Gratuluje.setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
                        JLabel cz1 = new JLabel("Gratuluje " + a);
                        cz1.setFont(new Font("Arial", Font.BOLD, 22));
                        JLabel cz2 = new JLabel("Ukończono poziom " + b);
                        cz2.setFont(new Font("Arial", Font.BOLD, 22));
                        JLabel cz3 = new JLabel("Zajelo Ci to " + c+" sekund");
                        cz3.setFont(new Font("Arial", Font.BOLD, 22));
                        JLabel cz4 = new JLabel("Błędów " + d);
                        cz4.setFont(new Font("Arial", Font.BOLD, 22));
                        Gratuluje.add(cz1);
                        Gratuluje.add(cz2);
                        Gratuluje.add(cz3);
                        Gratuluje.add(cz4);
                        JPanel pFajerwerk = new PFajerwerk();
                        add(pFajerwerk, BorderLayout.LINE_END);
                        setSize(getMaximumSize());
                        Dalej = new JButton("DALEJ");
                        Dalej.addActionListener(this);
                        Dalej.setFont(new Font("Arial", Font.BOLD, 22));
                        Gratuluje.add(Dalej);
                        add(Gratuluje);
                        setVisible(true);
                    }

            }
            catch(FileNotFoundException q)
            {
                System.out.print("Błąd");
            }
            catch(IOException m)
            {
                System.out.print("Błąd2");
            }
        }
        else
            {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JPanel lFajerwerk = new LFajerwerk();
                    add(lFajerwerk, BorderLayout.LINE_START);
                    JPanel Gratuluje = new JPanel();
                    Gratuluje.setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
                    JLabel cz1 = new JLabel("Gratuluje " + a);
                    cz1.setFont(new Font("Arial", Font.BOLD, 22));
                    JLabel cz2 = new JLabel("Ukończono poziom " + b);
                    cz2.setFont(new Font("Arial", Font.BOLD, 22));
                    JLabel cz3 = new JLabel("Zajelo Ci to " + c+" sekund");
                    cz3.setFont(new Font("Arial", Font.BOLD, 22));
                    JLabel cz4 = new JLabel("Błędów " + d);
                    cz4.setFont(new Font("Arial", Font.BOLD, 22));
                    Gratuluje.add(cz1);
                    Gratuluje.add(cz2);
                    Gratuluje.add(cz3);
                    Gratuluje.add(cz4);
                    JPanel pFajerwerk = new PFajerwerk();
                    add(pFajerwerk, BorderLayout.LINE_END);
                    setSize(getMaximumSize());
                    Dalej = new JButton("DALEJ");
                    Dalej.addActionListener(this);
                    Dalej.setFont(new Font("Arial", Font.BOLD, 22));
                    Gratuluje.add(Dalej);
                    add(Gratuluje);
                    setVisible(true);
            }
    }
    @Override
        public void actionPerformed(ActionEvent e)
        {
            Object button = e.getSource();
            if(Dalej==button)
            {
                dispose();
                new Menu();
            }
        }
}
