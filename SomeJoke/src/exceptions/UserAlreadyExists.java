package exceptions;

/**
 * Created by Tokyo on 02/07/15.
 */
public class UserAlreadyExists extends MyException{

    String userID;

    public UserAlreadyExists(String userID){
        this.userID = userID;
    }

    @Override
    public void printMessage() {
        System.out.println("User " + userID + " is already registered. Please try a different ID");
    }
}
