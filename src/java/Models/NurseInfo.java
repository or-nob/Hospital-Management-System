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
public class NurseInfo {
   String nname;
   String nphone;
   String nemail;
   String nsex;
   String ndob;
   String ndot;
   String naddress ;
   String ndegree ;
   String ninstitute;
   String n_id;
   public NurseInfo(String n_id, String nname, String nphone, String nemail, String nsex, String ndob, String ndot, String naddress, String ndegree, String ninstitute){
       this.n_id = n_id;
       this.naddress = naddress;
       this.ndegree = ndegree;
       this.ndob = ndob;
       this.ndot = ndot;
       this.nemail = nemail;
       this.nname = nname;
       this.nsex = nsex;
       this.nphone = nphone;
       this.ninstitute = ninstitute;
   }
   public String getnid(){return n_id;}
   public String getnaddress(){return naddress;}
   public String getndegree(){return ndegree;}
   public String getndob(){return ndob;}
   public String getndot(){return ndot;}
   public String getnemail(){return nemail;}
   public String getnname(){return nname;}
   public String getnsex(){return nsex;}
   public String getnphone(){return nphone;}
   public String getninstitute(){return ninstitute;}
}
