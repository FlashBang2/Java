package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
public class Lista_Zapisanych_Gier extends JFrame implements ActionListener
{

    public Lista_Zapisanych_Gier(Path a,Path b)
    {
        int i=0,z=0;
        int[][] tabel=new int[9][9];
        setSize(600,600);
        setVisible(true);
        setTitle("Lista Zapisanych Gier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {

                RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                RandomAccessFile plik2 = new RandomAccessFile("plik2.dat", "r");
                plik.seek(0);
                plik2.seek(0);
                while (plik2.length() > plik2.getFilePointer())
                {
                    z = plik2.readInt();
                    for (int q = 0; q < tabel.length; q++) {
                        for (int w = 0; w < tabel[q].length; w++) {
                            plik2.read();
                        }
                    }
                        while (plik.length() > plik.getFilePointer())
                        {
                            i = plik.readInt();
                            plik.readUTF();
                            plik.readInt();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readInt();
                        }
                            System.out.println(z + " " + i);
                                JLabel[] o = new JLabel[(i) * 8];
                                JButton[] u = new JButton[(i) * 2];
                                JPanel[] y = new JPanel[(i)];
                                setLayout(new GridLayout(i, 1));
                                plik.seek(0);
                                for (int j = 0; j < i; j++) {
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        y[j] = new JPanel();
                                        o[j] = new JLabel(String.valueOf(plik.readInt()));
                                        o[j].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j]);
                                        o[j + 1] = new JLabel(plik.readUTF());
                                        o[j + 1].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 1]);
                                        o[j + 2] = new JLabel(String.valueOf(plik.readInt()));
                                        o[j + 2].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 2]);
                                        o[j + 3] = new JLabel(plik.readUTF());
                                        o[j + 3].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 3]);
                                        o[j + 4] = new JLabel(plik.readUTF());
                                        o[j + 4].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 4]);
                                        o[j + 5] = new JLabel(plik.readUTF());
                                        o[j + 5].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 5]);
                                        o[j + 6] = new JLabel(plik.readUTF());
                                        o[j + 6].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 6]);
                                        o[j + 7] = new JLabel(String.valueOf(plik.readInt()));
                                        o[j + 7].setFont(new Font("Arial", Font.BOLD, 22));
                                        y[j].add(o[j + 7]);
                                        u[j] = new JButton("Wczytaj");
                                        u[j].setFont(new Font("Arial", Font.BOLD, 22));
                                        u[j].addActionListener(this);
                                        y[j].add(u[j]);
                                        u[j + 1] = new JButton("Usuń");
                                        u[j + 1].setFont(new Font("Arial", Font.BOLD, 22));
                                        u[j + 1].addActionListener(this);
                                        y[j].add(u[j + 1]);
                                        add(y[j]);
                                    }
                                }

                            }
                }
            catch(FileNotFoundException c)
            {
                System.out.print("Błąd");
            }
            catch(IOException d)
            {
                System.out.print("Błąd2");
            }
        }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object j=e.getSource();

    }
    }
