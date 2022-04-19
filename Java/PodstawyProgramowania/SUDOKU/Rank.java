package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Rank extends JFrame implements ActionListener
{
    Path path=Paths.get("plik.dat");
    JButton ID,Imie,ImieID,Difficulty,Start_Date,Status,End_Date,Time,Return;
    int dzwignia=0;
    JPanel []wypis;
    JLabel [] zawartosc;
    public Rank ()
    {
        setSize(getMaximumSize());
        setTitle("Ranking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ID=new JButton("ID");
        ID.addActionListener(this);
        ID.setFont(new Font("Arial", Font.BOLD, 22));
        Imie=new JButton("IMIE");
        Imie.addActionListener(this);
        Imie.setFont(new Font("Arial", Font.BOLD, 22));
        ImieID=new JButton("IMIEID");
        ImieID.addActionListener(this);
        ImieID.setFont(new Font("Arial", Font.BOLD, 22));
        Difficulty=new JButton("DIFFICULTY");
        Difficulty.addActionListener(this);
        Difficulty.setFont(new Font("Arial", Font.BOLD, 22));
        Start_Date=new JButton("START DATE");
        Start_Date.addActionListener(this);
        Start_Date.setFont(new Font("Arial", Font.BOLD, 22));
        Status=new JButton("STATUS");
        Status.addActionListener(this);
        Status.setFont(new Font("Arial", Font.BOLD, 22));
        End_Date=new JButton("END DATE");
        End_Date.addActionListener(this);
        End_Date.setFont(new Font("Arial", Font.BOLD, 22));
        Time=new JButton("TIME");
        Time.addActionListener(this);
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
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT,105,20));
        add(panel1);
        if(Files.exists(path))
        {
            try
            {
                RandomAccessFile plik =new RandomAccessFile("plik.dat","r");
                plik.seek(0);
                int c=0;
                while(plik.length()>plik.getFilePointer())
                {
                    c=plik.readInt();
                    plik.readUTF();
                    plik.readInt();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readUTF();
                    plik.readInt();
                }
                zawartosc=new JLabel[c*8];
                wypis=new JPanel[c];
                plik.seek(0);
                int u=0,k=0;
                while(plik.length()>plik.getFilePointer())
                {
                    wypis[u]=new JPanel();
                    zawartosc[u+k]=new JLabel(String.valueOf(plik.readInt()));
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(plik.readUTF());
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(String.valueOf(plik.readInt()));
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(plik.readUTF());
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(plik.readUTF());
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(plik.readUTF());
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(plik.readUTF());
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    zawartosc[u+k]=new JLabel(String.valueOf(plik.readInt()));
                    zawartosc[u+k].setFont(new Font("Arial", Font.BOLD, 22));
                    wypis[u].add(zawartosc[u+k]);
                    k++;
                    wypis[u].setLayout(new FlowLayout(FlowLayout.LEFT,140,20));
                    add(wypis[u]);
                    k--;
                    u++;
                }
                plik.close();
                setLayout(new FlowLayout(FlowLayout.CENTER,4000,0));
            }
            catch(FileNotFoundException x)
            {
                System.out.print("Błąd");
            }
            catch(IOException q)
            {
                System.out.print("Błąd2");
            }
        }
        Return=new JButton("Powrót");
        Return.setFont(new Font("Arial", Font.BOLD, 22));
        Return.addActionListener(this);
        add(Return);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source=e.getSource();
        if(source==ID)
        {
            if(dzwignia==1)
            {
                try
                {
                    RandomAccessFile plik =new RandomAccessFile("plik.dat","r");
                    plik.seek(0);
                    int u=0,k=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                        k++;
                        zawartosc[u+k].setText(plik.readUTF());
                        k++;
                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                        k++;
                        zawartosc[u+k].setText(plik.readUTF());
                        k++;
                        zawartosc[u+k].setText(plik.readUTF());
                        k++;
                        zawartosc[u+k].setText(plik.readUTF());
                        k++;
                        zawartosc[u+k].setText(plik.readUTF());
                        k++;
                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                        u++;
                    }
                    plik.close();
                    setLayout(new FlowLayout(FlowLayout.CENTER,4000,0));
                }
                catch(FileNotFoundException x)
                {
                    System.out.print("Błąd");
                }
                catch(IOException q)
                {
                    System.out.print("Błąd2");
                }
                dzwignia=0;
            }
            else
                if(dzwignia==0)
            {
                try
                {
                    RandomAccessFile raw = new RandomAccessFile(String.valueOf(path), "r");
                    raw.seek(0);
                    int y=0;
                    while(raw.length()>raw.getFilePointer())
                    {
                        y=raw.readInt();
                        raw.readUTF();
                        raw.readInt();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readInt();
                    }
                    long []d=new long [y];
                    raw.seek(0);
                    y=0;
                    while(raw.length()>raw.getFilePointer())
                    {
                        raw.readInt();
                        raw.readUTF();
                        raw.readInt();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readUTF();
                        raw.readInt();
                        d[y]=raw.getFilePointer();
                        y++;
                    }
                    int w=0,k=0;
                    for(int t=d.length;t>0;t--)
                    {
                        if(t==1)
                        {
                           raw.seek(0);
                            zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                            k++;
                            zawartosc[w+k].setText(raw.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                            k++;
                            zawartosc[w+k].setText(raw.readUTF());
                            k++;
                            zawartosc[w+k].setText(raw.readUTF());
                            k++;
                            zawartosc[w+k].setText(raw.readUTF());
                            k++;
                            zawartosc[w+k].setText(raw.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                            w++;
                        }
                        else
                            {
                                raw.seek(d[t - 2]);
                                zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                                k++;
                                zawartosc[w+k].setText(raw.readUTF());
                                k++;
                                zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                                k++;
                                zawartosc[w+k].setText(raw.readUTF());
                                k++;
                                zawartosc[w+k].setText(raw.readUTF());
                                k++;
                                zawartosc[w+k].setText(raw.readUTF());
                                k++;
                                zawartosc[w+k].setText(raw.readUTF());
                                k++;
                                zawartosc[w+k].setText(String.valueOf(raw.readInt()));
                                w++;
                            }

                    }
                    raw.close();
                }
                catch(FileNotFoundException h)
                {
                    System.out.print("Błąd");
                }
                catch (IOException a)
                {
                    System.out.print("Błąd2");
                }
                dzwignia=1;
            }
        }
        if(source==Imie)
        {
            if(dzwignia==1)
            {
                try
                {
                    RandomAccessFile plik =new RandomAccessFile("plik.dat","r");
                    plik.seek(0);
                    int c=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        c=plik.readInt();
                        plik.readUTF();
                        plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                    }
                    long []g=new long[c];
                    String []a=new String[c];
                    int []p=new int[c];
                    plik.seek(0);
                    c=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        a[c]=plik.readUTF();
                        plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                        g[c]=plik.getFilePointer();
                        c++;
                    }
                    for(int j=0;j<a.length;j++)
                    {
                      for(int z=0;z<a[j].length();z++)
                      {
                          p[j]=p[j]+a[j].charAt(z);
                      }
                    }
                    int []reverse=new int [p.length];
                    for(int j=0;j<p.length;j++)
                    {
                            reverse[j]=p[j];
                    }
                    Arrays.sort(reverse);
                    String qwerty;
                    for(int z=0;z<reverse.length;z++)
                    {
                        c=0;
                        while (plik.length() > plik.getFilePointer())
                        {
                            plik.seek(0);
                            plik.readInt();
                            qwerty = plik.readUTF();
                            int suma = 0;
                            for (int b = 0; b < qwerty.length(); b++) {
                                suma = suma + qwerty.charAt(b);
                            }
                            if (suma==reverse[z] && c!=0)
                            {
                                plik.seek(g[c-1]);
                                int u=0,k=0;
                                while(plik.length()>plik.getFilePointer())
                                {
                                    zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                    k++;
                                    zawartosc[u+k].setText(plik.readUTF());
                                    k++;
                                    zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                    k++;
                                    zawartosc[u+k].setText(plik.readUTF());
                                    k++;
                                    zawartosc[u+k].setText(plik.readUTF());
                                    k++;
                                    zawartosc[u+k].setText(plik.readUTF());
                                    k++;
                                    zawartosc[u+k].setText(plik.readUTF());
                                    k++;
                                    zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                    u++;
                                }
                            }
                            else
                                if(suma==reverse[z] && c==0)
                                {
                                  plik.seek(0);
                                    int u=0,k=0;
                                    while(plik.length()>plik.getFilePointer())
                                    {
                                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                        k++;
                                        zawartosc[u+k].setText(plik.readUTF());
                                        k++;
                                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                        k++;
                                        zawartosc[u+k].setText(plik.readUTF());
                                        k++;
                                        zawartosc[u+k].setText(plik.readUTF());
                                        k++;
                                        zawartosc[u+k].setText(plik.readUTF());
                                        k++;
                                        zawartosc[u+k].setText(plik.readUTF());
                                        k++;
                                        zawartosc[u+k].setText(String.valueOf(plik.readInt()));
                                        u++;
                                    }
                                }
                            plik.readInt();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readInt();
                            c++;
                        }
                    }
                    plik.close();
                    setLayout(new FlowLayout(FlowLayout.CENTER,4000,0));
                }
                catch(FileNotFoundException x)
                {
                    System.out.print("Błąd");
                }
                catch(IOException q)
                {
                    q.printStackTrace();
                }
                dzwignia=0;
            }
            else
            if(dzwignia==0)
            {
                try
                {
                    RandomAccessFile plik =new RandomAccessFile("plik.dat","r");
                    plik.seek(0);
                    int c=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        c=plik.readInt();
                        plik.readUTF();
                        plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                    }
                    long []g=new long[c];
                    String []a=new String[c];
                    int []p=new int[c];
                    plik.seek(0);
                    c=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        a[c]=plik.readUTF();
                        plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                        g[c]=plik.getFilePointer();
                        c++;
                    }
                    for(int j=0;j<a.length;j++)
                    {
                        for(int z=0;z<a[j].length();z++)
                        {
                            p[j]=p[j]+a[j].charAt(z);
                        }
                    }
                    int []reverse=new int [p.length];
                    for(int j=1;j<=p.length;j++)
                    {
                            reverse[j-1]=p[p.length-j];
                    }
                    Arrays.sort(reverse);
                    int i = 0;
                    int z = reverse.length-1;
                    int tmp;
                    while (z > i)
                    {
                        tmp = reverse[z];
                        reverse[z] = reverse[i];
                        reverse[i] = tmp;
                        z--;
                        i++;
                    }
                    int y=0;
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        plik.readUTF();
                        plik.readInt();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readUTF();
                        plik.readInt();
                        g[y]=plik.getFilePointer();
                        y++;
                    }
                    int w=0,k=0;
                    for(int t=g.length;t>0;t--)
                    {
                        if(t==1)
                        {
                            plik.seek(0);
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            w++;
                        }
                        else
                        {
                            plik.seek(g[t - 2]);
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(plik.readUTF());
                            k++;
                            zawartosc[w+k].setText(String.valueOf(plik.readInt()));
                            w++;
                        }

                    }
                    plik.close();
                }
                catch(FileNotFoundException h)
                {
                    System.out.print("Błąd");
                }
                catch (IOException a)
                {
                    System.out.print("Błąd2");
                }
                dzwignia=1;
            }
        }
        if(source==ImieID)
        {

        }
        if(source==Difficulty)
        {

        }
        if(source==Start_Date)
        {

        }
        if(source==Status)
        {

        }
        if(source==End_Date)
        {

        }
        if(source==Time)
        {

        }
        if(source==Return)
        {
            dispose();
            new Menu();
        }
    }
}
