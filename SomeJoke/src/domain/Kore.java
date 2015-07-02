package domain;

import exceptions.DeviceAlreadyExists;
import exceptions.UserAlreadyExists;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tokyo on 02/07/15.
 */
public class Kore {

    private static HashMap<String, Device> devices = new HashMap<String,Device>();
    private static HashMap<String, User> users = new HashMap<String,User>();
    private static String format = "%-15s%-15s%-20s%n";

    public static void registerUser(String userID, String name, long contact) throws  UserAlreadyExists{
        if (users.containsKey(userID)){
            throw new UserAlreadyExists(userID);
        }
        else{
            users.put(userID,new User(userID,name,contact));
        }
    }

    //TODO: note that this only allows 1 device per name; (1 name = 1 device) and the name is therefore unique.
    public static void registerDevice (String deviceName) throws DeviceAlreadyExists{
        if (devices.containsKey(deviceName)){
            throw new DeviceAlreadyExists(deviceName);
        }
        else{
            devices.put(deviceName,new Device(deviceName));
        }
    }

    public static ArrayList<User> getUsers(){
        return new ArrayList<User>(users.values());
    }

    public static ArrayList<Device> getDevices(){
        return new ArrayList<Device>(devices.values());
    }

    public static void printUsers(){
        System.out.println("##################   LIST OF USERS ###################");
        for (User user:users.values()){
            user.print(format);
        }
    }

    public static void printDevices(){
        System.out.println("##################   LIST OF DEVICES ###################");
        for (Device device :devices.values()){
            device.print();
        }
    }

}
