package odev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;


/**
 *
 * @author Hakan Cansu, Faruk Palta, Necati Babacan,Sefa Aktürk,Ömer Cin
 */
public class RoundRobin {

    /**
     * @param args the command line arguments
     */
    
    public List<Process> prosesleryeni = new ArrayList<>();
    static float seconds = 0;
    static float workingTime;
    
    private static final String PROSES_BASLADI = "proses basladi";
    private static final String PROSES_YURUTULUYOR = "proses yurutuluyor";
    private static final String PROSES_SONLANDI = "proses sonlandi";
    private static final String PROSES_ASKIDA = "proses askida";
    private static final String PROSES_ZAMANASIMI = "proses zamanasimi";

    public static void main(String[] args) {
        // TODO code application logic here

        
       
       long startTime = System.currentTimeMillis();
        ReadAndWriteArray readAndWriteArray = new ReadAndWriteArray("giris.txt");
        readAndWriteArray.outputArray(readAndWriteArray.getRobinArray());
        
        readAndWriteArray.prosesler.forEach(action ->{
            System.out.println("ID : " + action.getProsesID() + ", Varis_Zamani : " + action.getVarisZamani() 
                    +", Oncelik : " + action.getOncelik() + ", Proses_Zamani : " + action.getProsesZamani());
        });
        
        Collections.sort(readAndWriteArray.prosesler, new FCFS());
      
        
        seconds++;
        
        for (int i = 0; i < readAndWriteArray.prosesler.size(); i++) {
            Timer timer = new Timer();
            Process deger = readAndWriteArray.prosesler.get(i);
            workingTime = (float) deger.getProsesZamani();
            
            
            for (float j = 0; j < workingTime; j++) {
                
                if (j == 0) {
                    System.out.printf("%.4f%s%s%s%04d%s%d%s%d%s\n", seconds, " sn ",PROSES_BASLADI, " (id:",
                            deger.getProsesID(), " oncelik:", deger.getOncelik(),
                            " kalan sure:", (int)(workingTime - j), " sn)");
                }else if (j < workingTime) {
                    System.out.printf("%.4f%s%s%s%04d%s%d%s%d%s\n", seconds, " sn ", PROSES_YURUTULUYOR, " (id:",
                            deger.getProsesID(), " oncelik:", deger.getOncelik(),
                            " kalan sure:", (int)(workingTime - j), " sn)");
                    
                }if (j == workingTime){
                    System.out.printf("%.4f%s%s%s%04d%s%d%s%d%s\n", seconds, " sn ", PROSES_SONLANDI, " (id:", 
                            deger.getProsesID(), "oncelik:", deger.getOncelik(),
                            "kalan sure", (int)(workingTime - j), " sn)");
                    
                }
            }
            try {
                    Thread.sleep(1000);
                    
                    
                } catch (Exception e) {
                }
                seconds++;
        }
    }
    

    
    
}

