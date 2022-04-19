package com.company;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.*;
public class Rejestracja extends JFrame implements ActionListener
{
    JTextField imie;
    JLabel naglowek,naglowek2;
    JButton dalej;
    JList trudnosc;
    String a;
    private static String[] options ={"easy","normal","hard"};
    public Rejestracja ()
    {
        setTitle("Rejestracja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        naglowek = new JLabel("Podaj swoje imię: ");
        naglowek.setFont(new Font("Arial", Font.BOLD, 22));
        add(naglowek);
        imie = new JTextField(10);
        imie.setFont(new Font("Arial", Font.BOLD, 22));
        add(imie);
        naglowek2 = new JLabel("Wybierz poziom trudności: ");
        naglowek2.setFont(new Font("Arial", Font.BOLD, 22));
        add(naglowek2);
        trudnosc = new JList(options);
        trudnosc.setFont(new Font("Arial", Font.BOLD, 22));
        trudnosc.setVisibleRowCount(1);
        trudnosc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(trudnosc);
        trudnosc.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event)
                    {
                        a=options[trudnosc.getSelectedIndex()];
                    }
                }
        );
        dalej = new JButton("Dalej");
        dalej.setFont(new Font("Arial", Font.BOLD, 22));
        dalej.setBounds(200,150,200,25);
        add(dalej);
        dalej.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==dalej)
        {
            try
            {
                Path path=Paths.get("plik.dat");
                if(Files.exists(path) && !trudnosc.isSelectionEmpty() && !imie.getText().trim().equals(""))
                {
                            RandomAccessFile plik = new RandomAccessFile("plik.dat", "rw");
                            Date Data=new Date();
                            SimpleDateFormat aktualna_Data = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                            plik.seek(0);
                            int i=0,c=0;
                            String b="";
                            while(plik.length()>plik.getFilePointer())
                            {
                                i=plik.readInt();
                                b=plik.readUTF();
                                c=plik.readInt();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readInt();
                            }
                            plik.writeInt(i+1);
                            plik.writeUTF(imie.getText());
                            if(imie.getText().equals(b))
                            {
                                plik.writeInt(c+1);
                            }
                            else
                            {
                                plik.writeInt(1);
                            }
                            plik.writeUTF(a);
                            plik.writeUTF(aktualna_Data.format(Data));
                            plik.writeUTF("W trakcie");
                            plik.writeUTF("-");
                            plik.writeInt(0);
                            plik.close();
                            dispose();
                            new Glowny_Ekran(a,0);
                }
                if(!trudnosc.isSelectionEmpty() && !imie.getText().trim().equals("") && Files.notExists(path))
                {
                    Date Data = new Date();
                    SimpleDateFormat aktualna_Data = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    File RAF = new File("plik.dat");
                    RandomAccessFile plik = new RandomAccessFile(RAF, "rw");
                    plik.writeInt(1);
                    plik.writeUTF(imie.getText());
                    plik.writeInt(1);
                    plik.writeUTF(a);
                    plik.writeUTF(aktualna_Data.format(Data));
                    plik.writeUTF("W trakcie");
                    plik.writeUTF("-");
                    plik.writeInt(0);
                    plik.close();
                    dispose();
                    new Glowny_Ekran(a,0);
                }
            }
            catch(IOException y)
            {
                System.out.println("Błąd");
            }

        }
    }
}
