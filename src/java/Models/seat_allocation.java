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
public class seat_allocation {
    String aid;
    String seat_no;
    String sday;
    String eday;
    int cost;
    public seat_allocation(String aid, String seat_no, String sday, String eday, int cost){
        this.aid = aid;
        this.seat_no = seat_no;
        this.sday = sday;
        this.eday = eday;
        this.cost = cost;
    }
    public seat_allocation(){
        //
    }    
    public String getaid(){return aid;}
    public String getseatno(){return seat_no;}
    public String getsday(){return sday;}
    public String geteday(){return eday;}
    public int getcost(){return cost;}
}
