package odev;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hakan Cansu, Faruk Palta, Necati Babacan,Sefa Aktürk,Ömer Cin
 *
 */
public class ReadAndWriteArray {
    
    public List<Process> prosesler = new ArrayList<>();

    private int[][] robinArray;
    private int size = -1;

    public ReadAndWriteArray() {
    }
    
    private int rowSize = 0;
    private int log10 = 0;
    private String numberFormat;
    private int idCounter = 0;

    public ReadAndWriteArray(String filename) {
        try {
            readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int[][] getRobinArray() {
        return robinArray;
    }

    public void setRobinArray(int[][] robinArray) {
        this.robinArray = robinArray;
    }

    public void readFile(String filename) throws IOException {
        
        BufferedReader buffer = new BufferedReader(new FileReader(filename));
        Path path = Paths.get(filename);
        
        String line = null;
        int row = 0;
        
        try {
            rowSize = (int) Files.lines(path).count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("[, ]+");
            int[] deger = new int[vals.length];

            if (robinArray == null) {
                size = vals.length;
                robinArray = new int[rowSize][size];
            }
            

            for (int col = 0; col < size; col++) {
                try {
                    robinArray[row][col] = Integer.parseInt(vals[col]);
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                }
                
            }

            row++;
        }
        buffer.close();
    }
    
    public void outputArray (int array[][]){
        
//        System.out.printf("%s%10s%16s\n", "Varis_Zamani", "Oncelik", "Proses_Zamani");
        
        for (int row = 0; row < array.length; row++){
            
            prosesler.add(new Process(idCounter, array[row][0], array[row][1], array[row][2]));

            idCounter++;
//            System.out.println();
        }
        
        
    }

}