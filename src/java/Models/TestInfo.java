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
public class TestInfo {
    int testfee;
    String testday;
    String aid;
    String testid;
    String tt_id;
    String tt_name;
    /*public TestInfo(int shiftfee, String shiftday, int timeline){
        this.shiftday = shiftday;
        this.shiftfee = shiftfee;
        this.timeline = timeline;
    }*/
    public TestInfo(String testday, String tt_id, int testfee, String aid, String testid, String tt_name){
        this.aid = aid;
        this.testday = testday;
        this.testid = testid;
        this.tt_id = tt_id;
        this.testfee = testfee;
        this.tt_name = tt_name;
    }
    public String getaid(){return aid;}
    public String gettestday(){return testday;}
    public String gettestid(){return testid;}
    public String gettt_id(){return tt_id;}
    public String gettt_name(){return tt_name;}
    public int gettestfee(){return testfee;}
}
