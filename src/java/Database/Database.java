/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.DoctorInfo;
import Models.MedicineInfo;
import Models.NurseInfo;
import Models.PatientInfo;
import Models.RoomInfo;
import Models.ShiftInfo;
import Models.TestInfo;
import Models.idppr;
import Models.seat_allocation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samsung
 */
public class Database 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "arnob1";
    String password = "1234";

    Connection conn = null;
    public Database()
    {
        try
        {
            
            System.out.println("********************************A");
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("********************************B");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param username
     * @param Employee_id
     * @param Phone
     * @return
     */
    public int createEmployeeAccount(String username, String Employee_id, String Ph_Num, String email, String Sex, String DOB, String DOT, String Address)
    {
        try
        {
            String insertCommand = "insert into employees values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, username);
            stmt.setString(2, Employee_id);
            stmt.setString(3, Ph_Num);
            stmt.setString(4, email);
            stmt.setString(5, Sex);
            stmt.setString(6, DOB);
            stmt.setString(7, DOT);
            stmt.setString(8,Address);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }  
    }
    
    
    public void createPatientAccount(String pname, String pid, String pphone, String eid, String psex, String pemail, int dfee, String pdob, String aid, String pdoa, String aaddress){
        try{
            String sql = "{ call CREATE_ACCOUNT_PATIENT(?,?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,pname);
            statement.setString(2,pid);
            statement.setString(3,pphone);
            statement.setString(4,eid);
            statement.setString(5,psex);
            statement.setString(6,pemail);
            statement.setInt(7,dfee);
            statement.setString(8,pdob);
            statement.setString(9,aid);
            statement.setString(10,pdoa);
            statement.setString(11,aaddress);
            //statement.registerOutParameter(1, java.sql.Types.);  
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void newMedicine(String md_id, String md_name, String md_genericname, int md_price, String a_id, int quantity){
        try{
            String sql = "{ call NEW_MEDICINE(?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1, md_id);
            statement.setString(2, md_name);
            statement.setString(3, md_genericname);
            statement.setInt(4, md_price);
            statement.setString(5, a_id);
            statement.setInt(6, quantity);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createReport(String r_id, String r_desc, String d_t_id){
        try{
            String sql = "insert into REPORTS values(?,?,?)";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1, r_id);
            statement.setString(2, r_desc);
            statement.setString(3, d_t_id);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void createSeatAllocation(String aid, String seat_no, String st_dos, String st_doe, int st_cost){
        try{
            String sql = "{ call SEAT_ALLOCATION(?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,aid);
            statement.setString(2,seat_no);
            statement.setString(3,st_dos);
            statement.setString(4,st_doe);
            statement.setInt(5,st_cost);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void nurse_allocation(String allid, String alldate, String all_reldate, String shift_id, String r_no, String n_id){
        try{
            String sql = "{ call N_ALLOCATION(?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,allid);
            statement.setString(2,alldate);
            statement.setString(3,all_reldate);
            statement.setString(4,shift_id);
            statement.setString(5,r_no);
            statement.setString(6,n_id);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void new_test(String tt_id, String tt_name, int tt_price, String dot, String dt_test_id, int dt_cost, String a_id){
        try{
            String sql = "{ call CREATE_TEST(?,?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,tt_id);
            statement.setString(2,tt_name);
            statement.setInt(3,tt_price);
            statement.setString(4,dot);
            statement.setString(5,dt_test_id);
            statement.setInt(6, dt_cost);
            statement.setString(7,a_id);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<MedicineInfo> medicine_for_patient(String aid){
        ArrayList<MedicineInfo> medicine = new ArrayList<>();
        try{
            String query = "select * from medicine m  join gets b on (m.md_id=b.md_id) join admission a on (a.a_id = b.a_id) where a.a_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,aid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String mname = rs.getString("md_name");
                String mid = rs.getString("md_id");
                String gmname = rs.getString("MD_GENERICNAME");
                int price = rs.getInt("MD_PRICE");
                int quantity = rs.getInt("QUANTITY");
                MedicineInfo obj = new MedicineInfo(mname, mid, gmname, price, quantity);
                medicine.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return medicine;
    }
    
    public ArrayList<TestInfo> test_for_patient(String aid){
        ArrayList<TestInfo> temp = new ArrayList<>();
        try{
            String query = "select * from DIAGONOSIS_TEST where A_ID = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,aid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String dtestid = rs.getString("DT_TEST_ID");
                int dtestcost = rs.getInt("DT_COST");
                String dtestdate = rs.getString("DT_DOT");
                String a_id = rs.getString("A_ID");
                String tt_id = rs.getString("TT_ID");
                String query1 = "select * from  TEST_TYPE where TT_ID = ? ";
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                stmt1.setString(1,tt_id);
                ResultSet rs1 = stmt1.executeQuery();
                String test_name = "";
                if(rs1.next()){
                    test_name = rs1.getString("tt_name");
                }
                TestInfo obj = new TestInfo(dtestdate, tt_id, dtestcost, a_id, dtestid, test_name);
                temp.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return temp;
    }    
    
    
    public boolean existAdmin(String e_id, String e_name){
        if('4'!=e_id.charAt(0)){
            return false;
        }
        try
        {
            String query = "select * from employees where E_ID = ? and E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,e_id);
            stmt.setString(2, e_name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public int createDoctorAccount(String e_id, String Institution, String Degree){
        try{
            String insertCommand = "insert into doctor values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, e_id);
            stmt.setString(2, Institution);
            stmt.setString(3, Degree);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean existDoctor(String e_id, String username)
    {
        try
        {
            String query = "select * from doctor D join employees E on (D.E_ID=E.E_ID) where D.E_ID = ? and E.E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,e_id);
            stmt.setString(2, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        } 
    }
    
    public String EID_Doctor(String username)
    {
        try
        {
            String query = "select D.E_ID from doctor D join employees E on (D.E_ID=E.E_ID) where E.E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return rs.getString("E_ID");
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public ArrayList<DoctorInfo> dataretrieveD(String e_id,String name){
        ArrayList<DoctorInfo> Doctor = new ArrayList<>();
        try{
            String query = "select * from doctor D join employees E on (D.E_ID=E.E_ID) where D.E_ID = ? and E.E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,e_id);
            stmt.setString(2, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                try{
                    String deid = rs.getString("e_id");
                    String dname = rs.getString("e_name");
                    String dphone = rs.getString("E_PHONENUMBER");
                    String demail = rs.getString("E_EMAIL");
                    String dsex = rs.getString("E_SEX");
                    String ddob = rs.getString("E_DOB");
                    String ddot = rs.getString("e_dot");
                    String daddress = rs.getString("E_ADDRESS");
                    String ddegree = rs.getString("D_DEGREES");
                    String dinstitute = rs.getString("D_INSTITUTION");
                    DoctorInfo obj = new DoctorInfo(deid, dname, dphone, demail, dsex, ddob, ddot, daddress, ddegree, dinstitute);
                    Doctor.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Doctor;
    }
    
    
    
    public ArrayList<DoctorInfo> DoctorList(){
        ArrayList<DoctorInfo> Doctor = new ArrayList<>();
        try{
            String query = "select * from doctor D join employees E on (D.E_ID=E.E_ID)";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                try{
                    String deid = rs.getString("e_id");
                    String dname = rs.getString("e_name");
                    String dphone = rs.getString("E_PHONENUMBER");
                    String demail = rs.getString("E_EMAIL");
                    String dsex = rs.getString("E_SEX");
                    String ddob = rs.getString("E_DOB");
                    String ddot = rs.getString("e_dot");
                    String daddress = rs.getString("E_ADDRESS");
                    String ddegree = rs.getString("D_DEGREES");
                    String dinstitute = rs.getString("D_INSTITUTION");
                    DoctorInfo obj = new DoctorInfo(deid,dname, dphone, demail, dsex, ddob, ddot, daddress, ddegree, dinstitute);
                    Doctor.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Doctor;
    }
    
    public String dfee(String deid){
        String dfee = new String();
        try{
            String query = "select * from d_assigned where e_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int temp = rs.getInt("fee");
                dfee = Integer.toString(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dfee;
    }
    
    public String deid(String aid){
        String e_id = new String();
        try{
            String query = "select * from d_assigned where a_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, aid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                e_id = rs.getString("e_id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return e_id;
    }
    
    public ArrayList<NurseInfo> NurseList(){
        ArrayList<NurseInfo> Nurse = new ArrayList<>();
        try{
            String query = "select * from nurse D join employees E on (D.E_ID=E.E_ID)";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                try{
                    String e_id = rs.getString("e_id");
                    String dname = rs.getString("e_name");
                    String dphone = rs.getString("E_PHONENUMBER");
                    String demail = rs.getString("E_EMAIL");
                    String dsex = rs.getString("E_SEX");
                    String ddob = rs.getString("E_DOB");
                    String ddot = rs.getString("e_dot");
                    String daddress = rs.getString("E_ADDRESS");
                    String ddegree = rs.getString("N_DEGREES");
                    String dinstitute = rs.getString("N_INSTITUTION");
                    NurseInfo obj = new NurseInfo(e_id, dname, dphone, demail, dsex, ddob, ddot, daddress, ddegree, dinstitute);
                    Nurse.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Nurse;
    }

    public ArrayList<ShiftInfo> ShiftList(){
        ArrayList<ShiftInfo> Shift = new ArrayList<>();
        try{
            String query = " select * from timeline_mul T join shifts S on (T.shift_id=S.shift_id)";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                try{
                    String ShiftId = rs.getString("shift_id");
                    String shiftday = rs.getString("shift_day");
                    int fee = rs.getInt("fee");
                    int timeline = rs.getInt("timeline");
                    ShiftInfo obj = new ShiftInfo(ShiftId, fee, shiftday, timeline);
                    Shift.add(obj);
                    }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Shift;
    }
    
    public ArrayList<RoomInfo> RoomList(){
        ArrayList<RoomInfo> Room = new ArrayList<>();
        try{
            String query = "select * from room R join seats S on (R.R_NO=S.R_NO)";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                try{
                    String rno = rs.getString("r_no");
                    String rtype = rs.getString("rtype_id");
                    String sno = rs.getString("seat_no");
                    int seatfee = rs.getInt("fee");
                    int roomfee = rs.getInt("R_Fee");
                    RoomInfo obj = new RoomInfo(rno, sno, rtype, roomfee, seatfee);
                    Room.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Room;
    }
    
    public ArrayList<PatientInfo> PatientList(){
        ArrayList<PatientInfo> Patient = new ArrayList<>();
        try{
            String query = "select * from patient P join admission A on (P.P_ID=A.P_ID)";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                try{
                    String dname = rs.getString("p_name");
                    String dphone = rs.getString("p_PHONENUMBER");
                    String demail = rs.getString("p_EMAIL");
                    String dsex = rs.getString("p_SEX");
                    String ddob = rs.getString("p_DOB");
                    String pid = rs.getString("p_id");
                    String aid = rs.getString("a_id");
                    PatientInfo obj = new PatientInfo(dname, dphone, demail,dsex, ddob, pid, aid);
                    Patient.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Patient;
    }
    
    
    
    public int createNurseAccount(String username, String Institution, String Degree){
        try{
            String insertCommand = "insert into nurse values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, username);
            stmt.setString(2, Institution);
            stmt.setString(3, Degree);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean existNurse(String e_id, String username)
    {
        try
        {
            String query = "select * from nurse D join employees E on (D.E_ID=E.E_ID) where D.E_ID = ? and E.E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,e_id);
            stmt.setString(2, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        
        
    }
    
    public boolean existPatient(String p_id, String p_name){
        try
        {
            String query = "select * from patient where P_ID = ? and P_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,p_id);
            stmt.setString(2, p_name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<NurseInfo> dataretrieveN(String e_id,String name){
        ArrayList<NurseInfo> Nurse = new ArrayList<>();
        try{
            String query = "select * from nurse D join employees E on (D.E_ID=E.E_ID) where D.E_ID = ? and E.E_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,e_id);
            stmt.setString(2, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                try{
                    String ne_id = rs.getString("e_id");
                    String dname = rs.getString("e_name");
                    String dphone = rs.getString("E_PHONENUMBER");
                    String demail = rs.getString("E_EMAIL");
                    String dsex = rs.getString("E_SEX");
                    String ddob = rs.getString("E_DOB");
                    String ddot = rs.getString("e_dot");
                    String daddress = rs.getString("E_ADDRESS");
                    String ddegree = rs.getString("N_DEGREES");
                    String dinstitute = rs.getString("N_INSTITUTION");
                    NurseInfo obj = new NurseInfo(ne_id, dname, dphone, demail, dsex, ddob, ddot, daddress, ddegree, dinstitute);
                    Nurse.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Nurse;
    }
    
    public ArrayList<Integer> bill_doctor(String aid){
        ArrayList<Integer> DoctorFee = new ArrayList<>();
        try{
           String query = "select * from D_ASSIGNED where a_id = ?";
           PreparedStatement stmt = conn.prepareStatement(query); 
           stmt.setString(1, aid);
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               try{
                    int a = rs.getInt("FEE");
                    DoctorFee.add(a);
               }catch(Exception e){
                    e.printStackTrace();
               }
           }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return DoctorFee;
    }
    
    public ArrayList<Integer> bill_room(String aid){
        ArrayList<Integer> RoomFee = new ArrayList<>();
        try{
            String query = "select * from st_allocation ST join seats S on (ST.seat_no = S.seat_no) join seats Se on (S.seat_no=Se.seat_no) where ST.a_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query); 
            stmt.setString(1, aid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               try{
                    String seat_no = rs.getString("seat_no");
                    String room_no = rs.getString("r_no");
                    String query1 = "select * from n_allocation_chart NC join shifts S on (NC.shift_id = S.shift_id) where NC.r_no = ?";
                    PreparedStatement stmt1 = conn.prepareStatement(query1); 
                    stmt1.setString(1, room_no);
                    ResultSet rs1 = stmt1.executeQuery();
                    while(rs1.next()){
                        int a = rs1.getInt("fee");
                        RoomFee.add(a);
                    }
               }catch(Exception e){
                    e.printStackTrace();
               }
           }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return RoomFee;
    }
    
    public String report_descrpition(String t_id){
        String desc = new String();
        try{
            String query = "select * from reports where DT_TEST_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, t_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                desc += rs.getString("REPORT_DESCRIPTION");
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return desc;
    }
    
    public void update_reportdescription(String dt_id, String u_r_desc){
        try{
            String query = "update reports set REPORT_DESCRIPTION=? where DT_TEST_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, u_r_desc);
            stmt.setString(2, dt_id);
            ResultSet rs1 = stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updatePatientInfo(String pid, String name, String p_no, String email, String sex, String dob){
        try{
            String query = "update patient set P_NAME = ?, P_PHONENUMBER = ?, P_EMAIL = ?, P_SEX = ?, P_DOB = ? where P_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, p_no);
            stmt.setString(3, email);
            stmt.setString(4, sex);
            stmt.setString(5, dob);
            stmt.setString(6, pid);
            ResultSet rs1 = stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public idppr getttprice(String dt_test_id){
        int price = 0;
        String tt_id = "";
        try{
            String query1 = "select * from DIAGONOSIS_TEST where DT_TEST_ID = ?";
            PreparedStatement stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,dt_test_id);
            ResultSet rs1 = stmt1.executeQuery();
            try{
                while(rs1.next()){
                    tt_id = rs1.getString("TT_ID");
                    String query = "select * from TEST_TYPE where TT_ID = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, tt_id);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        price += rs.getInt("TT_PRICE");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        idppr obj = new idppr(price,tt_id);
        return obj;
    }
    
    
    public void updateTestInfo(String t_id, String t_name, int t_price, String t_date, String dt_id, int dt_cost){
        try{
            String sql = "{ call UPDATE_TEST(?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1, t_id);
            statement.setString(2, t_name);
            statement.setInt(3, t_price);
            statement.setString(4, t_date);
            statement.setString(5, dt_id);
            statement.setInt(6, dt_cost);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String seatno(String aid){
        int price = 0;
        String tt_id = "";
        String seat_no = "";
        try{
            String query1 = "select * from ST_ALLOCATION where A_ID = ?";
            PreparedStatement stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,aid);
            ResultSet rs1 = stmt1.executeQuery();
            if(rs1.next()){
                seat_no = rs1.getString("seat_no");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return seat_no;
    } 
    
    public String docName(String aid){
        String doc_name = "";
        try{
            String query1 = "select * from d_assigned D join employees E on(D.e_id=E.e_id) where D.a_id = ?";
            PreparedStatement stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,aid);
            ResultSet rs1 = stmt1.executeQuery();
            if(rs1.next()){
                doc_name = rs1.getString("e_name");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return doc_name;
    }
    
    public seat_allocation getallseat(String seat_no){
        String a_id = "";
        String st_dos = "";
        String st_doe = "";
        int st_cost;
        seat_allocation obj = new seat_allocation();
        try{
            String query1 = "select * from st_allocation where seat_no = ?";
            PreparedStatement stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,seat_no);
            ResultSet rs1 = stmt1.executeQuery();
            if(rs1.next()){
                a_id = rs1.getString("a_id");
                st_dos = rs1.getString("st_dos");
                st_doe = rs1.getString("st_doe");
                st_cost = Integer.valueOf(rs1.getString("st_cost"));
                obj = new seat_allocation(a_id, seat_no, st_dos, st_doe, st_cost);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
    
    public void update_seat_all(String s_no, String aid, String dos, String doe, int cost){
        try{
            String query = "update st_allocation set SEAT_NO = ?, ST_DOS  = ?, ST_DOE = ?, ST_COST = ? where A_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, s_no);
            stmt.setString(2, dos);
            stmt.setString(3, doe);
            stmt.setInt(4, cost);
            stmt.setString(5, aid);
            ResultSet rs1 = stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update_doc_all(String e_id, String aid, int fee){
        try{
            String query = "update d_assigned set E_ID = ?, FEE  = ? where A_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, e_id);
            stmt.setInt(2, fee);
            stmt.setString(3, aid);
            ResultSet rs1 = stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insert_new_doc(String e_id, String aid, int fee){
        try{
            String query = "insert into d_assigned values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(2, e_id);
            stmt.setInt(3, fee);
            stmt.setString(1, aid);
            ResultSet rs1 = stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update_medicine(String MDI_ID, String MDI_NAME, String MDI_GENERICNAME, int MDI_PRICE, int QUANTITYM){
        try{
            String sql = "{ call UPDATE_MEDICINE(?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,MDI_ID);
            statement.setString(2,MDI_NAME);
            statement.setString(3,MDI_GENERICNAME);
            statement.setInt(4,MDI_PRICE);
            statement.setInt(5,QUANTITYM);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update_doc_info(String EM_ID ,String EM_NAME,String EM_PHONENUMBER,String EM_EMAIL ,String EM_SEX, String EM_DOB, String EM_DOT, String EM_ADDRESS, String DO_DEGREES, String DO_INSTITUTION){
        try{
            String sql = "{ call UPDATE_DOCINFO(?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,EM_ID);
            statement.setString(2,EM_NAME);
            statement.setString(3,EM_PHONENUMBER);
            statement.setString(4,EM_EMAIL);
            statement.setString(5,EM_SEX);
            statement.setString(6,EM_DOB);
            statement.setString(7,EM_DOT);
            statement.setString(8,EM_ADDRESS);
            statement.setString(9,DO_DEGREES);
            statement.setString(10,DO_INSTITUTION);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update_nurse_info(String EM_ID ,String EM_NAME,String EM_PHONENUMBER,String EM_EMAIL ,String EM_SEX, String EM_DOB, String EM_DOT, String EM_ADDRESS, String NU_DEGREES, String NU_INSTITUTION){
        try{
            String sql = "{ call UPDATE_NURSEINFO(?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,EM_ID);
            statement.setString(2,EM_NAME);
            statement.setString(3,EM_PHONENUMBER);
            statement.setString(4,EM_EMAIL);
            statement.setString(5,EM_SEX);
            statement.setString(6,EM_DOB);
            statement.setString(7,EM_DOT);
            statement.setString(8,EM_ADDRESS);
            statement.setString(9,NU_DEGREES);
            statement.setString(10,NU_INSTITUTION);
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*public ArrayList<PatientInfo> dataretrieveP(String p_id,String p_name){
        ArrayList<PatientInfo> Patient = new ArrayList<>();
        try{
            String query = "select * from patient where P_ID = ? and P_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,p_id);
            stmt.setString(2, p_name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                try{
                    String dname = rs.getString("p_name");
                    String dphone = rs.getString("p_PHONENUMBER");
                    String demail = rs.getString("p_EMAIL");
                    String dsex = rs.getString("p_SEX");
                    String ddob = rs.getString("p_DOB");
                    PatientInfo obj = new PatientInfo(dname, dphone, demail, dsex, ddob);
                    Patient.add(obj);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return Patient;
    }
/*
//Call function sample:
    
    String sql = "{ ? = call FUNCT_PERSON(?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/
    
 /*
    String sql = "{ call PROC_PERSON(?,?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/ 

}
