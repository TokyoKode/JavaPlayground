package exceptions;

/**
 * Created by Tokyo on 02/07/15.
 */
public class AccessNotFound extends MyException {

    String userID;
    String deviceName;


    public AccessNotFound(String userID, String deviceName){
        this.deviceName = deviceName;
        this.userID = userID;
    }

    @Override
    public void printMessage() {
        System.out.println(userID + " doesn't have access to device: " + deviceName);
    }
}
