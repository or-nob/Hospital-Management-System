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
public class PatientInfo {
   String pname;
   String pphone;
   String pemail;
   String psex;
   String pdob;
   String pid;
   String aid;
   public PatientInfo(String pname,String pphone,String pemail,String psex,String pdob, String pid, String aid){
       this.pname = pname;
       this.pemail = pemail;
       this.pdob = pdob;
       this.psex = psex;
       this.pphone = pphone;
       this.aid = aid;
       this.pid = pid;
   }
   public String getpemail(){return pemail;}
   public String getpname(){return pname;}
   public String getpsex(){return psex;}
   public String getpphone(){return pphone;}
   public String getpdob(){return pdob;}
   //public String getpdot(){return pdot;}
   public String getaid(){return aid;}
   public String getpid(){return pid;}
}
