import java.util.Scanner;
import java.util.Arrays;

/*
  Author: Reem Mohamed
  Study program: DT
*/


public class Assignment1 {
    static Scanner in = new Scanner(System.in);
    // an array to use for testing, replace as needed to test your code
    static String[][] guestList = {{"Adam Ason", "35"}, //0 0  0 1
            {"Berta Bson", "70"}, //1 0   1 1
            {"Ceasar Cson", "12"}, //2 0  2 1
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
    };



    public static void printMenu(){
        System.out.println("Here is the main menu to choose from, choose a number: "); //you don't need to keep this line
        // Add your code here
        System.out.println("\n       Menu");
        System.out.println("0. Go out of the menu");
        System.out.println("1. See the guest list");
        System.out.println("2. See the guest list as statistics");
        System.out.println("3. Add a guest");
        System.out.println("4. Change a guest name");
        System.out.println("5. Change a guest age");
        System.out.println("6. remove a guest");
        System.out.println("7. Change places of two guests");




        int option = in.nextInt();
        //metoden anropas enligt varje valt val
        switch (option) {
            case 0:
                break; //avbrytar programmet
            case 1:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printGuestList();
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            case 2:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printStatistics();
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen menyn igen
            case 3:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                addGuest("", ""); //vad namn- och age-Strings har f??r v??rde: ""
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            case 4:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                changeNamneOfGuest(0, "");
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            case 5:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                changeAgeOfGuest(0, "");
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            case 6:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                removeGuest(0);
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            case 7:
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                changePlaces(0,0);
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen
            default: //ogiltigt nummer; inte inom val 0-7
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                System.out.println("You have to enter a number between 0-7");
                System.out.println("\n- - - - - - - - - - - - - - - -\n");
                printMenu(); //visar menyn igen f??r att v??lja ett giltigt nummer
        }
    }

    public static void changePlaces(int index1, int index2) {
        System.out.println("You chose to switch places between two guests\n"); //you don't need to keep this line
        // Add your code here
        System.out.print("Current guest number: ");
        index1 = in.nextInt() - 1; //index-nummer som anv??ndaren f??rst??r
        in.nextLine(); //g??r till n??sta input
        System.out.print("The wished guest number: ");
        index2 = in.nextInt() - 1; //index-nummer som anv??ndaren f??rst??r
        if (index1 < 0 && index1 > guestList.length && index2 < 0 && index2 > guestList.length) { //fel om index inte ??r mellan 0-length; ingen g??st
            System.out.println("There is no guest with that number!");
        }

        else{ //tillg??nglig g??st
            String tempName = guestList[index2][0]; //tempor??rt namn
            String tempAge = guestList[index2][1]; //tempor??r ??lder
            //guestList[index1] = new String[]{guestList[index2][0], guestList[index2][1]}; //alla element p?? denna row ska f?? tomma str??ngar
            guestList[index2] = new String[]{guestList[index1][0], guestList[index1][1]}; //alla element p?? denna row ska f?? tomma str??ngar
            guestList[index1] = new String[]{tempName, tempAge}; //alla element p?? denna row ska f?? tomma str??ngar


            System.out.println("The places are switched!");
        }
    }

    public static void removeGuest(int index) {
        System.out.println("You chose to remove a guest\n"); //you don't need to keep this line
        // Add your code here

        System.out.print("Guest number: ");
        index = in.nextInt() - 1; //index-nummer som anv??ndaren f??rst??r
        in.nextLine(); //g??r till n??sta input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte ??r mellan 0-length; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String ??r tom; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else { //tillg??nglig g??st
            guestList[index] = new String[]{"", ""}; //alla element p?? denna row ska f?? tomma str??ngar
            System.out.println("The guest is removed!");
        }

    }

    public static void changeAgeOfGuest(int index, String newAge) {
        System.out.println("You chose to remove a guest\n");


        System.out.print("Guest number: ");
        index = in.nextInt() - 1; //index-nummer som anv??ndaren f??rst??r
        in.nextLine(); //g??r till n??sta input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte ??r mellan 0-length; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String ??r tom; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else { //tillg??nglig g??st
            System.out.print("New age: ");
            newAge = in.nextLine(); //en ny ??lder matas in
            guestList[index] = new String[]{guestList[index][0], newAge}; //alla element p?? denna row matas med namn och ??lder
            System.out.println("The older is changed!");
        }


    }

    public static void changeNamneOfGuest(int index, String newName) {
        System.out.println("You chose to change the name of a guest"); //you don't need to keep this line
        // Add your code here

        System.out.print("Guest Number: ");
        index = in.nextInt() - 1; //index-nummer som anv??ndaren f??rst??r
        in.nextLine(); //g??r till n??sta input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte ??r mellan 0-length; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String ??r tom; ingen g??st
            System.out.println("There is no guest with that number!");
        }
        else { //tillg??nglig g??st
            System.out.print("New name: ");
            newName = in.nextLine(); //ett nytt namn matas in
            guestList[index] = new String[]{newName, guestList[index][1]}; //alla element p?? denna row matas med namn och ??lder
            System.out.println("The name is changed!");
        }

    }




    public static void printStatistics() {
        System.out.println("You chose to print statistics"); //you don't need to keep this line
        // Add your code here
        System.out.println("* * * * * * * * * * * * * * * * *");
        //att r??kna ut totalt antal g??ster

        //start-v??rde f??r:
        int emptyPlace = 0;
        int total = 0;
        boolean empty = false;
        for(int row = 0; row < guestList.length; row++){ //loop som g??r igenom alla rader
            if(guestList[row][0].equalsIgnoreCase("")){ //om raden ??r tom, dvs ingen g??st/empty
                emptyPlace++; //??kar tomma platser med 1
                empty = true; //nytt v??rde f??r empty
            }
        }
        if(empty){ //om den ??r true

            //total g??ster totalt antal g??ster - lediga platser
            total = guestList.length - emptyPlace;
            System.out.println("Total guest number: " + total); //total g??ster visas
        }
        else{ //om ingen ledig plats finns; false
            total = guestList.length; //alla g??ster ??r p?? plats
            System.out.println("Total guest number: " + total);
        }

        System.out.println(" * * * * * * *");


        //----------------------
        //Antal vuxna & barn

        //start-v??rde f??r:
        int totalAdults = 0;
        int totalChildren = 0;
        String youngestName = null;
        String youngestAge = null;
        String oldestName = null;
        String oldestAge = null;

        int max = 0;
        int min = 100; //den yngsta ??r alltid mindre ??n 14

        //String Child = null;
        //String Adult = null;


        for(int row=0; row < guestList.length; row++) //g??r igenom alla rader
        {
            if(guestList[row][1].equalsIgnoreCase("") == false) { //om raden inte ??r tom

                //st??mmer if-satsen om de n??stlade satser st??mmer

                int Guest = Integer.parseInt(guestList[row][1]); //omvandla ??lder-kolumnen till int f??r att j??mf??ra


                if (Guest > max) //max ??lder
                {
                    max = Guest; //max f??r ett nytt v??rde med den g??stens ??lder
                    oldestName = guestList[row][0];
                    oldestAge = guestList[row][1];

                }

                if (Guest < min) //min ??lder
                {
                    min = Guest; // min f??r ett nytt v??rde med den g??stens ??lder
                    youngestName = guestList[row][0];
                    youngestAge = guestList[row][1];

                }

                //f??r att r??kna antal vuxna och barn:
                if (Guest > 13) //vuxen
                {
                    totalAdults++; //??ka antal vuxna med 1
                } else { //barn
                    totalChildren++; //??ka antal barn med 1
                }
            }

        }
        System.out.println("Total adults: " + totalAdults);
        System.out.println("Total children: " + totalChildren);
        System.out.println(" * * * * * * *");
        System.out.println("The oldest is: " + oldestName + ", " + oldestAge); //den ??ldsta och dennes ??lder
        System.out.println("The youngest is: " + youngestName + ", " + youngestAge); //den yngsta och dennes ??lder
    }

    public static void addGuest(String name, String age) {
        System.out.println("You chose to add a guest\n");
        //g??stens namn & ??lder
        System.out.print("Write your name: ");
        name = in.next(); //matar in sitt namn
        System.out.print("Write your age: ");
        age = in.next(); //matar in sin ??lder
        boolean available = false; //boolean initiliseras som false i b??rjan

        for(int row = 0; row < guestList.length; row++) { //for-loop som g??r igenom alla row i arrayen

            //d?? ett namn-index ??r tom, (""), s?? ??r dess ??lder-index ocks?? tom
            //d??rf??r j??mf??rs med bara row och inte koloumn:
            if(guestList[row][0].equalsIgnoreCase("")){

                guestList[row] = new String[]{name, age}; //row p?? denna counter/row matas med namn och sedan ??lder
                available = true; //boolean f??r ledig f??r ett nytt v??rde; true
                break; //g??r utanf??r loopen n??r 1 g??st till??ggs ("")
            }
        } //slut f??r f??r-loop
        if (!available) //om den inte ??r ledig; dvs false
        {
            System.out.println("\nThere is no empty place!"); //meddelas att ingen plats hittas d?? !Ledig
        }
        else System.out.println("\nThe guest is added!");
    } //slut f??r metoden


    public static void printGuestList() {
        System.out.println("You chose to print the guest list"); //you don't need to keep this line
        // Add your code here
        for(int index = 0; index < guestList.length; index++){
            System.out.println(Arrays.deepToString(guestList[index])); //Skriver ut hela g??stlistan enligt index
        }
    }

    public static void main(String[] args) {
        // Add you code here with the main loop that handles the user's menu choices.
        printMenu();

    }
}
