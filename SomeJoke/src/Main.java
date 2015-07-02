import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import domain.Device;
import domain.Kore;
import domain.User;
import exceptions.InvalidChoice;

public class Main {

	public static void main(String[] args)throws Exception{
        populateKore();
		dialog();
		return;
	}

    private static void populateKore(){
        //Populating with 3 devices;
        Kore.registerDevice("MacbookAir");
        Kore.registerDevice("Asus eePC");
        Kore.registerDevice("Ipad");
        //Populating with 3 users
        Kore.registerUser("tokyo", "joao abrantes", 917653908);
        Kore.registerUser("drift", "cullero", 969696969);
        Kore.registerUser("yoda", "voda-gone", 911991199);
    }


	private static void dialog() throws IOException {
		boolean okay = true;
		while(okay){
            Runtime.getRuntime().exec("clear");
            System.out.print(menu());
			try{
				okay = prompt();
			}
			catch(InvalidChoice e){
				e.printMessage();
				okay = true;
			}
			catch(NumberFormatException e){
				System.out.println("Sorry but you must select an available choice");
				okay = true;
			}
			catch(IOException e){
				System.out.println();
				okay= false;
			}
		}
	}



    private static String menu(){
        StringBuilder menuText = new StringBuilder();
        menuText.append("Bom dia, por favor escolha uma das seguintes opções:\n");
        menuText.append("1- Ver dispositivos\n");
        menuText.append("2- Ver Pessoas\n");
        menuText.append("0- Sair\n");
        return menuText.toString();
    }

	private static boolean prompt() throws NumberFormatException, IOException, InvalidChoice{
		System.out.print(" >");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		if (choice < 0 || choice >2){
			throw new InvalidChoice("The option you entered is not valid: " +choice) ;
		}
		switch(choice){
		case 1: 
            seeDevices();
			return true;
		case 2:
			seeUsers();
			return true;
		case 0:
			System.out.println("Good Bye!");
			return false;
		}
		return true;
	}

    private static void seeDevices(){
        Kore.printDevices();
        System.out.println("\nPress any key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void seeUsers(){
        Kore.printUsers();
        System.out.println("\nPress any key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}