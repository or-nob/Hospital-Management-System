/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author user
 */
public class MedicineInfo {
    String mname;
    String gname;
    int mprice;
    int quantity;
    String mid;
    public MedicineInfo(String mname, String mid, String gname, int mprice, int quantity){
        this.gname = gname;
        this.mid = mid;
        this.mname = mname;
        this.mprice = mprice;
        this.quantity = quantity;
    }
    public String getgname(){return gname;}
    public String getmname(){return mname;}
    public String getmid(){return mid;}
    public int getmprice(){return mprice;}
    public int getquantity(){return quantity;}
}
