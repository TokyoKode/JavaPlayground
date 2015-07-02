package domain;

import exceptions.AccessNotFound;
import exceptions.DeviceAlreadyInUse;
import exceptions.UserHasAccess;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tokyo on 02/07/15.
 */
public class Device {
    private String name;
    private double price;
    private HashMap<String,User> accessList = new HashMap<String,User>();
    private User operator;

    public Device(){}

    public Device(String name){
        this.name = name;
    }

    public Device(String name, double price){
        this.name = name; this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public ArrayList<User> getAccessList(){
        ArrayList<User> answer = new ArrayList<>(accessList.values());
        return answer;
    }

    public int countUsers(){
        return accessList.size();
    }

    public void addToAccessList(User user) throws UserHasAccess{
        String userID = user.getUserID();
        if(accessList.containsKey(userID)){
            throw new UserHasAccess(userID,name);
        }
        else{
            accessList.put(userID,user);
        }
    }

    public boolean userHasAccess(User user){
        if(accessList.containsKey(user.getUserID()))
            return true;
        else
            return false;
    }

    public void operate(User user) throws DeviceAlreadyInUse{
        String userID = user.getUserID();
        if(operator == null){
            if(!userHasAccess(user)){
                throw new AccessNotFound(userID,name);
            }
            else{
                operator = user;
            }
        }
        else{
            throw new DeviceAlreadyInUse();
        }
    }

    public void print(){
        System.out.println(name);
    }
}
