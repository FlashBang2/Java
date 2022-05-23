package Windows;

import Handlers.KeyboardSelect;
import Options.Template;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Select extends JFrame
{
    JLabel              Move=new JLabel(),                          MoveDescription=new JLabel("MOVE"), Menu=new JLabel(),
                        MenuDescription=new JLabel("MENU"),    Confirm=new JLabel(),                    ConfirmDescription=new JLabel("CONFIRM");
    ArrayList<Template> Selektor=new ArrayList<>();
    ArrayList<JLabel>   UI=new ArrayList<>();
    Template            Option;
    KeyboardSelect      keyboard=new KeyboardSelect(this);
    final int           FirstOptionX=300,                           FirstOptionY=150;
    boolean             UnlockedDarkKnight=false,                   UnlockedMedusa=false,                    UnlockedMage=false;
    boolean[]           Levers=new boolean[3];
    String              Save="Save.bin";
    FileInputStream     SaveRead;
    ObjectInputStream   Read;
    Path                path;

    public Select()
    {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        addKeyListener(keyboard);
        path= Paths.get(Save);
        if (Files.exists(path))
        {
            try
            {
                SaveRead=new FileInputStream(Save);
                Read=new ObjectInputStream(SaveRead);
                UnlockedDarkKnight=Read.readBoolean();
                UnlockedMedusa=Read.readBoolean();
                UnlockedMage=Read.readBoolean();
                Read.close();
            }
            catch (FileNotFoundException e)
            {

            }
            catch (IOException e)
            {

            }
        }
        Levers[0]=UnlockedDarkKnight;
        Levers[1]=UnlockedMedusa;
        Levers[2]=UnlockedMage;
        Move.setName("Move");
        Menu.setName("Menu");
        Confirm.setName("Confirm");
        UI.add(Move);
        UI.add(MoveDescription);
        UI.add(Menu);
        UI.add(MenuDescription);
        UI.add(Confirm);
        UI.add(ConfirmDescription);
        for (JLabel Element:UI)
        {
            Element.setFont(new Font("Arial",Font.PLAIN,40));
            Element.setForeground(Color.WHITE);
            if (Element.getName()!=null)
                {
                    Element.setIcon(new ImageIcon("Assets/Keys/"+Element.getName()+".png"));
                }
            add(Element);
        }
        for(int i=0;i<4;i++)
        {
            if (i==0)
                Option=new Template(true);
            else
                Option=new Template(Levers[i-1]);
            Option.setBounds(FirstOptionX+325*i,FirstOptionY,300,600);
            Selektor.add(Option);
            add(Option);
            if (i==0)
            {
                Option.setBackground(Color.WHITE);
            }
        }
        Transfer();
        Move.setBounds(350,900,138,64);
        MoveDescription.setBounds(500,910,250,50);
        Menu.setBounds(1325,900,64,64);
        MenuDescription.setBounds(1400,910,250,50);
        Confirm.setBounds(800,900,128,64);
        ConfirmDescription.setBounds(950,910,250,50);
        setVisible(true);
    }

    public void Transfer ()
    {
        keyboard.Chooser(Selektor);
    }
}
