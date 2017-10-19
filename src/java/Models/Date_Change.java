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
public class Date_Change {
    String date;
    public Date_Change(String date){
        this.date = date;
    }
    public String update_date(){
        String[] S = date.split("-");
        String newd = new String();
        if(S[1].equals("01")){
            newd = S[2]+"-"+"jan"+"-"+S[0];
        }
        else if(S[1].equals("02")){
            newd = S[2]+"-"+"feb"+"-"+S[0];
        }
        else if(S[1].equals("03")){
            newd = S[2]+"-"+"mar"+"-"+S[0];
        }
        else if(S[1].equals("04")){
            newd = S[2]+"-"+"apr"+"-"+S[0];
        }
        else if(S[1].equals("05")){
            newd = S[2]+"-"+"may"+"-"+S[0];
        }
        else if(S[1].equals("06")){
            newd = S[2]+"-"+"jun"+"-"+S[0];
        }
        else if(S[1].equals("07")){
            newd = S[2]+"-"+"jul"+"-"+S[0];
        }
        else if(S[1].equals("08")){
            newd = S[2]+"-"+"aug"+"-"+S[0];
        }
        else if(S[1].equals("09")){
            newd = S[2]+"-"+"sep"+"-"+S[0];
        }
        else if(S[1].equals("10")){
            newd = S[2]+"-"+"oct"+"-"+S[0];
        }
        else if(S[1].equals("11")){
            newd = S[2]+"-"+"nov"+"-"+S[0];
        }
        else{
            newd = S[2]+"-"+"dec"+"-"+S[0];
        }
        return newd;
    }
}
