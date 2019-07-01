// Μιχαήλ Δανουσης
// 321/2012046
// Ασκηση 1

import java.io.Serializable;
import java.util.ArrayList;

public class Ergasia implements Serializable{
    private ArrayList<String> sugrafeis;
    private String titlos_periodikou;
    private int arithmos_selidwn;
    private int etos;
    private int tomos;
    private int selida;

public Ergasia()
{
    sugrafeis=new ArrayList<String>();//ftiaxnw ena array list sto opoio 8a ginei
    // h eisagwgh twn sugrafevn;
    titlos_periodikou="Default";
    arithmos_selidwn=0;
    etos=0;
    tomos=0;
    selida=0;
    sugrafeis.add("Default s");
    
}
public Ergasia(ArrayList<String> s,String tp,int as,int e,int t,int sel)
{
    sugrafeis=new ArrayList<String>();//ftiaxnw ena array list sto opoio 8a ginei
    // h eisagwgh twn sugrafevn;
    titlos_periodikou=tp;
    arithmos_selidwn=as;
    etos=e;
    tomos=t;
    selida=sel;
    for(int i=0;i<s.size();i++)//gemizw to "sugrafeis me ta stoixeia tis arraylist
        // "s" pou exei do8ei ston constactor
    {
        sugrafeis.add(s.get(i));
    }

}
public String getSugrafeis()
{
    String sug=null;
    for (int i=0;i<sugrafeis.size();i++)
    {
        if(i>0)
            sug=sug+","+ sugrafeis.get(i);
        else sug=sugrafeis.get(i);
    }
    return sug;
}

public int getEtos()
{
    return etos;
}

    @Override
    public String toString()
{
    return getSugrafeis()+"\n"+titlos_periodikou+"\n"+
            arithmos_selidwn+"\n"+etos+"\n"+tomos+"\n"+selida;
}

}