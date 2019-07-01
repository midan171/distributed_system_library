

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Frame extends JFrame implements ActionListener

//auth h klash 8a
//emperiexei ola ta stoixeia tou grafikou perivalontos sto opoio 8a ekteleitai 
//to programma 
{
    private JPanel startPanel;
    private JPanel insertPanel;
    private JPanel searchPanel;
    private JLabel startLabel;
    private JButton insert;
    private JButton search;
    private JLabel sugrafeisL;
    private JTextArea sugrafeisTA;
    private JLabel titlos_periodikouL;
    private JTextField titlos_periodikouTF;
    private JLabel arithmos_selidwnL;
    private JTextField arithmos_selidwnTF;
    private JLabel etosL;
    private JTextField etosTF;
    private JLabel tomosL;
    private JTextField tomosTF;
    private JLabel selidaL;
    private JTextField selidaTF;
    private JButton insertPaper;
    private JButton back;
    private JButton back2;
    private JTextField sugrafeas;
    
    ObjectOutputStream out;//Antikeimena gia na grafw k na diavazw apo arxeio
    ObjectInputStream in;
    
    public Frame () throws IOException
    {
        super ("Hello");
        fillStart();
        setContentPane(startPanel);
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        openOut();
    }
    
    public void openIn()
    {
        try{
            in = new ObjectInputStream(new FileInputStream("ergasies.txt"));
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("In  'openIn' method");
        }
    }
    
    public void openOut() throws FileNotFoundException, IOException
    {
        try{
            out = new ObjectOutputStream(new FileOutputStream("ergasies.txt", true));
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("In  'openOut' method");
        }    
    }
    
    public void fillStart()
    {
        startPanel=new JPanel();
        startLabel=new JLabel("Epelekse an 8eleis na kaneis eisagwgh h anazhthsh ergasias");
        startPanel.add(startLabel);
        insert=new JButton("insert");
        insert.addActionListener(this);
        startPanel.add(insert);
        search=new JButton("search");
        search.addActionListener(this);
        startPanel.add(search);   
    }
    
    public void fillInsert()
    {
        insertPanel=new JPanel();
        LayoutManager l=new GridLayout(10,3);
        insertPanel.setLayout(l);
        sugrafeisL= new JLabel ("Sugrafeis(eisagetai kathe suggrafea se diaforetikh seira):");
        insertPanel.add(sugrafeisL);
        sugrafeisTA= new JTextArea();
        insertPanel.add(sugrafeisTA);
        titlos_periodikouL= new JLabel("Titlos periodikou:");
        insertPanel.add(titlos_periodikouL);
        titlos_periodikouTF= new JTextField();
        insertPanel.add(titlos_periodikouTF);
        arithmos_selidwnL= new JLabel("Arithmos Selidwn:");
        insertPanel.add(arithmos_selidwnL);
        arithmos_selidwnTF= new JTextField();
        insertPanel.add(arithmos_selidwnTF);
        etosL= new JLabel("Etos:");
        insertPanel.add(etosL);
        etosTF= new JTextField();
        insertPanel.add(etosTF);
        tomosL= new JLabel("Tomos:");
        insertPanel.add(tomosL);
        tomosTF= new JTextField();
        insertPanel.add(tomosTF);
        selidaL= new JLabel("Selida:");
        insertPanel.add(selidaL);
        selidaTF= new JTextField();
        insertPanel.add(selidaTF);
        insertPaper=new JButton("insertPaper");
        insertPaper.addActionListener(this);
        insertPanel.add(insertPaper);
        back=new JButton("back");
        back.addActionListener(this);
        insertPanel.add(back);
    }
  
    public void fillSearch()//Gemizw to panel ths anazhthshs
    {
        searchPanel=new JPanel();
        LayoutManager k=new GridLayout(10,2);
        searchPanel.setLayout(k);
        sugrafeisL=new JLabel();
        sugrafeisL.setText("sugrafeas: ");
        searchPanel.add(sugrafeisL);
        sugrafeas=new JTextField();
        searchPanel.add(sugrafeas);
        etosL=new JLabel("Etos Dhmosieushs");
        searchPanel.add(etosL);
        etosTF=new JTextField();
        searchPanel.add(etosTF);
        search=new JButton("SEARCH");
        search.addActionListener(this);
        searchPanel.add(search);
        back=new JButton("back");
        back.addActionListener(this);
        searchPanel.add(back);           
    }
    
    //Add ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        out=null;//vazw null ston writter
        Object source=e.getActionCommand();
            if(source== "insert")
            {
                fillInsert();
                setContentPane(insertPanel);
                setSize(700,400);
                
            
            }
            if(source=="search")
            {
                fillSearch();
                setContentPane(searchPanel);
                setSize(400,400);
            }
        
        
        
            if(source=="insertPaper")
                //Ston parakato kodika ekteleitai h eisagwgh
                //mias ergasia ths opoias ta stoixeia eisagei o xrhsths
            {
                
                //bazw ka8e grammh tou TA se enan pinaka string ton opoio
                //metatrepw se arrayList wste na mporesw na thn perasw san 
                //orisma ston constractor twn Object "Ergasia"
                String s[] = sugrafeisTA.getText().split("\\r?\\n");
                ArrayList<String> sug=new ArrayList<String>(Arrays.asList(s));

                System.out.println("InsertPaper ok ok ok");
            
            
                int as=Integer.parseInt(arithmos_selidwnTF.getText());
                int et=Integer.parseInt(etosTF.getText());
                int t=Integer.parseInt(tomosTF.getText());
                int sel=Integer.parseInt(selidaTF.getText());
                //Ftiaznw ena object tupou ergasia me ta stoixeia pou do8ikan
                Ergasia erg=new Ergasia(sug,titlos_periodikouTF.getText(),as,et,t,sel);
                try{
                    openOut();
                    out.writeObject(erg.toString());//Pros8etw sto file ergasies thn eisagwgh tou xrhsth
                    //xrhsimopoiontas thn toString() thn opoia exw kanei override
                    out.flush();//adeiazw ton buffer
                }
                catch (Exception ex)
                {
                    System.out.println(ex+"Sto InsertPaper");//Diaxeirish exception
                }
                finally{
                    try{
                        out.close();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex+" sto finallly tou OUT");
                    }
                    
                }
                
            }
            if(source=="SEARCH")
            {
                System.out.println("SEARCH!!!");
                try{
                    openIn();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                finally{
                    try{
                        in.close();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex+" sto finallly tou IN");
                    }
                }
                
                
            }
            if (source=="back")//me to koumpi back gurizw sthn arxikh o8onh
            {
                setContentPane(startPanel);
                setSize(400,200);
            }
            
            
            
        
        }

    
    
    
    
    
    
}
