import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Window_Menu extends JFrame implements ActionListener
{
    JTextField table,table_separator;
    Window_Menu()
    {
        super("Strategy");
        setSize(600, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 4000, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel encouragment_table=new JLabel("Type your series of data: ");
        encouragment_table.setFont(new Font("Arial", Font.BOLD, 22));
        add(encouragment_table);
        table= new JTextField(10);
        table.setFont(new Font("Arial", Font.BOLD, 22));
        add(table);
        JLabel encouragment_table_separator=new JLabel("Type your sign which separates next numbers");
        encouragment_table_separator.setFont(new Font("Arial", Font.BOLD, 22));
        add(encouragment_table_separator);
        table_separator=new JTextField(10);
        table_separator.setFont(new Font("Arial", Font.BOLD, 22));
        add(table_separator);
        JButton Next=new JButton("Next");
        Next.setFont(new Font("Arial", Font.BOLD, 22));
        Next.setBounds(200,150,200,25);
        add(Next);
        Next.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!table.getText().trim().equals("") && !table_separator.getText().trim().equals(""))
        {
            dispose();
            new Sorting_Page(table.getText(),table_separator.getText());
        }
    }
}
