package exceptions;

/**
 * Created by Tokyo on 02/07/15.
 */
public class UserHasAccess extends MyException{

    private String userID;
    private String deviceName;

    public UserHasAccess(String userID, String deviceName){
        this.userID=userID;
        this.deviceName = deviceName;
    }

    @Override
    public void printMessage() {
        System.out.println(userID + " already has access to " + deviceName);
    }
}
