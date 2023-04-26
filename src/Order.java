class Bill{
    public static void billGenerate(int total){
        for (int i=0;i<CreateUser.userCart.size();i++){
            System.out.println("Food Name:"+CreateUser.userCart.get(i).foodname+"    "+"Resturent:"+CreateUser.userCart.get(i).resturent+"   "+"Price:"+CreateUser.userCart.get(i).foodprice+"   "+"Quantity:"+CreateUser.userCart.get(i).count+"  "+"Price Of This Product:"+Integer.parseInt((CreateUser.userCart.get(i).count))*Integer.parseInt((CreateUser.userCart.get(i).foodprice)));
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                  Total   -   "+total);

    }
    public static boolean checkAmount(int Pay,int total){
        boolean check=false;
        if (Pay==total){
            check=true;

        }
        return check;
    }
}
public class Order implements Runnable{
    @Override
    public void run() {
        System.out.println("Enter==>\n 1 for The Gpay Payment\n 2 for Cash On Delivery");
        int input=Integer.parseInt(Main.sc.nextLine());
        switch (input){
            case 1:
                int tottal=0;
                for (int i=0;i<CreateUser.userCart.size();i++){
                    tottal=tottal+Integer.parseInt((CreateUser.userCart.get(i).count))*Integer.parseInt((CreateUser.userCart.get(i).foodprice));
                    //System.out.println(Integer.parseInt((CreateUser.userCart.get(i).count))+"hleo this is check"+Integer.parseInt((CreateUser.userCart.get(i).foodprice)));
                }
                System.out.println("You Want Pay"+tottal);
                int pay=Main.sc.nextInt();
                boolean cheak=Bill.checkAmount(pay,tottal);
                while (!cheak) {
                    System.out.println("Enter The Amount"+tottal);
                     pay=Main.sc.nextInt();
                     cheak=Bill.checkAmount(pay,tottal);

                }
                System.out.println("Amount Payed Suceess fully");
                Bill.billGenerate(tottal);
                System.out.println();
                System.out.println();
                break;

            case 2:
                int tottal1=0;
                for (int i=0;i<CreateUser.userCart.size();i++){
                    tottal1=tottal1+Integer.parseInt((CreateUser.userCart.get(i).count))*Integer.parseInt((CreateUser.userCart.get(i).foodprice));
                }
                System.out.println("You Want Pay"+tottal1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Delivery Boy reached");
                int pay1=Main.sc.nextInt();
                System.out.println("Amount Payed Suceess fully");
                Bill.billGenerate(tottal1);
                System.out.println();
                System.out.println();
                break;

        }
    }
}
