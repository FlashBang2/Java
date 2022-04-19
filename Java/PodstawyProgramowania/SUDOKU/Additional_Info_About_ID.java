package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Additional_Info_About_ID extends JFrame implements ActionListener
{
    JTextField t;
    JButton Dalej;
    JLabel Error;
    long []y;
    int h;
    public Additional_Info_About_ID (long []a,int f)
    {
        y=new long[a.length];
        h=f;
        for(int i=0;i<y.length;i++)
        {
            y[i]=a[i];
        }
        JLabel opis=new JLabel("Podaj interesujące Ciebie ID");
        opis.setFont(new Font("Arial", Font.BOLD, 22));
        add(opis);
        t=new JTextField(10);
        t.setFont(new Font("Arial", Font.BOLD, 22));
        add(t);
        Dalej=new JButton("DALEJ");
        Dalej.setFont(new Font("Arial", Font.BOLD, 22));
        Dalej.addActionListener(this);
        add(Dalej);
        Error=new JLabel();
        add(Error);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setTitle("Wyszukiwarka");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!t.getText().trim().equals(""))
        {
            try
            {
                int j = 0;
                for (int i = 0; i < t.getText().length(); i++)
                {
                    if (t.getText().charAt(i) >= '0' && t.getText().charAt(i) <= '9') {
                        j++;
                    }

                }
                if (j == t.getText().length())
                {
                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                    plik.seek(0);
                    int []q=new int[y.length];
                    int c=0;
                    while (plik.length() > plik.getFilePointer())
                    {
                        plik.readInt();
                        plik.readUTF();
                        q[c]=plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                        c++;
                    }
                    if(c==h)
                    {
                        plik.close();
                        dispose();
                        new Result(y,c);
                    }
                }
                else
                    if (j!=t.getText().length())
                    {
                        Error.setText("POLE NIE MOŻE ZAWIERAĆ ZNAKÓW INNYCH NIŻ 0 DO 9");
                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                        Error.setForeground(Color.RED);
                    }
            }
            catch (FileNotFoundException q)
            {
               System.out.print("Błąd");
            }
            catch (IOException ex)
            {
                System.out.print("Błąd2");
            }
        }
        else
            if(t.getText().trim().equals(""))
            {
                Error.setText("WYPEŁNIJ POLE");
                Error.setForeground(Color.RED);
                Error.setFont(new Font("Arial", Font.BOLD, 22));
            }
    }
}
