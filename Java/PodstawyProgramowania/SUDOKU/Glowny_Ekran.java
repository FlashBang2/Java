package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
public class Glowny_Ekran extends JFrame implements ActionListener
{
    int seconds=0,c=0;
    JLabel show = new JLabel();
    Timer timer=new Timer();
    TimerTask seconds_passed=new TimerTask() {
        @Override
        public void run() {
            seconds++;
            show.setText(String.valueOf(seconds));
        }
    };
    JButton save,quit;
    JPanel Panel2= new JPanel();
    JPanel Panel1=new JPanel();
    JButton [][] Sudoku = new JButton [9][9];
    int[] wazne =new int[2];
    int [] [] Checker=new int[9][9];
    int[][] array = new int[9][9];
    int [][] loader=new int[9][9];
    int Popr=0,bledy=0,runner=0,saved=0;
    Path path =Paths.get("plik2.dat");
    private int [] findButton(Object c)
    {
        int[] pow = new int[2];
        for (int x = 0; x < Sudoku.length; x++) {
            for (int y = 0; y < Sudoku[0].length; y++) {
                if (c.equals(Sudoku[x][y]))
                {
                    pow[0]=x;
                    pow[1]=y;
                }
            }
        }
        return pow;
    }
    public Glowny_Ekran (String a, int dzwignia) {
        super("SUDOKU-" + a);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Solver Y = new Solver();
        Random los = new Random();
        setSize(600, 600);
        save=new JButton("Zapisz");
        save.addActionListener(this);
        save.setFont(new Font("Arial", Font.BOLD, 22));
        Panel2.add(save,BorderLayout.PAGE_START);
        quit=new JButton("Wyjście");
        quit.setFont(new Font("Arial", Font.BOLD, 22));
        quit.addActionListener(this);
        Panel2.add(quit,BorderLayout.CENTER);
        JLabel time =new JLabel("Twój czas ");
        time.setFont(new Font("Arial", Font.BOLD, 22));
        Panel2.add(time,BorderLayout.PAGE_END);
        Panel2.add(show,BorderLayout.PAGE_END);
        Panel1.setLayout(new GridLayout(9, 9));
        Panel2.setLayout(new BoxLayout(Panel2,BoxLayout.PAGE_AXIS));
        add(Panel1);
        add(Panel2,BorderLayout.LINE_END);
        int c, b, d, z = 0;
        setVisible(true);
            if(Files.exists(path) && dzwignia==1)
            {
                try
                {
                    RandomAccessFile plik = new RandomAccessFile("plik2.dat", "rw");
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        for(int i=0;i< array.length;i++)
                        {
                            for(int j=0;j<array[i].length;j++)
                            {
                                array[i][j]=plik.read();
                            }
                        }
                        for(int i=0;i<array.length;i++)
                        {
                            for(int j=0;j<array[i].length;j++)
                            {
                                loader[i][j]=array[i][j];
                            }
                        }
                    }

                }
                catch(FileNotFoundException x)
                {
                    System.out.print("Błąd");
                }
                catch(IOException w)
                {
                    System.out.print("Błąd2");
                }
            }
            if(!Files.exists(path) || dzwignia==0)
            {
                do
                    {
                    for(int i=0;i<array.length;i++)
                    {
                        for(int j=0;j<array[i].length;j++)
                        {
                            array[i][j]=0;
                        }
                    }
                for (int i = 0; i < 100; i++) {
                    c = los.nextInt(9);
                    b = los.nextInt(9);
                    d = los.nextInt(9) + 1;
                    for (int j = 0; j < 9; j++) {
                        if (array[c][j] == d || array[j][b] == d) {
                            z = 1;
                            break;
                        }
                        if (c % 3 == 0) {
                            if (array[c][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c + 1][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c + 2][j] == d) {
                                z = 1;
                                break;
                            }
                        }
                        if (c % 3 == 1) {
                            if (array[c - 1][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c + 1][j] == d) {
                                z = 1;
                                break;
                            }
                        }
                        if (c % 3 == 2) {
                            if (array[c - 2][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c - 1][j] == d) {
                                z = 1;
                                break;
                            }
                            if (array[c][j] == d) {
                                z = 1;
                                break;
                            }
                        }
                        if (b % 3 == 0) {
                            if (array[j][b] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b + 1] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b + 2] == d) {
                                z = 1;
                                break;
                            }
                        }
                        if (b % 3 == 1) {
                            if (array[j][b - 1] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b + 1] == d) {
                                z = 1;
                                break;
                            }
                        }
                        if (b % 3 == 2) {
                            if (array[j][b - 2] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b - 1] == d) {
                                z = 1;
                                break;
                            }
                            if (array[j][b] == d) {
                                z = 1;
                                break;
                            }
                        }
                    }
                    if (array[c][b] == 0 && z != 1) {
                        array[c][b] = d;
                    }
                    z = 0;
                }
            }
            while(!Y.solve(array));
            }
            if(dzwignia==1)
            {
                Y.solve(loader);
                for(int i=0; i<Checker.length;i++)
                {
                    for(int j=0;j<Checker[i].length;j++)
                    {
                        Checker[i][j]=loader[i][j];
                    }
                }
            }
        if(dzwignia==0)
        {
        for(int i=0; i<Checker.length;i++)
        {
            for(int j=0;j<Checker[i].length;j++)
            {
                Checker[i][j]=array[i][j];
            }
        }
            switch (a) {
                case "easy": {
                    for (int i = 0; i < 20; i++) {
                        c = los.nextInt(9);
                        b = los.nextInt(9);
                        if (array[c][b] != 0) {
                            array[c][b] = 0;
                        } else {
                            i--;
                        }
                    }
                    break;
                }
                case "normal": {
                    for (int i = 0; i < 30; i++) {
                        c = los.nextInt(9);
                        b = los.nextInt(9);
                        if (array[c][b] != 0) {
                            array[c][b] = 0;
                        } else {
                            i--;
                        }
                    }
                    break;
                }
                case "hard": {
                    for (int i = 0; i < 40; i++) {
                        c = los.nextInt(9);
                        b = los.nextInt(9);
                        if (array[c][b] != 0) {
                            array[c][b] = 0;
                        } else {
                            i--;
                        }
                    }
                    break;
                }
            }
        }
        if(dzwignia==1)
        {
            if(Files.exists(path))
            {
                try
                {
                    RandomAccessFile plik = new RandomAccessFile("plik2.dat", "rw");
                    while(plik.length()>plik.getFilePointer())
                    {
                        plik.readInt();
                        for(int i=0;i< array.length;i++)
                        {
                            for(int j=0;j<array[i].length;j++)
                            {
                                array[i][j]=plik.read();
                            }
                        }
                    }
                }
                catch(FileNotFoundException o)
                {
                    System.out.print("Błąd");
                }
                catch(IOException p)
                {
                    System.out.print("Błąd2");
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    Sudoku[i][j] = new JButton("");
                    Sudoku[i][j].setFont(new Font("Arial", Font.BOLD, 22));
                    Panel1.add(Sudoku[i][j]);
                    Sudoku[i][j].addActionListener(this);
                } else {
                    Sudoku[i][j] = new JButton(String.valueOf(array[i][j]));
                    Sudoku[i][j].setFont(new Font("Arial", Font.BOLD, 22));
                    Panel1.add(Sudoku[i][j]);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource().getClass();
        JMenuItem Opcja1, Opcja2, Opcja3, Opcja4, Opcja5, Opcja6, Opcja7, Opcja8, Opcja9;
        JPopupMenu choice = new JPopupMenu();
        Opcja1 = new JMenuItem("1");
        Opcja1.addActionListener(this);
        String poziom="",imie="";
        if (zrodlo == Sudoku[0][0].getClass())
        {

            JButton zrodlo2 = (JButton) e.getSource();
            String zrodlo3 =((JButton) e.getSource()).getActionCommand();
            if(zrodlo3=="Zapisz")
            {
                try {
                    Path path= Paths.get("plik2.dat");
                    if(!Files.exists(path))
                    {
                        File RAF = new File("plik2.dat");
                        RandomAccessFile plik = new RandomAccessFile("plik2.dat", "rw");
                        RandomAccessFile plik2 = new RandomAccessFile("plik.dat","r");
                        plik2.seek(0);
                        while(plik2.length()>plik2.getFilePointer())
                        {
                            saved=plik2.readInt();
                            plik2.readUTF();
                            plik2.readInt();
                            plik2.readUTF();
                            plik2.readUTF();
                            plik2.readUTF();
                            plik2.readUTF();
                            plik2.readInt();
                        }
                        plik2.close();
                        plik.writeInt(saved);
                        for(int i=0;i<array.length;i++)
                        {
                            for (int j=0;j<array[i].length;j++)
                            {
                                plik.write(array[i][j]);
                            }
                        }
                        plik.close();
                    }
                    if(Files.exists(path))
                    {
                        RandomAccessFile plik = new RandomAccessFile("plik.dat","r");
                        RandomAccessFile plik2 = new RandomAccessFile("plik2.dat","rw");
                        plik.seek(0);
                        while(plik.length()>plik.getFilePointer())
                        {
                            saved=plik.readInt();
                            plik.readUTF();
                            plik.readInt();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readUTF();
                            plik.readInt();
                        }
                        plik.close();
                        plik2.writeInt(saved);
                        for(int i=0;i<array.length;i++)
                        {
                            for (int j=0;j<array[i].length;j++)
                            {
                                plik2.write(array[i][j]);
                            }
                        }
                        plik2.close();
                    }
                }
                catch(FileNotFoundException x)
                {
                    System.out.print("Błąd");
                }
                catch (IOException a)
                {
                    System.out.print("Błąd2");
                }
            }
            if(zrodlo3=="Wyjście")
            {
                UIManager.put("OptionPane.noButtonText", "NIE");
                UIManager.put("OptionPane.yesButtonText", "TAK");
                final JOptionPane optionPane = new JOptionPane(
                        "Czy na pewno chcesz wyjść bez zapisywania?",
                        JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.YES_NO_OPTION);

                final JDialog dialog = new JDialog(this, "Wybierz", true);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent we)
                    {

                    }
                });
                optionPane.addPropertyChangeListener
                        (
                            new PropertyChangeListener()
                        {
                            public void propertyChange(PropertyChangeEvent e)
                            {
                                String prop = e.getPropertyName();
                                if (dialog.isVisible() && (e.getSource() == optionPane) && (prop.equals(JOptionPane.VALUE_PROPERTY)) && String.valueOf(e.getNewValue()).equals("1"))
                                {
                                        dialog.setVisible(false);
                                }
                                else if (dialog.isVisible() && (e.getSource() == optionPane) && (prop.equals(JOptionPane.VALUE_PROPERTY)) && !String.valueOf(e.getNewValue()).equals("1"))
                                {
                                    dispose();
                                    new Menu();
                                }
                            }
                        });
                dialog.pack();
                dialog.setVisible(true);
            }
            if(zrodlo3!="Zapisz" && zrodlo3!="Wyjście")
            {
                if(runner==0)
                {
                    timer.scheduleAtFixedRate(seconds_passed,1000,1000);
                }
                runner=1;
                wazne = findButton(zrodlo2);
                Opcja2 = new JMenuItem("2");
                Opcja2.addActionListener(this);
                Opcja3 = new JMenuItem("3");
                Opcja3.addActionListener(this);
                Opcja4 = new JMenuItem("4");
                Opcja4.addActionListener(this);
                Opcja5 = new JMenuItem("5");
                Opcja5.addActionListener(this);
                Opcja6 = new JMenuItem("6");
                Opcja6.addActionListener(this);
                Opcja7 = new JMenuItem("7");
                Opcja7.addActionListener(this);
                Opcja8 = new JMenuItem("8");
                Opcja8.addActionListener(this);
                Opcja9 = new JMenuItem("9");
                Opcja9.addActionListener(this);
                choice.add(Opcja1);
                choice.add(Opcja2);
                choice.add(Opcja3);
                choice.add(Opcja4);
                choice.add(Opcja5);
                choice.add(Opcja6);
                choice.add(Opcja7);
                choice.add(Opcja8);
                choice.add(Opcja9);
                choice.show(zrodlo2, zrodlo2.getWidth() / 2, zrodlo2.getHeight() / 2);
            }
        }
        if (zrodlo==Opcja1.getClass())
        {
            String zrodlo3=((JMenuItem) e.getSource()).getActionCommand();
            switch (zrodlo3)
            {
                case "1":
                {
                    if(Checker[wazne[0]][wazne[1]]==1)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("1");
                        array[wazne[0]][wazne[1]]=1;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("1");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                   break;
                }
                case "2":
                {
                    if(Checker[wazne[0]][wazne[1]]==2)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("2");
                        array[wazne[0]][wazne[1]]=2;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("2");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "3":
                {
                    if(Checker[wazne[0]][wazne[1]]==3)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("3");
                        array[wazne[0]][wazne[1]]=3;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("3");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "4":
                {
                    if(Checker[wazne[0]][wazne[1]]==4)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("4");
                        array[wazne[0]][wazne[1]]=4;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("4");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "5":
                {
                    if(Checker[wazne[0]][wazne[1]]==5)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("5");
                        array[wazne[0]][wazne[1]]=5;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("5");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "6":
                {
                    if(Checker[wazne[0]][wazne[1]]==6)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("6");
                        array[wazne[0]][wazne[1]]=6;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("6");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "7":
                {
                    if(Checker[wazne[0]][wazne[1]]==7)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("7");
                        array[wazne[0]][wazne[1]]=7;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("7");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "8":
                {
                    if(Checker[wazne[0]][wazne[1]]==8)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("8");
                        array[wazne[0]][wazne[1]]=8;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("8");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                case "9":
                {
                    if(Checker[wazne[0]][wazne[1]]==9)
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("9");
                        array[wazne[0]][wazne[1]]=9;
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.GREEN);
                        Sudoku[wazne[0]][wazne[1]].removeActionListener(this);
                    }
                    else
                    {
                        Sudoku[wazne[0]][wazne[1]].setText("9");
                        Sudoku[wazne[0]][wazne[1]].setForeground(Color.RED);
                        bledy++;
                    }
                    break;
                }
                default:
            }
            Popr=0;
            for(int i=0;i<Checker.length;i++)
            {
             for(int j=0;j<Checker[i].length;j++)
             {
                  if(array[i][j]==Checker[i][j])
                  {
                      Popr++;
                      if(Popr==81)
                      {
                          try
                          {
                              RandomAccessFile plik = new RandomAccessFile("plik.dat", "rw");
                              Date Data=new Date();
                              SimpleDateFormat aktualna_Data = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                              plik.seek(0);
                              int t=0;
                              String b="";
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
                              if(c==1)
                              {
                                  plik.seek(0);
                                  plik.readInt();
                                  plik.readUTF();
                                  plik.readInt();
                                  plik.readUTF();
                                  plik.readUTF();
                                  plik.writeUTF("Zakończona");
                                  plik.writeUTF(aktualna_Data.format(Data));
                                  plik.writeInt(seconds);
                                  plik.close();
                              }
                              else
                                  {
                                      long []x=new long[c];
                                      plik.seek(0);
                                    while (plik.length() > plik.getFilePointer())
                                    {
                                        plik.readInt();
                                        plik.readUTF();
                                        plik.readInt();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readUTF();
                                        plik.readInt();
                                        x[t] = plik.getFilePointer();
                                        t++;
                                    }
                                        plik.seek(x[c - 2]);
                                        plik.readInt();
                                        imie = plik.readUTF();
                                        plik.readInt();
                                        poziom = plik.readUTF();
                                        plik.readUTF();
                                        plik.writeUTF("Zakończona");
                                        plik.writeUTF(aktualna_Data.format(Data));
                                        plik.writeInt(seconds);
                                        plik.close();
                                  }
                          }
                          catch(FileNotFoundException x)
                          {
                              System.out.println("Błąd nie ma pliku");
                          }
                          catch(IOException w)
                          {
                              System.out.println("Błąd");
                          }
                          dispose();
                          new Gratulacje(imie,poziom,seconds,bledy,c);
                      }
                  }
             }
            }

        }
        }
        }


