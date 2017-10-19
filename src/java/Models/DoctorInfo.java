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
public class DoctorInfo {
   String dname;
   String dphone;
   String demail;
   String dsex;
   String ddob;
   String ddot;
   String daddress ;
   String ddegree ;
   String dinstitute;
   String deid;
   public DoctorInfo(String deid, String dname, String dphone, String demail, String dsex, String ddob, String ddot, String daddress, String ddegree, String dinstitute){
       this.daddress = daddress;
       this.ddegree = ddegree;
       this.ddob = ddob;
       this.ddot = ddot;
       this.demail = demail;
       this.dname = dname;
       this.dsex = dsex;
       this.dphone = dphone;
       this.dinstitute = dinstitute;
       this.deid = deid;
   }
   public DoctorInfo(){
   //
   }
   public void setdname(String dname){this.dname = dname;} 
   public String getdaddress(){return daddress;}
   public String getddegree(){return ddegree;}
   public String getddob(){return ddob;}
   public String getddot(){return ddot;}
   public String getdemail(){return demail;}
   public String getdname(){return dname;}
   public String getdsex(){return dsex;}
   public String getdphone(){return dphone;}
   public String getdinstitute(){return dinstitute;}
   public String getdeid(){return deid;}
}
