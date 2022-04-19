package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Import_Text extends JFrame implements ActionListener
{
    JTextField Sciezka;
    JButton Dalej,button2;
    JPanel panel=new JPanel();
    JLabel Error;
    public Import_Text ()
    {
        setSize(600,600);
        setTitle("Dodaj Grę");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER,4000,20));
        JLabel opis=new JLabel("Podaj ścieżkę do pliku tekstowego");
        opis.setFont(new Font("Arial", Font.BOLD, 22));
        add(opis);
        Sciezka = new JTextField(10);
        Sciezka.setFont(new Font("Arial", Font.BOLD, 22));
        add(Sciezka);
        Dalej = new JButton("DALEJ");
        Dalej.addActionListener(this);
        Dalej.setFont(new Font("Arial", Font.BOLD, 22));
        button2=new JButton("MENU");
        button2.setFont(new Font("Arial", Font.BOLD, 22));
        button2.addActionListener(this);
        panel.add(Dalej);
        panel.add(button2);
        add(panel);
        Error = new JLabel("");
        add(Error);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object button =e.getSource();
        if(button==button2)
        {
            dispose();
            new Menu();
        }
       if( button==Dalej && !Sciezka.getText().trim().equals(""))
       {
           Path path=Paths.get(Sciezka.getText());
           Path path2=Paths.get("plik.dat");
           Path path3=Paths.get("plik2.dat");
           if(Files.exists(path) && !Sciezka.getText().equals(String.valueOf(path2)) && !Sciezka.getText().equals(String.valueOf(path3)))
           {
               BufferedReader dis=null;
                try
                {
                    dis=new BufferedReader(new FileReader(String.valueOf(path)));
                    String line;
                    StringBuffer sb=new StringBuffer();
                    int h=0;
                    dis.mark(1);
                    while((line =dis.readLine()) != null)
                    {
                        h++;
                    }
                    String []binarny_line=new String[h];
                    line=null;
                    h=0;
                    dis.close();
                    dis=new BufferedReader(new FileReader(String.valueOf(path)));
                    while((line =dis.readLine()) != null)
                    {
                        binarny_line[h]=line.trim();
                        h++;
                    }
                    for(int i=0;i<binarny_line.length;i++)
                    {
                        sb.append((binarny_line[i]+" "));
                    }
                    String str =sb.toString();
                    String []array_binarny_line=str.split(" ");
                    if(Files.exists(path2))
                    {
                        Error.setText("PLIK JUŻ ISTNIEJE");
                        Error.setForeground(Color.RED);
                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                    }
                    else
                        if(!Files.exists(path2))
                        {
                            File n_plik=new File(String.valueOf(path2));
                            RandomAccessFile plik=new RandomAccessFile(String.valueOf(path2),"rw");
                            plik.seek(0);
                            int d=0;
                            for(int i=0;i<array_binarny_line.length/10;i++)
                            {
                                StringBuffer ow=new StringBuffer();
                                if(array_binarny_line[i+d].equals("1"))
                                {
                                  array_binarny_line[i+d]="1";
                                  plik.writeInt(Integer.parseInt(array_binarny_line[i+d]));
                                    d++;
                                }
                                else if(!array_binarny_line[d].equals("1"))
                                {
                                    plik.writeInt(Integer.parseInt(array_binarny_line[i+d]));
                                    d++;
                                }
                                plik.writeUTF(array_binarny_line[i+d]);
                                d++;
                                if(array_binarny_line[i+d].equals("1"))
                                {
                                  array_binarny_line[i+d]="1";
                                  plik.writeInt(Integer.parseInt(array_binarny_line[i+d]));
                                    d++;
                                }
                                else if(!array_binarny_line[i+d].equals("1"))
                                {
                                    plik.writeInt(Integer.parseInt(array_binarny_line[i+d]));
                                    d++;
                                }
                                plik.writeUTF(array_binarny_line[i+d]);
                                d++;
                                ow.append(array_binarny_line[i+d]+" ");
                                d++;
                                ow.append(array_binarny_line[i+d]);
                                String date_helper=ow.toString();
                                plik.writeUTF(date_helper);
                                d++;
                                plik.writeUTF(array_binarny_line[i+d]);
                                d++;
                                ow=new StringBuffer();
                                ow.append(array_binarny_line[i+d]+" ");
                                d++;
                                ow.append(array_binarny_line[i+d]);
                                String date_helper2=ow.toString();
                                plik.writeUTF(date_helper2);
                                d++;
                                plik.writeInt(Integer.parseInt(array_binarny_line[i+d]));
                                d++;
                                d--;
                            }
                            plik.close();
                        }
                }
                catch(FileNotFoundException f)
                {
                    System.out.print("Błąd");
                }
                catch(IOException w)
                {
                    System.out.print("Błąd2");
                }

           }
           else
               if (Sciezka.getText().equals(String.valueOf(path2)))
                {
                    Error.setText("PODANY PLIK JEST JUŻ WCZYTANY PRZEZ GRĘ PODAJ INNY PLIK");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                }
               if(Sciezka.getText().equals(String.valueOf(path3)))
               {
                   Error.setText("TEN PLIK PRZECHOWUJE MACIERZE TABLIC I JEST JUŻ CZYTANY PRZEZ GRĘ");
                   Error.setForeground(Color.RED);
                   Error.setFont(new Font("Arial", Font.BOLD, 22));
               }
               if(!Files.exists(path))
               {
                   Error.setText("PODANY PLIK NIE ISTNIEJE LUB PODANA ŚCIEŻKA JEST BŁĘDNA");
                   Error.setForeground(Color.RED);
                   Error.setFont(new Font("Arial", Font.BOLD, 22));
               }
       }
    }
}
