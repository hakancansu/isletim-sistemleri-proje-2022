package odev;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Hakan Cansu, Faruk Palta, Necati Babacan,Sefa Aktürk,Ömer Cin
 */
public class FCFS implements Comparator<Process> {
    
    public void findFCFS(LinkedList queue){
        int time = 0;
        TreeSet prique = new TreeSet(new FCFS());
        LinkedList result = new LinkedList();
        
        while (queue.size() > 0)
            prique.add((Process)queue.removeFirst());
 
        Iterator it = prique.iterator();
 
        // time set to according to first process
        time = ((Process)prique.first()).getVarisZamani();
        
        while (it.hasNext()) {
            Process obj = (Process)it.next();
            
            
        }
    }

    @Override
    public int compare(Process o1, Process o2) {
        Process p1 = (Process)o1;
        Process p2 = (Process)o2;
        if (p1.getVarisZamani() < p2.getVarisZamani())
            return (-1);
 
        else if (p1.getVarisZamani() == p2.getVarisZamani() && p1.getOncelik() > p2.getOncelik())
            return (-1);
 
        else
            return (1);
    }

}
