
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filos_filou
 */
public class Test extends JFrame implements ActionListener{
        
    private JTextArea tf;
    private JButton b;
    private JPanel sPanel;
    public Test()
    {
        Start();
        setContentPane(sPanel);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void Start()
    {
        LayoutManager l=new GridLayout(2,1);
        sPanel=new JPanel();
        sPanel.setLayout(l);
        tf=new JTextArea("okokkokok");
        sPanel.add(tf);
        JButton b=new JButton("ok");
        b.addActionListener(this);
        sPanel.add(b);
        
        
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source=="b")
        {
            System.out.println("e ok");
            String s=tf.getText();
            System.out.println(s);
        }
    }
}
