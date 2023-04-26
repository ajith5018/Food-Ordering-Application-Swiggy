import java.io.*;
import java.util.LinkedList;

class UserAccount implements Serializable {
    String name;
    String number;
    String mail;
    String password;
    String area;
    String city;
    String accountnumber;
    String bank;
    String accountname;
    String branch;
    String banknumber;
    String gpynumber;
    public UserAccount(String name,String number,String email,String pass,String area,String city,String bankname,String accountnumber,String branch,String bankPhnumber,String gpy,String accountname){
        this.name=name;
        this.number=number;
        this.mail=email;
        this.password=pass;
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
class Cart{
   String foodname;
   String count;
   String resturent;
   String foodprice;
   String id;
    //String foodname,String foodprice,String foodresturent,String quantity
   Cart(String id,String foodname,String foodprice,String foodresturent,String quantity){
      this.foodname=foodname;
      this.count=quantity;
      this.resturent=foodresturent;
      this.foodprice=foodprice;
      this.id=id;
   }
}
class CreateUser {
    public static LinkedList<UserAccount> userDetails=new LinkedList<UserAccount>();
    public static LinkedList<Admin> userLocationHotel=new LinkedList<Admin>();
    public static LinkedList<AdminGategory> userLocationHotelGetagort=new LinkedList<AdminGategory>();
    public static LinkedList<Cart> userCart=new LinkedList<Cart>();
    static String location;
    static String city;

    CreateUser(){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/src/User_Account.txt");
            if(inputStream.available()>0) {
               // check=true;
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                userDetails = (LinkedList) objectInputStream.readObject();
                objectInputStream.close();
                inputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void userCreate() {
        Modifiers modifiers = new Modifiers();
        CheckList checklist = new CheckList();
        System.out.println("Enter The User Name");
        String name = Main.sc.nextLine();
        boolean namecheck = modifiers.checkname(name);
        while (!namecheck) {
            System.out.println("Enter the Only Alphabets");
            name = Main.sc.nextLine();
            namecheck = modifiers.checkname(name);
        }
        System.out.println("Enter The Number of Admin");
        String number = Main.sc.nextLine();
        boolean checknumber = modifiers.checknumber(number);
        boolean checknumberList = checklist.prinumber(number);
        System.out.println(checknumber + " " + checknumberList);
        while (!checknumber && checknumberList) {
            System.out.println("Enter the Proper Number or Already Account Created this Number");
            number = Main.sc.nextLine();
            checknumber = modifiers.checknumber(number);
            checknumberList = checklist.prinumber(number);
        }

        System.out.println("Enter The E-mail Id");
        String email = Main.sc.nextLine();
        boolean checkmail = modifiers.checkmail(email);
        boolean checkmailList = checklist.primail(email);
        while (!checkmail && checkmailList) {
            System.out.println("Enter the Proper Email or Already Account Created this Email");
            email = Main.sc.nextLine();
            checkmail = modifiers.checkmail(email);
            checkmailList = checklist.primail(email);
        }
        System.out.println("Enter The  Password Of User");
        String pass = Main.sc.nextLine();
        boolean checkpass = modifiers.checkpass(pass);
        while (!checkpass) {
            System.out.println("Enter the Complex Password atlest one Captial letter And Small latter And Spcial Cheracter and One Numeber");
            pass = Main.sc.nextLine();
            checkpass = modifiers.checkpass(pass);

        }
        System.out.println("Enter The Area ");
        String area = Main.sc.nextLine();
        boolean areacheck = modifiers.checkname(area);
        while (!areacheck) {
            System.out.println("Enter the Only Alphabets");
            area = Main.sc.nextLine();
            namecheck = modifiers.checkname(area);
        }
        System.out.println("Enter The City");
        String city = Main.sc.nextLine();
        boolean citycheck = modifiers.checkname(city);
        while (!citycheck) {
            System.out.println("Enter the Only Alphabets");
            city = Main.sc.nextLine();
            citycheck = modifiers.checkname(city);
        }
        System.out.println("Enter The Bank Name");
        String bankname = Main.sc.nextLine();
        boolean banknamecheck = modifiers.checkname(bankname);
        while (!banknamecheck) {
            System.out.println("Enter the Only Alphabets");
            bankname = Main.sc.nextLine();
            banknamecheck = modifiers.checkname(bankname);
        }
        System.out.println("Enter The Account Name");
        String accountname = Main.sc.nextLine();
        boolean accountnamecheck = modifiers.checkname(accountname);
        while (!accountnamecheck) {
            System.out.println("Enter the Only Alphabets");
            accountname = Main.sc.nextLine();
            accountnamecheck = modifiers.checkname(accountname);
        }
        System.out.println("Enter Account Number");
        String accountnumber = Main.sc.nextLine();
        boolean accountnumbercheck = modifiers.checkaccountnumber(accountnumber);
        while (!accountnumbercheck) {
            System.out.println("Enter the");
            accountnumber = Main.sc.nextLine();
            accountnumbercheck = modifiers.checkname(accountnumber);
        }

        System.out.println("Enter the Branch");
        String branch = Main.sc.nextLine();
        boolean branchcheck = modifiers.checkname(branch);
        while (!branchcheck) {
            System.out.println("Enter the Only Alphabets");
            branch = Main.sc.nextLine();
            branchcheck = modifiers.checkname(branch);
        }
        System.out.println("Enter The BankNumber");
        String bankPhnumber = Main.sc.nextLine();
        boolean Phnumbercheck = modifiers.checknumber(bankPhnumber);
        boolean chckbanknumberList = checklist.prinumber(bankPhnumber);
        while (!Phnumbercheck && !chckbanknumberList) {
            System.out.println("Enter the Proper Number or Already Account Created this Number");
            bankPhnumber = Main.sc.nextLine();
            Phnumbercheck = modifiers.checknumber(bankPhnumber);
            chckbanknumberList = checklist.prinumber(bankPhnumber);
        }
        System.out.println("Enter The goole pay  Number");
        String gpy = Main.sc.nextLine();
        boolean gpynumbercheck = modifiers.checknumber(gpy);
        boolean chckgpynumberList = checklist.prinumber(gpy);
        while (!gpynumbercheck && !chckgpynumberList) {
            System.out.println("Must be Bank Account number and gpy number must be same");
            gpy = Main.sc.nextLine();
            gpynumbercheck = modifiers.checknumber(gpy);
            chckgpynumberList = checklist.prinumber(gpy);
        }
        UserAccount ad=new UserAccount(name,number,email,pass,area,city,bankname,accountnumber,branch,bankPhnumber,gpy,accountname);
        userDetails.add(ad);
        int subEmail=email.indexOf(".");
        String mailsub=email.substring(0,subEmail);
        FileOutputStream outputStream = null;

        try {
            File myObj = new File(mailsub+".txt");
            myObj.createNewFile();
            outputStream = new FileOutputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/src/User_Account.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream .writeObject(userDetails);
            objectOutputStream .close();
            System.out.println(userDetails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkUserAccess(String email,String password){
        boolean chack=false;
        new Adminaccess();
        for (int i=0;i<CreateUser.userDetails.size();i++){
            if(CreateUser.userDetails.get(i).mail.equals(email)&&CreateUser.userDetails.get(i).password.equals(password)){
                chack=true;
            }
            System.out.println("check "+i);
        }
        return chack;
    }
    public LinkedList<AdminGategory> getAdminStatus1(String mailsub){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/ajith-zt590/Documents/java/swiggy/Swiggy/"+mailsub+".txt");
            if(inputStream.available()>0) {
                //check=true;
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                userLocationHotelGetagort = (LinkedList<AdminGategory>) objectInputStream.readObject();
                objectInputStream.close();
                inputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userLocationHotelGetagort;
    }
    public LinkedList<AdminGategory> get_FoodDetails(String mail){
        int subEmail=mail.indexOf(".");
        String mailsub=mail.substring(0,subEmail);
        LinkedList<AdminGategory> foodDeatils= getAdminStatus1(mailsub);
        return foodDeatils;
    }
    public void addCart(String id,String foodname,String foodprice,String foodresturent,String quantity){
        Cart cart=new Cart(id,foodname,foodprice,foodresturent,quantity);
        userCart.add(cart);
    }
    public void user_Login(String email){
//        String location;
//        String city;
        for(int i=0;i<userDetails.size();i++){
            if(userDetails.get(i).mail.equals(email)){
                location=userDetails.get(i).area;
                //city=userDetails.get(i).city;
            }
        }
        for(int i=0;i<Adminaccess.adDetails.size();i++){
            if(Adminaccess.adDetails.get(i).area.equals(location)){
                userLocationHotel.add(Adminaccess.adDetails.get(i));
            }
        }
        boolean allow=true;
        while (allow){
            System.out.println("Enter The\n 1 for View Near by Resturent and Food Items\n 2 for Search Food Near by Resturent and Add to Cart\n 3 for Cart and  Modification  Order and Ordered\n 4 for Exit");
            int input =Integer.parseInt(Main.sc.nextLine());
            switch (input){
                case 1:
                    for (int i=0;i<userLocationHotel.size();i++){
                        System.out.println("Resturent:"+userLocationHotel.get(i).name+"      "+"Resturent Location:"+userLocationHotel.get(i).area+"     "+"Resturent Time:"+userLocationHotel.get(i).opeingtime+" to "+userLocationHotel.get(i).closeingtime+"     "+"Contact:"+userLocationHotel.get(i).number);
                        System.out.println();
                        String mail=userLocationHotel.get(i).mail;
                        LinkedList<AdminGategory> list=get_FoodDetails(mail);
                        for (int j=0;j<list.size();j++){
                            System.out.println("Food Id:"+list.get(i).id+"    "+"Food Name:"+list.get(j).foodname+"      "+"Food Type:"+list.get(j).foodtype+"      "+"Food Price:"+list.get(j).price);
                        }
                        System.out.println();
                        System.out.println();

                    }
                    break;
                case 2:
                    System.out.println("Enter the Food Name");
                    String foodname=Main.sc.nextLine();
                    for (int i=0;i<userLocationHotel.size();i++){
                        String mail=userLocationHotel.get(i).mail;
                        LinkedList<AdminGategory> list=get_FoodDetails(mail);
                        for (int j=0;j<list.size();j++) {
                            if (list.get(j).foodname.equals(foodname)) {
                                if(j==0){
                                System.out.println("Resturent:" + userLocationHotel.get(i).name + "      " + "Resturent Location:" + userLocationHotel.get(i).area + "     " + "Resturent Time:" + userLocationHotel.get(i).opeingtime + " to " + userLocationHotel.get(i).closeingtime + "     " + "Contact:" + userLocationHotel.get(i).number);}
                                System.out.println();
                                System.out.println("Food Id"+list.get(j).id+"    "+"Food Name:" + list.get(j).foodname + "      " + "Food Type:" + list.get(j).foodtype + "      " + "Food Price:" + list.get(j).price);
                            }
                        }
                        System.out.println();
                        System.out.println();

                    }
                    System.out.println("Enter Resturent Name");
                    String foodresturent=Main.sc.nextLine();
                    System.out.println("Enter Food Id");
                    String foodId=Main.sc.nextLine();
//                    System.out.println("Enter The Price for Food");
                    String foodprice="";
                    for (int i=0;i<userLocationHotel.size();i++) {
                        if (userLocationHotel.get(i).name.equals(foodresturent)) {
                            String mail = userLocationHotel.get(i).mail;
                            LinkedList<AdminGategory> list = get_FoodDetails(mail);
                            for (int j = 0; j < list.size(); j++) {
                                if (list.get(j).id.equals(foodId)) {
                                    foodprice = list.get(j).price;
                                }
                            }
                        }
                    }
                    System.out.println("Enter the Number Of Quantity");
                    String quantity=Main.sc.nextLine();
                    addCart(foodId,foodname,foodprice,foodresturent,quantity);
                    break;
                case 3:
                    boolean innerAllow=true;
                    while (innerAllow) {
                        System.out.println("Enter==>\n 1 for View Cart\n 2 for add Quantity\n 3 for Delete Quantity\n 4 for Delete Food\n 5 for Odered Food \n 6 for Exit ");
                        int innerinput=Integer.parseInt(Main.sc.nextLine());
                        switch (innerinput){
                            case 1:
                                for(int i=0;i<userCart.size();i++){
                                    System.out.println("Food Id:"+userCart.get(i).id+"    "+"Food Name:"+userCart.get(i).foodname+"    "+"Resturent:"+userCart.get(i).resturent+"   "+"Price:"+userCart.get(i).foodprice+"   "+"Quantity"+userCart.get(i).count);
                                }
                                break;
                            case 2:
                                for(int i=0;i<userCart.size();i++){
                                    System.out.println("Food Id:"+userCart.get(i).id+"   "+"Food Name:"+userCart.get(i).foodname+"    "+"Resturent:"+userCart.get(i).resturent+"   "+"Price:"+userCart.get(i).foodprice+"   "+"Quantity"+userCart.get(i).count);
                                }
                                System.out.println("Enter The Food name to increase the Quantity");
                                String foodnameI=Main.sc.nextLine();
                                System.out.println("Enter the resturent name");
                                String Rest=Main.sc.nextLine();
                                System.out.println("Enter the Increase the Quantity");
                                String inQuntity=Main.sc.nextLine();
                                for(int i=0;i<userCart.size();i++){
                                    if(userCart.get(i).resturent.toLowerCase().equals(Rest.toLowerCase())&&userCart.get(i).foodname.toLowerCase().equals(foodnameI.toLowerCase())){
                                        userCart.get(i).count=String.valueOf(Integer.parseInt(userCart.get(i).count)+Integer.parseInt(inQuntity));
                                    }
                                }
                                break;
                            case 3:
                                for(int i=0;i<userCart.size();i++){
                                    System.out.println("Food Name:"+userCart.get(i).foodname+"    "+"Resturent:"+userCart.get(i).resturent+"   "+"Price:"+userCart.get(i).foodprice+"   "+"Quantity"+userCart.get(i).count);
                                }
                                System.out.println("Enter The Food name ID to decrese the Quantity");
                                String foodname2=Main.sc.nextLine();
                                System.out.println("Enter the resturent name");
                                String Rest2=Main.sc.nextLine();
                                System.out.println("Enter the decrease the Quantity");
                                String inQuntity2=Main.sc.nextLine();
                                for(int i=0;i<userCart.size();i++){
                                    if(userCart.get(i).resturent.toLowerCase().equals(Rest2.toLowerCase())&&userCart.get(i).id.equals(foodname2)){
                                        userCart.get(i).count=String.valueOf(Integer.parseInt(userCart.get(i).count)-Integer.parseInt(inQuntity2));
                                        if(userCart.get(i).count=="0"){
                                            userCart.remove(i);
                                        }
                                    }
                                }
                                if(userCart.size()==0){
                                    innerAllow=false;
                                }
                                break;
                            case 4:
                                for(int i=0;i<userCart.size();i++){
                                    System.out.println("Food Name:"+userCart.get(i).foodname+"    "+"Resturent:"+userCart.get(i).resturent+"   "+"Price:"+userCart.get(i).foodprice+"   "+"Quantity"+userCart.get(i).count);
                                }
                                System.out.println("Enter The Food To Delete");
                                String foodname3=Main.sc.nextLine();
                                System.out.println("Enter the resturent name");
                                String Rest3=Main.sc.nextLine();
                                for(int i=0;i<userCart.size();i++){
                                    if(userCart.get(i).resturent.toLowerCase().equals(Rest3.toLowerCase())&&userCart.get(i).id.equals(foodname3)){

                                            userCart.remove(i);

                                    }
                                }
                                if(userCart.size()==0){
                                    innerAllow=false;
                                }
                                break;
                            case 5:
                                Order th=new Order();
                                Thread ad=new Thread(th);
                                ad.start();
                                try {
                                    ad.join();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println();
                                System.out.println("Tanking You");
                                Main.sc.nextLine();
                                break;
                            case 6:
                                innerAllow=false;
                                break;
                        }
                       // Main.sc.nextLine();

                    }
                    break;
                case 4:
                    allow=false;
                    break;

            }
        }

    }
    public void user_Login_Access(){
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
        boolean checkemail=checkUserAccess(email,password);
        if(checkemail){
            System.out.println("Use Login Success Fully");
            user_Login(email);
        }else {
            System.out.println("Enter the Correct Email id And Password");
            user_Login_Access();
        }


    }
}


public class Useraccess {
    public void user_menu() {
        boolean allow = true;
        while (allow) {
            System.out.println("Enter The==>\n 1 for Create User Account\n 2 for Login User Account\n3 for Logout");
            int input =Integer.parseInt(Main.sc.nextLine());
            switch (input) {
                case 1:
                    CreateUser ob=new CreateUser();
                    ob.userCreate();
                    break;
                case 2:
                    CreateUser obj=new CreateUser();
                    obj.user_Login_Access();
                    break;
                case 3:
                    allow=false;


            }
        }
    }
}
