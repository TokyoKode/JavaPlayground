package exceptions;

/**
 * Created by Tokyo on 02/07/15.
 */
public class DeviceAlreadyExists extends MyException{

    String deviceName;

    public DeviceAlreadyExists(String deviceName){
        this.deviceName = deviceName;
    }

    @Override
    public void printMessage() {
        System.out.println("Device " +deviceName + " is already registered. Please try a different ID");
    }
}
