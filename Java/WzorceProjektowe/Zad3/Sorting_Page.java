import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Sorting_Page extends JFrame implements ActionListener
{
    JLabel result_display;
    int[] table;
    Integer[] Randomized_table;
    Sorting_Page(String Table,String separator)
    {
        super("Options");
        this.setLayout(null);
        String[] result = Table.split(separator);
        int size = result.length;
        table = new int[size];
        Randomized_table=new Integer[size];
        for(int i=0; i<size; i++)
        {
            table[i] = Integer.parseInt(result[i]);
            Randomized_table[i]=Integer.parseInt(result[i]);
        }
        setSize(600,600);
        JButton Menu=new JButton("Bubble_Sort");
        Menu.setName("Bubble_Sort");
        Menu.setBounds(15,425,150,25);
        Menu.addActionListener(this);
        add(Menu);
        JButton Menu2=new JButton("Insert_Sort");
        Menu2.setName("Insert_Sort");
        Menu2.setBounds(215,425,150,25);
        Menu2.addActionListener(this);
        add(Menu2);
        JButton Menu3=new JButton("Merge_Sort");
        Menu3.setName("Merge_Sort");
        Menu3.setBounds(415,425,150,25);
        Menu3.addActionListener(this);
        add(Menu3);
        result_display =new JLabel(Arrays.toString(result));
        result_display.setFont(new Font("Arial", Font.BOLD, 22));
        result_display.setBounds(100,100,400,400);
        add(result_display);
        JButton New_Table=new JButton("New Table");
        New_Table.setName("New_Table");
        New_Table.addActionListener(this);
        New_Table.setBounds(100,475,150,25);
        add(New_Table);
        JButton Randomise=new JButton("Randomise");
        Randomise.setName("Scramble");
        Randomise.addActionListener(this);
        Randomise.setBounds(350,475,150,25);
        add(Randomise);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton pressed= (JButton) e.getSource();
        switch (pressed.getName())
        {
            case "Bubble_Sort":
            {
                Algorytmy algorytm_bubble_sort = new Menu(new Bubble_Sort());
                result_display.setText(algorytm_bubble_sort.sorting(table));
                break;
            }
            case "Insert_Sort":
                {
                    Algorytmy algorytm_insert_sort=new Menu(new Insert_Sort());
                    result_display.setText(algorytm_insert_sort.sorting(table));
                    break;
                }
            case "Merge_Sort":
                {
                    Algorytmy algorytm_merge_sort=new Menu(new Merge_Sort());
                    result_display.setText(algorytm_merge_sort.sorting(table));
                    break;
                }
            case "New_Table":
                {
                    dispose();
                    new Window_Menu();
                    break;
                }
            case "Scramble":
            {
                String Wypis_na_Ekran="";
                List<Integer> list =Arrays.asList(Randomized_table);
                Collections.shuffle(list);
                list.toArray(Randomized_table);
                for (int i=0;i<Randomized_table.length;i++)
                {
                    table[i]=Randomized_table[i];
                }
                for (int x:table)
                {
                    Wypis_na_Ekran+=x+",";
                }
                result_display.setText(Wypis_na_Ekran);
                break;
            }
        }
    }
}
