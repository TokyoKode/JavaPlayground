package domain;

/**
 * Created by Tokyo on 02/07/15.
 */
public class User {
    private String name;
    private String userID;
    private long contact;

    public User(){}

    public User(String userID, String name){
        this.name = name; this.userID=userID;
    }

    public User(String userID, String name, long contact){
        this.name = name;
        this.userID= userID;
        this.contact=contact;
    }

    public String getName(){
        return name;
    }

    public String getUserID(){
        return userID;
    }
    public long getContact(){
        return contact;
    }

    public void setContact(long newContact){
        contact = newContact;
    }

    public void print(String format){
        System.out.printf(format,userID,name,contact );
    }

}
