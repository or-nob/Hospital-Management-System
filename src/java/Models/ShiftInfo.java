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
public class ShiftInfo {
    int shiftfee;
    String shiftday;
    int timeline;
    String ShiftId;
    public ShiftInfo(int shiftfee, String shiftday, int timeline){
        this.shiftday = shiftday;
        this.shiftfee = shiftfee;
        this.timeline = timeline;
    }
    public ShiftInfo(String ShiftId, int shiftfee, String shiftday, int timeline){
        this.shiftday = shiftday;
        this.shiftfee = shiftfee;
        this.timeline = timeline;
        this.ShiftId = ShiftId;
    }
    public String getShiftId(){return ShiftId;}
    public int getshiftfee(){return shiftfee;}
    public String getshiftday(){return shiftday;}
    public int gettimeline(){return timeline;}
}
