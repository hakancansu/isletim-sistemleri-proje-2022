package odev;

public class Process {
    
    private int prosesID;
    private int varisZamani;
    private int oncelik;
    private int prosesZamani;
    
    public Process() {
    }
    
    public Process(int prosesID, int varisZamani, int oncelik, int prosesZamani) {
        this.prosesID = prosesID;
        this.varisZamani = varisZamani;
        this.oncelik = oncelik;
        this.prosesZamani = prosesZamani;
    }

    public int getProsesID() {
        return prosesID;
    }

    public void setProsesID(int prosesID) {
        this.prosesID = prosesID;
    }

    public int getVarisZamani() {
        return varisZamani;
    }

    public void setVarisZamani(int varisZamani) {
        this.varisZamani = varisZamani;
    }

    public int getOncelik() {
        return oncelik;
    }

    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }

    public int getProsesZamani() {
        return prosesZamani;
    }

    public void setProsesZamani(int prosesZamani) {
        this.prosesZamani = prosesZamani;
    }
    
    

}
