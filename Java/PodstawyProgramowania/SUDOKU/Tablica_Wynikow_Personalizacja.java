package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Tablica_Wynikow_Personalizacja extends JFrame implements ActionListener
{
    public Tablica_Wynikow_Personalizacja (String t,long []c,String []v,String []P,int f) {
        int truskawka = 0;
        setTitle("Twoja Tablica Wyników");
        setSize(getMaximumSize());
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        try {
            RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
            JLabel[] wqr = new JLabel[f * 8];
            JPanel[] qwr = new JPanel[f];
                for (int i = 0; i < v.length; i++)
                {
                    if (t.equals(v[i]) && P[i].equals("Zakończona") && i>0)
                    {
                        plik.seek(c[i - 1]);
                        wqr[truskawka] = new JLabel(String.valueOf(plik.readInt()));
                        wqr[truskawka + 1] = new JLabel(plik.readUTF());
                        wqr[truskawka + 2] = new JLabel(String.valueOf(plik.readInt()));
                        wqr[truskawka + 3] = new JLabel(plik.readUTF());
                        wqr[truskawka + 4] = new JLabel(plik.readUTF());
                        wqr[truskawka + 5] = new JLabel(plik.readUTF());
                        wqr[truskawka + 6] = new JLabel(plik.readUTF());
                        wqr[truskawka + 7] = new JLabel(String.valueOf(plik.readInt()));
                        wqr[truskawka].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 1].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 2].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 3].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 4].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 5].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 6].setFont(new Font("Arial", Font.BOLD, 22));
                        wqr[truskawka + 7].setFont(new Font("Arial", Font.BOLD, 22));
                        qwr[truskawka] = new JPanel();
                        qwr[truskawka].add(wqr[truskawka]);
                        qwr[truskawka].add(wqr[truskawka + 1]);
                        qwr[truskawka].add(wqr[truskawka + 2]);
                        qwr[truskawka].add(wqr[truskawka + 3]);
                        qwr[truskawka].add(wqr[truskawka + 4]);
                        qwr[truskawka].add(wqr[truskawka + 5]);
                        qwr[truskawka].add(wqr[truskawka + 6]);
                        qwr[truskawka].add(wqr[truskawka + 7]);
                        qwr[truskawka].setLayout(new FlowLayout(FlowLayout.LEFT, 100, 20));
                        add(qwr[truskawka]);
                        truskawka++;
                    }
                    if(i==0)
                    {
                        plik.seek(0);
                        if (t.equals(v[0]) && P[0].equals("Zakończona")) {
                            JLabel ID = new JLabel(String.valueOf(plik.readInt()));
                            JLabel Imie = new JLabel(plik.readUTF());
                            JLabel ImieID = new JLabel(String.valueOf(plik.readInt()));
                            JLabel Difficulty = new JLabel(plik.readUTF());
                            JLabel Start_Date = new JLabel(plik.readUTF());
                            JLabel Status = new JLabel(plik.readUTF());
                            JLabel End_Date = new JLabel(plik.readUTF());
                            JLabel Time = new JLabel(String.valueOf(plik.readInt()));
                            ID.setFont(new Font("Arial", Font.BOLD, 22));
                            Imie.setFont(new Font("Arial", Font.BOLD, 22));
                            ImieID.setFont(new Font("Arial", Font.BOLD, 22));
                            Difficulty.setFont(new Font("Arial", Font.BOLD, 22));
                            Start_Date.setFont(new Font("Arial", Font.BOLD, 22));
                            Status.setFont(new Font("Arial", Font.BOLD, 22));
                            End_Date.setFont(new Font("Arial", Font.BOLD, 22));
                            Time.setFont(new Font("Arial", Font.BOLD, 22));
                            JPanel panel1 = new JPanel();
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
                }
                }
                plik.close();
        }
        catch (FileNotFoundException o) {
            System.out.print("Błąd");
        } catch (IOException i) {
            System.out.print("Błąd2");
        }
        JButton button = new JButton("MENU");
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.addActionListener(this);
        add(button);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
        new Menu();
    }
}
