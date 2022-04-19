package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Tablica_Wynikow extends JFrame implements ActionListener
{
    JTextField imie;
    JButton button,powrot;
    JLabel Error;
    public Tablica_Wynikow()
    {
        setSize(600,600);
        setTitle("Lista Wynikow");
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JLabel opis=new JLabel("Podaj swoje Imie  ");
        JLabel opis2=new JLabel("w celu wyświetlenia");
        JLabel opis3=new JLabel("spersonalizowanej tablicy wyników");
        opis.setFont(new Font("Arial", Font.BOLD, 22));
        opis2.setFont(new Font("Arial", Font.BOLD, 22));
        opis3.setFont(new Font("Arial", Font.BOLD, 22));
        add(opis);
        add(opis2);
        add(opis3);
        imie=new JTextField(10);
        imie.setFont(new Font("Arial", Font.BOLD, 22));
        add(imie);
        button=new JButton("DALEJ");
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.addActionListener(this);
        powrot=new JButton("MENU");
        powrot.setFont(new Font("Arial", Font.BOLD, 22));
        powrot.addActionListener(this);
        JPanel panel=new JPanel();
        panel.add(button);
        panel.add(powrot);
        add(panel);
        Error=new JLabel();
        add(Error);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object przycisk = e.getSource();
        if(przycisk==powrot)
        {
            dispose();
            new Menu();
        }
        if(!imie.getText().trim().equals("") && przycisk==button)
        {
            try
            {
                int j=0,l=0,f=0;
                RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                plik.seek(0);
                while(plik.length()>plik.getFilePointer())
                {
                    j=plik.readInt();
                    plik.readUTF();
                    plik.readInt();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readInt();
                }
                long []c=new long[j];
                String []a=new String[j];
                String []b=new String[j];
                plik.seek(0);
                while(plik.length()>plik.getFilePointer())
                {
                    plik.readInt();
                    System.out.print(l);
                    a[l]=plik.readUTF();
                    plik.readInt();
                    plik.readUTF();
                    plik.readUTF();
                    b[l]=plik.readUTF();
                    plik.readUTF();
                    plik.readInt();
                    c[l]=plik.getFilePointer();
                    l++;
                }
                for(int r=0;r<a.length;r++)
                {
                    if(a[r].equals(imie.getText()) && b[r].equals("Zakończona"))
                    {
                        f++;
                    }
                    else
                        if(!a[r].equals(imie.getText()))
                         {
                             Error.setText("NIE MA GRY O PODANYM IMIENIU");
                             Error.setFont((new Font("Arial", Font.BOLD, 22)));
                             Error.setForeground(Color.RED);
                         }
                        if(b[r].equals("Zakończona"))
                        {
                            Error.setText("NIE UKOŃCZYŁEŚ GRY DOKOŃCZ GRĘ BY ZOBACZYĆ SWOJE WYNIKI");
                            Error.setFont((new Font("Arial", Font.BOLD, 22)));
                            Error.setForeground(Color.RED);
                        }
                }
                if(f>0)
                {
                    plik.close();
                    dispose();
                    new Tablica_Wynikow_Personalizacja(imie.getText(),c,a,b,f);
                }
            }
            catch (FileNotFoundException y)
            {
                System.out.print("Błąd");
            }
            catch (IOException EasterEgg)
            {
                System.out.print("Błąd2");
            }
        }
        else
            if(imie.getText().trim().equals(""))
             {
               Error.setText("WYPEŁNIJ POLE");
               Error.setForeground(Color.RED);
               Error.setFont(new Font("Arial", Font.BOLD, 22));
             }

    }
}
