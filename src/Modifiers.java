
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modifiers {
    public boolean checkname(String name){
    Pattern ptr=Pattern.compile("[a-zA-Z\\s]*");
        Matcher match = ptr.matcher(name);
        return match.matches();
    }
    public boolean checknumber(String number){
        Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        Matcher match = ptrn.matcher(number);
        return match.matches();
    }
    public boolean checkmail(String mail){
        Pattern email=Pattern.compile("^[a-z]+?[a-zA-Z0-9_#$%&.]+@(.+)$");
        Matcher match = email.matcher(mail);
        return match.matches();
    }
    public boolean checkpass(String pass){
        Pattern pw=Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
        Matcher match = pw.matcher(pass);
        return match.matches();
    }
    public boolean checkaccountnumber(String accountnumber){
          Pattern ac=Pattern.compile("[1-9]{1}[0-9]{10}");
          Matcher match=ac.matcher(accountnumber);
          return  match.matches();
    }
}
