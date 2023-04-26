
import java.io.*;
import java.sql.SQLData;
import java.util.*;

class Admin implements Serializable{
    String name;
    String number;
    String mail;
    String password;
    String resturentname;
    String opeingtime;
    String closeingtime;
    String resturentnumber;
    String area;
    String city;
    String accountnumber;
    String bank;
    String accountname;
    String branch;
    String banknumber;
    String gpynumber;
 public Admin(String name,String number,String email,String pass,String resname,String resturentopen,String restruentclose,String area,String city,String bankname,String accountnumber,String branch,String bankPhnumber,String gpy,String resnumber,String accountname){
     this.name=name;
     this.number=number;
     this.mail=email;
     this.password=pass;
     this.resturentname=resname;
     this.opeingtime=resturentopen;
     this.closeingtime=restruentclose;
     this.resturentnumber=resnumber;
     this.area=area;
     this.city=city;
     this.bank=bankname;
     this.branch=branch;
     this.accountname=accountname;
     this.accountnumber=accountnumber;
     this.banknumber=bankPhnumber;
     this.gpynumber=gpy;
 }
}
class AdminGategory implements Serializable{
    String foodname;
    String foodtype;
    String price;
    String id;
    public AdminGategory(String foodName,String foodgategetry,String price,String id){
        this.foodname=foodName;
        this.foodtype=foodgategetry;
        this.price=price;
        this.id=id;
    }
   // String count;
  // static String salesAmount;


}
class CheckList{
    public boolean prinumber(String number){
        boolean check=true;
        for(int i=0;i<Adminaccess.adDetails.size();i++){
            if(Adminaccess.adDetails.get(i).number.equals(number)){
                check =false;
            }

        }
        return check;
    }
    public boolean primail(String mail){
        boolean check=true;
        for(int i=0;i<Adminaccess.adDetails.size();i++){
            if(Adminaccess.adDetails.get(i).mail.equals(mail)){
                check =false;
            }

        }
        return check;

    }
}
class Adminaccess{
    public static LinkedList<Admin> adDetails=new LinkedList<Admin>();
    public static LinkedList<Admin> adNewDetails=new LinkedList<Admin>();

    public static LinkedList<AdminGategory> adDetailfood=new LinkedList<AdminGategory>();

    static boolean check=false;
    Adminaccess(){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/src/Admin_Account.txt");
            if(inputStream.available()>0) {
                //check=true;
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                adDetails = (LinkedList) objectInputStream.readObject();
                objectInputStream.close();
                inputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void input_AdminDetails(){
        Modifiers modifiers=new Modifiers();
        CheckList checklist=new CheckList();
        System.out.println("Enter The Amin Name");
        String name=Main.sc.nextLine();
        boolean namecheck=modifiers.checkname(name);
        while (!namecheck){
            System.out.println("Enter the Only Alphabets");
            name=Main.sc.nextLine();
            namecheck=modifiers.checkname(name);
        }
        System.out.println("Enter The Number of Admin");
        String number=Main.sc.nextLine();
        boolean checknumber=modifiers.checknumber(number);
        boolean checknumberList=checklist.prinumber(number);
        System.out.println(checknumber+" "+checknumberList);
        while(!checknumber&&checknumberList){
            System.out.println("Enter the Proper Number or Already Account Created this Number");
            number=Main.sc.nextLine();
            checknumber=modifiers.checknumber(number);
            checknumberList=checklist.prinumber(number);
        }

        System.out.println("Enter The E-mail Id");
        String email=Main.sc.nextLine();
        boolean checkmail=modifiers.checkmail(email);
        boolean checkmailList=checklist.primail(email);
        while (!checkmail&&checkmailList){
            System.out.println("Enter the Proper Email or Already Account Created this Email");
            email=Main.sc.nextLine();
             checkmail=modifiers.checkmail(email);
             checkmailList=checklist.primail(email);
        }
        System.out.println("Enter The  Password Of Admin");
        String pass=Main.sc.nextLine();
        boolean checkpass=modifiers.checkpass(pass);
        while (!checkpass){
            System.out.println("Enter the Complex Password atlest one Captial letter And Small latter And Spcial Cheracter and One Numeber");
            pass=Main.sc.nextLine();
            checkpass=modifiers.checkpass(pass);

        }
        System.out.println("Resturent Name");
        String resname=Main.sc.nextLine();
        boolean resnamecheck=modifiers.checkname(resname);
        while (!resnamecheck){
            System.out.println("Enter the Only Alphabets");
            resname=Main.sc.nextLine();
            resnamecheck=modifiers.checkname(resname);
        }
        System.out.println("Enter The Resturant Number");
        String resnumber=Main.sc.nextLine();
        boolean checkresnumber=modifiers.checknumber(resnumber);
        boolean checkresnumberList=checklist.prinumber(resnumber);
        while(!checkresnumber&&!checkresnumberList){
            System.out.println("Enter the Proper Number or Already Account Created this Number");
            resnumber=Main.sc.nextLine();
            checkresnumber=modifiers.checknumber(resnumber);
            checkresnumberList=checklist.prinumber(resnumber);
        }
        System.out.println("Resturent Opening Time HH:MM am|pm");
        String resturentopen=Main.sc.nextLine();
        System.out.println("Resturent Closing Time HH:MM am|pm");
        String restruentclose=Main.sc.nextLine();
        System.out.println("Enter The Area of Resturent");
        String area=Main.sc.nextLine();
        boolean areacheck=modifiers.checkname(area);
        while (!areacheck){
            System.out.println("Enter the Only Alphabets");
            area=Main.sc.nextLine();
            namecheck=modifiers.checkname(area);
        }
        System.out.println("Enter The City Of Resturent");
        String city=Main.sc.nextLine();
        boolean citycheck=modifiers.checkname(city);
        while (!citycheck){
            System.out.println("Enter the Only Alphabets");
            city=Main.sc.nextLine();
            citycheck=modifiers.checkname(city);
        }
        System.out.println("Enter The Bank Name");
        String bankname=Main.sc.nextLine();
        boolean banknamecheck=modifiers.checkname(bankname);
        while (!banknamecheck){
            System.out.println("Enter the Only Alphabets");
            bankname=Main.sc.nextLine();
            banknamecheck=modifiers.checkname(bankname);
        }
        System.out.println("Enter The Account Name");
        String accountname=Main.sc.nextLine();
        boolean accountnamecheck=modifiers.checkname(accountname);
        while (!accountnamecheck){
            System.out.println("Enter the Only Alphabets");
            accountname=Main.sc.nextLine();
            accountnamecheck=modifiers.checkname(accountname);
        }
        System.out.println("Enter Account Number");
        String accountnumber=Main.sc.nextLine();
        boolean accountnumbercheck=modifiers.checkaccountnumber(accountnumber);
        while (!accountnumbercheck){
            System.out.println("Enter the");
            accountnumber=Main.sc.nextLine();
            accountnumbercheck=modifiers.checkname(accountnumber);
        }

        System.out.println("Enter the Branch");
        String branch=Main.sc.nextLine();
        boolean branchcheck=modifiers.checkname(branch);
        while (!branchcheck){
            System.out.println("Enter the Only Alphabets");
            branch=Main.sc.nextLine();
            branchcheck=modifiers.checkname(branch);
        }
        System.out.println("Enter The BankNumber");
        String bankPhnumber=Main.sc.nextLine();
        boolean Phnumbercheck=modifiers.checknumber(bankPhnumber);
        boolean chckbanknumberList=checklist.prinumber(bankPhnumber);
        while(!Phnumbercheck&&!chckbanknumberList){
            System.out.println("Enter the Proper Number or Already Account Created this Number");
            bankPhnumber=Main.sc.nextLine();
            Phnumbercheck=modifiers.checknumber(bankPhnumber);
            chckbanknumberList=checklist.prinumber(bankPhnumber);
        }
        System.out.println("Enter The goole pay  Number");
        String gpy=Main.sc.nextLine();
        boolean gpynumbercheck=modifiers.checknumber(gpy);
        boolean chckgpynumberList=checklist.prinumber(gpy);
        while(!gpynumbercheck&&!chckgpynumberList){
            System.out.println("Must be Bank Account number and gpy number must be same");
            gpy=Main.sc.nextLine();
            gpynumbercheck=modifiers.checknumber(gpy);
            chckgpynumberList=checklist.prinumber(gpy);
        }

        Admin ad=new Admin(name,number,email,pass,resname,resturentopen,restruentclose,area,city,bankname,accountnumber,branch,bankPhnumber,gpy,resnumber,accountname);
        adDetails.add(ad);
        int subEmail=email.indexOf(".");
        String mailsub=email.substring(0,subEmail);
        FileOutputStream outputStream = null;

        try {
            File myObj = new File(mailsub+".txt");
            myObj.createNewFile();

            outputStream = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/src/Admin_Account.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream .writeObject(adDetails);
            objectOutputStream .close();
            System.out.println(adDetails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static boolean checkAdminAccesschenge(String email,String password){
        boolean chack=false;
        for (int i=0;i<Adminaccess.adDetails.size();i++){
            if(Adminaccess.adDetails.get(i).mail.equals(email)&&Adminaccess.adDetails.get(i).password.equals(password)){
                chack=true;
                System.out.println("Enter The New Password");
                String newPass=Main.sc.nextLine();
                Adminaccess.adDetails.get(i).password=newPass;
            }
        }
        FileOutputStream outputStream = null;

        try {

            outputStream = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/src/Admin_Account.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream .writeObject(adDetails);
            objectOutputStream .close();
            System.out.println(adDetails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return chack;
    }
    public static boolean checkAdminAccess(String email,String password){
        boolean chack=false;
        for (int i=0;i<Adminaccess.adDetails.size();i++){
            if(Adminaccess.adDetails.get(i).mail.equals(email)&&Adminaccess.adDetails.get(i).password.equals(password)){
                chack=true;
            }
        }
        return chack;
    }
    public LinkedList<AdminGategory> getAdminStatus(String mailsub){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/"+mailsub+".txt");
            if(inputStream.available()>0) {
                //check=true;
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                adDetailfood = (LinkedList<AdminGategory>) objectInputStream.readObject();
                objectInputStream.close();
                inputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return adDetailfood;
    }
    public void admin_Login(String email){
        int subEmail=email.indexOf(".");
        String mailsub=email.substring(0,subEmail);
        LinkedList<AdminGategory> foodDeatils= getAdminStatus(mailsub);

        boolean allow=true;
        while (allow) {
            System.out.println("1 for view Food Product\n2 for Add Food\n3 for Delete Food\n4 for Modifiy the Food Price\n5 for Exit");
            int num = Integer.parseInt(Main.sc.nextLine());
            switch (num) {
                case 1:
                    for(int i=0;i<foodDeatils.size();i++){
                        System.out.println(foodDeatils.get(i).id+"   "+foodDeatils.get(i).foodname+"  "+foodDeatils.get(i).foodtype+"  "+foodDeatils.get(i).price);
                    }
                    break;
                case 2:
                    System.out.println("Enter the Food Name");
                    String foodName=Main.sc.nextLine();
                    System.out.println("Enter the Food Gategery");
                    String foodgategetry=Main.sc.nextLine();
                    System.out.println("Enter the Food Price");
                    String price=Main.sc.nextLine();
                    System.out.println("Enter the Id");
                    String id=Main.sc.nextLine();
                    AdminGategory adgategory=new AdminGategory(foodName,foodgategetry,price,id);
                    foodDeatils.add(adgategory);
                    FileOutputStream outputStream = null;

                    try {
                        File myObj = new File(mailsub+".txt");
                        myObj.createNewFile();
                        outputStream = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/"+mailsub+".txt");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        objectOutputStream .writeObject(foodDeatils);
                        objectOutputStream .close();
                        System.out.println(foodDeatils);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                   // System.out.println("Enter the Food Name");
                   // String foodName1=Main.sc.nextLine();
                   // System.out.println("Enter the Food Gategery");
                    // String foodgategetry1=Main.sc.nextLine();
                    System.out.println("Enter the Food Id");
                    String foodID=Main.sc.nextLine();
                    for(int i=0;i<foodDeatils.size();i++)
                    {
                        if(foodDeatils.get(i).id.equals(foodID)){
                               foodDeatils.remove(i);
                        }
                    }
                    FileOutputStream outputStream1 = null;

                    try {

                        outputStream1 = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/"+mailsub+".txt");
                        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(outputStream1);
                        objectOutputStream1 .writeObject(foodDeatils);
                        objectOutputStream1 .close();
                        System.out.println(foodDeatils);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                   // break;
                case 4:
//                    System.out.println("Enter the Food Name");
//                    String foodName2=Main.sc.nextLine();
//                    System.out.println("Enter the Food Gategery");
//                    String foodgategetry2=Main.sc.nextLine();
                    System.out.println("Enter The Food Id");
                    String foodId=Main.sc.nextLine();
                    System.out.println("Enter The Modify Price");
                    String foodPrice=Main.sc.nextLine();

                    for(int i=0;i<foodDeatils.size();i++)
                    {
                        if(foodDeatils.get(i).id.equals(foodId)){
                                foodDeatils.get(i).price=foodPrice;
                        }
                    }
                    FileOutputStream outputStream2 = null;

                    try {

                        outputStream2 = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/"+mailsub+".txt");
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream2);
                        objectOutputStream2 .writeObject(foodDeatils);
                        objectOutputStream2 .close();
                        System.out.println(foodDeatils);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    allow=false;
                    break;

            }
        }

    }

    public void change_password(){
        Modifiers modifiers=new Modifiers();
        System.out.println("Enter the Gmail");
        String email=Main.sc.nextLine();
        boolean checkmail=modifiers.checkmail(email);
        while (!checkmail){
            System.out.println("Enter the Proper Email");
            email=Main.sc.nextLine();
            checkmail=modifiers.checkmail(email);
        }
        System.out.println("Enter the Password");
        String password=Main.sc.nextLine();
        boolean checkemail=checkAdminAccesschenge(email,password);
        if(checkemail){
            System.out.println("The Password Change Success Fuly");
        }else {
            System.out.println("Enter the Correct Email id And Password");
            change_password();
        }


    }
    public void admin_Login_Access(){
        Modifiers modifiers=new Modifiers();
        System.out.println("Enter the Gmail");
        String email=Main.sc.nextLine();
        boolean checkmail=modifiers.checkmail(email);
        while (!checkmail){
            System.out.println("Enter the Proper Email");
            email=Main.sc.nextLine();
            checkmail=modifiers.checkmail(email);
        }
        System.out.println("Enter the Password");
        String password=Main.sc.nextLine();
        boolean checkemail=checkAdminAccess(email,password);
        if(checkemail){
            admin_Login(email);
        }else {
            System.out.println("Enter the Correct Email id And Password");
            admin_Login_Access();
        }


    }
  public static void admin_menu(){
      boolean allow=true;
      while(allow){
          try{
              System.out.println("\nAdmin\n1. Create Account \n2. Login \n3. Change password \n4.Goback to previous page \nEnter your choice :");
              int n =Integer.parseInt(Main.sc.nextLine());
              switch(n){
                  case 1:
                      Adminaccess ad=new Adminaccess();
                      ad.input_AdminDetails();
                      break;
                  case 2:
                      Adminaccess ad1=new Adminaccess();
                      ad1.admin_Login_Access();
                      break;
                  case 3:
                  Adminaccess ad2=new Adminaccess();

                   ad2.change_password();
                   break;
                  case 4:
                      allow=false;
                      break;
              }
          }catch(InputMismatchException e){
              System.out.println("Invalid input!!");

              admin_menu();
          }
      }

  }
}
/*-----------------------------------------------------------------------------------------------------------------------*/

public class Main {
    static   Scanner sc = new Scanner(System.in);

    public void main() throws Exception{
        while(true){
            try{
                System.out.println("\n--------\"FOOD APP\"-------\n1. Admin \n2. User  \nEnter your choice :");
                int n = Integer.parseInt(sc.nextLine());
                switch(n){
                    case 1:

                         Adminaccess.admin_menu();
                        break;

                    case 2:
                        Useraccess user = new Useraccess();
                        user.user_menu();
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input!!");
                main();

            }
        }
    }
    public static void main(String args[]) throws Exception{
        Main main = new Main();
        main.main();
       }
}