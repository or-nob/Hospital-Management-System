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
public class RoomInfo {
    String roomNo;
    String seatNo;
    String roomtype;
    int roomfee;
    int seatfee;
    public RoomInfo(String roomNo, String seatNo, String roomtype, int roomfee, int seatfee){
        this.roomNo = roomNo;
        this.roomfee = roomfee;
        this.roomtype = roomtype;
        this.seatNo = seatNo;
        this.seatfee = seatfee;
    }
    public String getroomNo(){return roomNo;}
    public String getseatNo(){return seatNo;}
    public String getroomtype(){return roomtype;}
    public int getroomfee(){return roomfee;}
    public int getseatfee(){return seatfee;}
}
