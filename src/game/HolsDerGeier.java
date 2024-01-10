package game;

import java.util.ArrayList;
import players.*;

/**
 * Die Klasse HolsDerGeier beinhaltet alle relevanten Informationen zum Spiel und verwaltet dieses.
 *
 * @author THM
 * @version 0.1
 */

public class HolsDerGeier {
       
    // Hier stehen die Geier- und Mauskarten
    private ArrayList<Integer> nochZuVergebendeGeierKarten=new ArrayList<Integer>();

    // Hier stehen die vom Computer gespielten Karten
    private ArrayList<ArrayList<Integer>> gespielteKarten=new ArrayList<ArrayList<Integer>>();
        
    // Punktestände
    private int punkte;
    private int[] punktstaende=new int[2];
    
    // Das ist die Referenz Ihr Objekt
    private HolsDerGeierSpieler[] spieler;    

    public HolsDerGeier()  {
        gespielteKarten.add(new ArrayList<Integer>());
        gespielteKarten.add(new ArrayList<Integer>());        
    }

    // Neu laden der Karten
    private void ladeSpiel() {
        //  Geier- und Maeusekarten
        nochZuVergebendeGeierKarten.clear();
        for (int i=-5;i<=10;i++) 
            if (i!=0) {
                nochZuVergebendeGeierKarten.add(i);                        
            }    
    }

    // Spiele zufällig die nächste Geier- bzw. Mauskarte
    private int spieleNaechsteKarte() {
        int nochNichtVergeben=nochZuVergebendeGeierKarten.size();            
        int index=(int) (Math.random()*nochNichtVergeben);
        int ret=nochZuVergebendeGeierKarten.remove(index);
        return ret;
    }    
    
    // Hier kann nach dem letzten Zug gefragt werden. Aber diese Methode ist so eigentlich nicht wirklich gelungen.
    public int letzterZug(int nummer) {
        if (gespielteKarten.get(nummer).size()>0)
            return gespielteKarten.get(nummer).get(gespielteKarten.get(nummer).size()-1);
         else
            return -99;
    }

    // Setzt das Spiel zurück.
    private void reset() {
       punkte=0;
       for (int i=0;i<gespielteKarten.size();i++)
         gespielteKarten.get(i).clear();
       ladeSpiel();                
       for (int i=0;i<punktstaende.length;i++)
         punktstaende[i]=0;
       for (int i=0;i<spieler.length;i++)
         spieler[i].reset();
         
    }

    // Fügt dem Spiel zwei Spieler hinzu.
    public void neueSpieler(HolsDerGeierSpieler spieler1,HolsDerGeierSpieler spieler2){
       spieler = new HolsDerGeierSpieler[2]; 
       spieler[0]=spieler1;
       spieler[1]=spieler2;
       spieler1.register(this,1);
       spieler2.register(this,0);
    }
    
    // Startet ein neues Spiel
    public void naechstesSpiel() {
       if (spieler==null) 
            System.out.println("Noch keine Spieler angemeldet!");
       else {
           System.out.println("===============");
           System.out.println("= NEUES SPIEL, ES STEHT 0:0 =");       
           System.out.println("===============");
           reset();
        }
    }
    
    
    /**
     * Der nächste Spielzug wird ausgeführt.
     * Dazu wird:
     *  - Neue Geier- oder Mauskarte ermittelt
     *  - Zufällig eine Karte vom Computer gespielt
     *  - Die Spieler werden gefragt nach den Karten gefragt
     *  - Ausgewertet und der Punktestand geführt
    */
      public void naechsterZug() throws Exception {
       if (!nochZuVergebendeGeierKarten.isEmpty()) {
           
           // nächste Geier- bzw. Mauskarte
           int naechsteKarte=spieleNaechsteKarte();
           punkte+=naechsteKarte;
           
           int[] zuege=new int[2];
           
           // die Züge der beiden Spieler
           for (int i=0;i<spieler.length;i++) {
               zuege[i]=spieler[i].gibKarte(naechsteKarte);

               // Sicher ist sicher: Haben Sie diese Karten schon einmal gespielt?
               // Wenn ja: Jetzt ist aber Schluss.
               // Wenn nein: Ich merke mir die Karte.
               if (gespielteKarten.get(i).contains(zuege[i]) )
                   throw new Exception("GESCHUMMELT: Diese Karte wurde bereits gespielt "+i+" "+zuege[i]);

               
               if ((zuege[i]<1)||(zuege[i]>15))
                   throw new Exception("GESCHUMMELT: Diese Karte gibt es gar nicht");
           }

           // Alle Züge fertig, dann eintragen (erst hier wg. Methode nächsterZug())
           for (int i=0;i<spieler.length;i++) 
               gespielteKarten.get(i).add(zuege[i]);  
               
           // So sieht der aktuelle Zug aus
           System.out.println("Ausgespielte Karte: "+naechsteKarte);
           System.out.println("Zug erster Spieler: "+zuege[0]);
           System.out.println("Zug zweiter Spieler: "+zuege[1]);


           // Wer kriegt die Punkte?           
           
           // Lösung: Es muss zwischen Maus- (nachesteKarte>0) und Geierkarten (nachesteKarte<0) unterschieden werden.
           if (zuege[0]!=zuege[1]) {
               if (punkte>0) 
                    if (zuege[0]>zuege[1])
                       punktstaende[0]=punktstaende[0]+punkte;
                    else 
                       punktstaende[1]=punktstaende[1]+punkte;
               else
                    if (zuege[0]<zuege[1])
                       punktstaende[0]=punktstaende[0]+punkte;
                    else 
                       punktstaende[1]=punktstaende[1]+punkte;
              punkte=0; 
           } else
              System.out.println("Unentschieden - Punkte wandern in die nächste Runde");
           System.out.println("Spielstand: "+punktstaende[0]+" : "+punktstaende[1]);
       } else
           System.out.println("Spiel ist zu Ende. Sie müssen zuerst die Methode neues Siel aufrufen");
       
    }  
    
    // Mit dieser Methode kann ein komplettes Spiel gespielt werden.
    public void ganzesSpiel() throws Exception {
       if (nochZuVergebendeGeierKarten.isEmpty())
            naechstesSpiel();
        while (!nochZuVergebendeGeierKarten.isEmpty()) {
            naechsterZug();
        }
    }
    
}