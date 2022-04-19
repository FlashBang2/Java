package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Wczytanie_Konkretnej_Gry extends JFrame implements ActionListener
{
    JTextField Selekcjoner;
    JLabel Error,opis;
    JButton Dalej;
    String help;
    public Wczytanie_Konkretnej_Gry(String a)
    {
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        setTitle("Wyszukiwarka");
        opis= new JLabel();
        add(opis);
        switch (a)
        {
            case "ID":
                {
                    opis.setText("Podaj interesujące Ciebie ID gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "Imie":
                {
                    opis.setText("Podaj interesujące Ciebie Imię gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "ImieID":
                {
                    opis.setText("Podaj interesujące Ciebie Imię gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "Difficulty":
                {
                    opis.setText("Podaj interesujące Ciebie Poziom trudności gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "Start Date":
                {
                    opis.setText("Podaj datę rozpoczęcia gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "Status":
                {
                    opis.setText("Podaj status gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "End Date":
                {
                    opis.setText("Podaj datę zakończenia gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
            case "Time":
                {
                    opis.setText("Podaj czas trwania gry");
                    opis.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
        }
        Selekcjoner = new JTextField(10);
        Selekcjoner.setFont(new Font("Arial", Font.BOLD, 22));
        add(Selekcjoner);
        Dalej = new JButton("DALEJ");
        Dalej.setFont(new Font("Arial", Font.BOLD, 22));
        Dalej.addActionListener(this);
        add(Dalej);
        Error = new JLabel();
        add(Error);
        help = a;

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (help)
        {
            case "ID":
                {
                if (!Selekcjoner.getText().trim().equals(""))
                {
                    int j = 0;
                    for (int i = 0; i < Selekcjoner.getText().length(); i++)
                    {
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9')
                        {
                            j++;
                        }

                    }
                    if (j == Selekcjoner.getText().length())
                    {
                        if (Selekcjoner.getText().equals("1"))
                        {
                            dispose();
                            new Specify_Result();
                            break;
                        }
                        if (!Selekcjoner.getText().equals("1"))
                        {
                            try
                            {
                                int o = 0;
                                RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                plik.seek(0);
                                while (plik.length() > plik.getFilePointer())
                                {
                                    o = plik.readInt();
                                    plik.readUTF();
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readInt();
                                }
                                int[] k = new int[o];
                                long[] q = new long[o];
                                plik.seek(0);
                                int x = 0;
                                while (plik.length() > plik.getFilePointer())
                                {
                                    k[x] = plik.readInt();
                                    plik.readUTF();
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readInt();
                                    q[x] = plik.getFilePointer();
                                    x++;
                                }
                                for (int m = 0; m < k.length; m++) {
                                    if (k[m] == Integer.parseInt(Selekcjoner.getText()))
                                    {
                                        int finder = Integer.parseInt(Selekcjoner.getText());
                                        plik.close();
                                        dispose();
                                        new Result(q,finder);
                                        break;
                                    }
                                    else
                                        if (k[m] != Integer.parseInt(Selekcjoner.getText()))
                                    {
                                        Error.setText("GRA O PODANYM INDEKSIE NIE ISTNIEJE");
                                        Error.setForeground(Color.RED);
                                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                                        break;
                                    }
                                }
                            } catch (FileNotFoundException x) {
                                System.out.print("Błąd");
                            } catch (IOException y) {
                                System.out.print("Błąd2");
                            }
                        } else
                            if (j != Selekcjoner.getText().length())
                            {
                            Error.setText("POLE NIE MOŻE ZAWIERAĆ ZNAKÓW INNYCH NIŻ 0 DO 9");
                            Error.setForeground(Color.RED);
                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                            break;
                            }
                    } else
                        if (Selekcjoner.getText().trim().equals("")) {
                        Error.setText("WYPEŁNIJ POLE");
                        Error.setForeground(Color.RED);
                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                        break;
                    }
                }
                break;
            }
            case "Imie": {
                if (!Selekcjoner.getText().trim().equals(""))
                {
                    try
                    {
                        int o=0;
                        String ty="";
                        RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                        plik.seek(0);
                        while (plik.length() > plik.getFilePointer())
                        {
                            o = plik.readInt();
                            ty=plik.readUTF();
                            plik.readInt();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readInt();
                            if(o==1)
                            {
                                if(ty.equals(Selekcjoner.getText()))
                                {
                                    plik.close();
                                    dispose();
                                    new Specify_Result();
                                    break;
                                }
                            }
                            else
                                if(!ty.equals(Selekcjoner.getText()))
                                {
                                    Error.setText("BRAK PODANEGO IMIENIA W PLIKU");
                                    Error.setForeground(Color.RED);
                                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                                    break;
                                }
                        }
                        if(o!=1) {
                            long[] u = new long[o];
                            String[] d = new String[o];
                            plik.seek(0);
                            int x = 0;
                            while (plik.length() > plik.getFilePointer()) {
                                plik.readInt();
                                d[x] = plik.readUTF();
                                plik.readInt();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readInt();
                                u[x] = plik.getFilePointer();
                                x++;
                            }
                            for (int kek = 0; kek < d.length; kek++)
                            {
                                if (d[kek].equals(Selekcjoner.getText()))
                                {
                                    plik.close();
                                    int finder=kek;
                                    dispose();
                                    new Result(u,finder);
                                    break;
                                }
                            }
                        }
                    }
                    catch(FileNotFoundException o)
                    {
                     System.out.print("Błąd");
                    }
                    catch(IOException q)
                    {
                        System.out.print("Błąd2");
                    }
                }
                else if (Selekcjoner.getText().trim().equals(""))
                {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
                break;
            }
            case "ImieID": {
                if (!Selekcjoner.getText().trim().equals(""))
                {
                    try
                    {
                        int o=0;
                        String ty="";
                        RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                        plik.seek(0);
                        while (plik.length() > plik.getFilePointer())
                        {
                            o = plik.readInt();
                            ty = plik.readUTF();
                            plik.readInt();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readInt();
                        }
                            if(o==1)
                            {
                                if(ty.equals(Selekcjoner.getText()))
                                {
                                    plik.close();
                                    dispose();
                                    new Specify_Result();
                                    break;
                                }
                            }
                            else
                            if(!ty.equals(Selekcjoner.getText()))
                            {
                                Error.setText("BRAK PODANEGO IMIENIA W PLIKU");
                                Error.setForeground(Color.RED);
                                Error.setFont(new Font("Arial", Font.BOLD, 22));
                                break;
                            }
                        if(o!=1)
                        {
                            long[] u = new long[o];
                            String[] d = new String[o];
                            plik.seek(0);
                            int x = 0;
                            while (plik.length() > plik.getFilePointer())
                            {
                                plik.readInt();
                                d[x] = plik.readUTF();
                                plik.readInt();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readInt();
                                u[x] = plik.getFilePointer();
                                x++;
                            }
                            for (int kek = 0; kek < d.length; kek++)
                            {
                                if (d[kek].equals(Selekcjoner.getText()))
                                {
                                    int finder=kek;
                                    plik.close();
                                    dispose();
                                    new Additional_Info_About_ID(u,finder);
                                    break;
                                }
                            }
                        }
                    }
                    catch(FileNotFoundException o)
                    {
                        System.out.print("Błąd");
                    }
                    catch(IOException q)
                    {
                        System.out.print("Błąd2");
                    }
                } else if (Selekcjoner.getText().trim().equals(""))
                {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
                break;
            }
            case "Difficulty": {
                if (!Selekcjoner.getText().trim().equals("")) {
                    switch (Selekcjoner.getText().toLowerCase()) {
                        case "easy":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE ROZEGRANO GRY NA TYM POZIOMIE TRUDNOŚCI");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                        case "normal":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE ROZEGRANO GRY NA TYM POZIOMIE TRUDNOŚCI");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                        case "hard":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE ROZEGRANO GRY NA TYM POZIOMIE TRUDNOŚCI");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                        default: {
                            Error.setText("PODANY POZIOM TRUDNOŚCI NIE ISTNIEJE");
                            Error.setForeground(Color.RED);
                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                            break;

                        }
                    }
                } else if (Selekcjoner.getText().trim().equals("")) {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
                break;
            }
            case "Start Date": {
                if (!Selekcjoner.getText().trim().equals("")) {
                    int j = 0;
                    for (int i = 0; i < Selekcjoner.getText().length(); i++)
                    {
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && i < 4) {
                            j++;
                        }
                        if ((Selekcjoner.getText().charAt(i) == '-' || Selekcjoner.getText().charAt(i) == '/') && i == 4) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 7 && i>4)) {
                            j++;
                        }
                        if ((Selekcjoner.getText().charAt(i) == '-' || Selekcjoner.getText().charAt(i) == '/') && i == 7) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 10 && i>7)) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) == ' ' && i == 10) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 13&& i>10)){
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) == ':' && i == 13) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 16 && i>13)) {
                            j++;
                        }
                    }
                    if (j == Selekcjoner.getText().length())
                    {
                        try
                        {
                            int o=0;
                            String ty="";
                            RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                            plik.seek(0);
                            while (plik.length() > plik.getFilePointer())
                            {
                                o=plik.readInt();
                                plik.readUTF();
                                plik.readInt();
                                plik.readUTF();
                                ty=plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readInt();
                            }
                            if(o==1)
                            {
                                if(ty.equals(Selekcjoner.getText()))
                                {
                                    plik.close();
                                    dispose();
                                    new Specify_Result();
                                    break;
                                }
                                else
                                if(!ty.equals(Selekcjoner.getText()))
                                {
                                    Error.setText("W PODANYM TERMINIE NIE ROZEGRANO GRY");
                                    Error.setForeground(Color.RED);
                                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                                    break;
                                }
                            }
                            if(o!=1) {
                                long[] u = new long[o];
                                String[] d = new String[o];
                                plik.seek(0);
                                int x = 0;
                                while (plik.length() > plik.getFilePointer())
                                {
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readInt();
                                    plik.readUTF();
                                    d[x]=plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readInt();
                                    u[x] = plik.getFilePointer();
                                    x++;
                                }
                                for (int kek = 0; kek < d.length; kek++)
                                {
                                    if (d[kek].equals(Selekcjoner.getText()))
                                    {
                                        int finder=kek;
                                        plik.close();
                                        dispose();
                                        new Result(u,finder);
                                        break;
                                    }
                                }
                            }
                        }
                        catch(FileNotFoundException o)
                        {
                            System.out.print("Błąd");
                        }
                        catch(IOException q)
                        {
                            System.out.print("Błąd2");
                        }
                    }
                    else if (j != Selekcjoner.getText().length()) {
                        Error.setText("NIEPOPRAWNY FORMAT DATY");
                        Error.setForeground(Color.RED);
                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                        break;
                    }
                } else if (Selekcjoner.getText().trim().equals("")) {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
                break;
            }
            case "Status": {
                if (!Selekcjoner.getText().trim().equals("")) {
                    switch (Selekcjoner.getText().toLowerCase()) {
                        case "w trakcie":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        plik.readUTF();
                                        plik.readUTF();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE MA GRY O PODANYM STATUSIE");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readUTF();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                        case "zakonczona":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        plik.readUTF();
                                        plik.readUTF();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE MA GRY O PODANYM STATUSIE");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readUTF();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                        case "zakończona":
                            {
                                try
                                {
                                    int o=0;
                                    String ty="";
                                    RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                                    plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        o=plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        plik.readUTF();
                                        plik.readUTF();
                                        ty=plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                    }
                                    if(o==1)
                                    {
                                        if(ty.equals(Selekcjoner.getText()))
                                        {
                                            plik.close();
                                            dispose();
                                            new Specify_Result();
                                            break;
                                        }
                                        else
                                        if(!ty.equals(Selekcjoner.getText()))
                                        {
                                            Error.setText("NIE MA GRY O PODANYM STATUSIE");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                    if(o!=1) {
                                        long[] u = new long[o];
                                        String[] d = new String[o];
                                        plik.seek(0);
                                        int x = 0;
                                        while (plik.length() > plik.getFilePointer())
                                        {
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readInt();
                                            plik.readUTF();
                                            plik.readUTF();
                                            d[x]=plik.readUTF();
                                            plik.readUTF();
                                            plik.readInt();
                                            u[x] = plik.getFilePointer();
                                            x++;
                                        }
                                        for (int kek = 0; kek < d.length; kek++)
                                        {
                                            if (d[kek].equals(Selekcjoner.getText()))
                                            {
                                                int finder=kek;
                                                plik.close();
                                                dispose();
                                                new Result(u,finder);
                                                break;
                                            }
                                        }
                                    }
                                }
                                catch(FileNotFoundException o)
                                {
                                    System.out.print("Błąd");
                                }
                                catch(IOException q)
                                {
                                    System.out.print("Błąd2");
                                }
                            }
                    }
                } else if (Selekcjoner.getText().trim().equals("")) {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                }
                break;
            }
            case "End Date": {
                if (!Selekcjoner.getText().trim().equals("")) {
                    int j = 0;
                    for (int i = 0; i < Selekcjoner.getText().length(); i++) {
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && i < 4) {
                            j++;
                        }
                        if ((Selekcjoner.getText().charAt(i) == '-' || Selekcjoner.getText().charAt(i) == '/') && i == 4) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 7 && i>4)) {
                            j++;
                        }
                        if ((Selekcjoner.getText().charAt(i) == '-' || Selekcjoner.getText().charAt(i) == '/') && i == 7) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 10 && i>7)) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) == ' ' && i == 10) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 13 && i>10)) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) == ':' && i == 13) {
                            j++;
                        }
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9' && (i < 16 && i>13)) {
                            j++;
                        }
                    }
                    if (j == Selekcjoner.getText().length())
                    {
                        try
                        {
                            int o=0;
                            String ty="";
                            RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                            plik.seek(0);
                            while (plik.length() > plik.getFilePointer())
                            {
                                o=plik.readInt();
                                plik.readUTF();
                                plik.readInt();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                ty=plik.readUTF();
                                plik.readInt();
                            }
                            if(o==1)
                            {
                                if(ty.equals(Selekcjoner.getText()))
                                {
                                    plik.close();
                                    dispose();
                                    new Specify_Result();
                                    break;
                                }
                                else
                                if(!ty.equals(Selekcjoner.getText()))
                                {
                                    Error.setText("W PODANYM TERMINIE NIE ZOSTAŁA ZAKOŃCZONA ŻADNA GRA");
                                    Error.setForeground(Color.RED);
                                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                                    break;
                                }
                            }
                            if(o!=1) {
                                long[] u = new long[o];
                                String[] d = new String[o];
                                plik.seek(0);
                                int x = 0;
                                while (plik.length() > plik.getFilePointer())
                                {
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    d[x]=plik.readUTF();
                                    plik.readInt();
                                    u[x] = plik.getFilePointer();
                                    x++;
                                }
                                for (int kek = 0; kek < d.length; kek++)
                                {
                                    if (d[kek].equals(Selekcjoner.getText()))
                                    {
                                        int finder=kek;
                                        plik.close();
                                        dispose();
                                        new Result(u,finder);
                                        break;
                                    }
                                }
                            }
                        }
                        catch(FileNotFoundException o)
                        {
                            System.out.print("Błąd");
                        }
                        catch(IOException q)
                        {
                            System.out.print("Błąd2");
                        }
                    }
                    else if (j != Selekcjoner.getText().length())
                    {
                        Error.setText("NIEPOPRAWNY FORMAT DATY");
                        Error.setForeground(Color.RED);
                        Error.setFont(new Font("Arial", Font.BOLD, 22));
                        break;

                    }
                } else if (Selekcjoner.getText().trim().equals(""))
                {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                    break;
                }
                break;
            }
            case "Time":
                {
                if (!Selekcjoner.getText().trim().equals("")) {
                    int j = 0;
                    for (int i = 0; i < Selekcjoner.getText().length(); i++) {
                        if (Selekcjoner.getText().charAt(i) >= '0' && Selekcjoner.getText().charAt(i) <= '9') {
                            j++;
                        }

                    }
                    if (j == Selekcjoner.getText().length())
                    {
                        try {
                            int o = 0, pop = 0;
                            RandomAccessFile plik = new RandomAccessFile("plik.dat", "r");
                            plik.seek(0);
                            while (plik.length() > plik.getFilePointer()) {
                                o = plik.readInt();
                                plik.readUTF();
                                plik.readInt();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                plik.readUTF();
                                pop = plik.readInt();
                            }
                            if (o == 1)
                            {
                                if(String.valueOf(pop).equals(Selekcjoner.getText()))
                                {
                                    dispose();
                                    new Specify_Result();
                                    break;
                                }
                            }
                            if (o != 1)
                            {
                                int[] k = new int[o];
                                long[] q = new long[o];
                                plik.seek(0);
                                int x = 0;
                                while (plik.length() > plik.getFilePointer()) {
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readInt();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    plik.readUTF();
                                    k[x] = plik.readInt();
                                    q[x] = plik.getFilePointer();
                                    x++;
                                }
                                for (int m = 0; m < k.length; m++)
                                {
                                    if (k[m] == Integer.parseInt(Selekcjoner.getText()))
                                    {
                                        int finder = Integer.parseInt(Selekcjoner.getText());
                                        plik.close();
                                        dispose();
                                        new Result(q, finder);
                                        break;
                                    }
                                        else if (k[m] != Integer.parseInt(Selekcjoner.getText()))
                                        {
                                            Error.setText("GRA O PORANYM CZASIE NIE ISTNIEJE");
                                            Error.setForeground(Color.RED);
                                            Error.setFont(new Font("Arial", Font.BOLD, 22));
                                            break;
                                        }
                                    }
                                }
                            }
                            catch(FileNotFoundException x){
                                System.out.print("Błąd");
                            } catch(IOException y){
                                System.out.print("Błąd2");
                            }

                    } else if (j != Selekcjoner.getText().length())
                    {
                        Error.setText("POLE NIE MOŻE ZAWIERAĆ ZNAKÓW INNYCH NIŻ 0 DO 9");
                        Error.setForeground(Color.RED);
                        Error.setFont(new Font("Arial", Font.BOLD, 22));

                    }
                    }
                else if (Selekcjoner.getText().trim().equals("")) {
                    Error.setText("WYPEŁNIJ POLE");
                    Error.setForeground(Color.RED);
                    Error.setFont(new Font("Arial", Font.BOLD, 22));
                }
            }
            break;
        }
    }
}
