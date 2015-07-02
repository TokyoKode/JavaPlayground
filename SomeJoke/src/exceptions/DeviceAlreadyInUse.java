package exceptions;

/**
 * Created by Tokyo on 02/07/15.
 */
public class DeviceAlreadyInUse extends MyException{
    public DeviceAlreadyInUse(){}

    @Override
    public void printMessage() {
        System.out.println("This device is currently in use");
    }
}
