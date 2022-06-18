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
                addGuest("", ""); //vad namn- och age-Strings har för värde: ""
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
                printMenu(); //visar menyn igen för att välja ett giltigt nummer
        }
    }

    public static void changePlaces(int index1, int index2) {
        System.out.println("You chose to switch places between two guests\n"); //you don't need to keep this line
        // Add your code here
        System.out.print("Current guest number: ");
        index1 = in.nextInt() - 1; //index-nummer som användaren förstår
        in.nextLine(); //går till nästa input
        System.out.print("The wished guest number: ");
        index2 = in.nextInt() - 1; //index-nummer som användaren förstår
        if (index1 < 0 && index1 > guestList.length && index2 < 0 && index2 > guestList.length) { //fel om index inte är mellan 0-length; ingen gäst
            System.out.println("There is no guest with that number!");
        }

        else{ //tillgänglig gäst
            String tempName = guestList[index2][0]; //temporärt namn
            String tempAge = guestList[index2][1]; //temporär ålder
            //guestList[index1] = new String[]{guestList[index2][0], guestList[index2][1]}; //alla element på denna row ska få tomma strängar
            guestList[index2] = new String[]{guestList[index1][0], guestList[index1][1]}; //alla element på denna row ska få tomma strängar
            guestList[index1] = new String[]{tempName, tempAge}; //alla element på denna row ska få tomma strängar


            System.out.println("The places are switched!");
        }
    }

    public static void removeGuest(int index) {
        System.out.println("You chose to remove a guest\n"); //you don't need to keep this line
        // Add your code here

        System.out.print("Guest number: ");
        index = in.nextInt() - 1; //index-nummer som användaren förstår
        in.nextLine(); //går till nästa input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte är mellan 0-length; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String är tom; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else { //tillgänglig gäst
            guestList[index] = new String[]{"", ""}; //alla element på denna row ska få tomma strängar
            System.out.println("The guest is removed!");
        }

    }

    public static void changeAgeOfGuest(int index, String newAge) {
        System.out.println("You chose to remove a guest\n");


        System.out.print("Guest number: ");
        index = in.nextInt() - 1; //index-nummer som användaren förstår
        in.nextLine(); //går till nästa input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte är mellan 0-length; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String är tom; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else { //tillgänglig gäst
            System.out.print("New age: ");
            newAge = in.nextLine(); //en ny ålder matas in
            guestList[index] = new String[]{guestList[index][0], newAge}; //alla element på denna row matas med namn och ålder
            System.out.println("The older is changed!");
        }


    }

    public static void changeNamneOfGuest(int index, String newName) {
        System.out.println("You chose to change the name of a guest"); //you don't need to keep this line
        // Add your code here

        System.out.print("Guest Number: ");
        index = in.nextInt() - 1; //index-nummer som användaren förstår
        in.nextLine(); //går till nästa input

        //3 val; antingen:

        if (index < 0 && index > guestList.length) { //fel om index inte är mellan 0-length; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else if(guestList[index][0].equalsIgnoreCase("") == true) { //fel om String är tom; ingen gäst
            System.out.println("There is no guest with that number!");
        }
        else { //tillgänglig gäst
            System.out.print("New name: ");
            newName = in.nextLine(); //ett nytt namn matas in
            guestList[index] = new String[]{newName, guestList[index][1]}; //alla element på denna row matas med namn och ålder
            System.out.println("The name is changed!");
        }

    }




    public static void printStatistics() {
        System.out.println("You chose to print statistics"); //you don't need to keep this line
        // Add your code here
        System.out.println("* * * * * * * * * * * * * * * * *");
        //att räkna ut totalt antal gäster

        //start-värde för:
        int emptyPlace = 0;
        int total = 0;
        boolean empty = false;
        for(int row = 0; row < guestList.length; row++){ //loop som går igenom alla rader
            if(guestList[row][0].equalsIgnoreCase("")){ //om raden är tom, dvs ingen gäst/empty
                emptyPlace++; //ökar tomma platser med 1
                empty = true; //nytt värde för empty
            }
        }
        if(empty){ //om den är true

            //total gäster totalt antal gäster - lediga platser
            total = guestList.length - emptyPlace;
            System.out.println("Total guest number: " + total); //total gäster visas
        }
        else{ //om ingen ledig plats finns; false
            total = guestList.length; //alla gäster är på plats
            System.out.println("Total guest number: " + total);
        }

        System.out.println(" * * * * * * *");


        //----------------------
        //Antal vuxna & barn

        //start-värde för:
        int totalAdults = 0;
        int totalChildren = 0;
        String youngestName = null;
        String youngestAge = null;
        String oldestName = null;
        String oldestAge = null;

        int max = 0;
        int min = 100; //den yngsta är alltid mindre än 14

        //String Child = null;
        //String Adult = null;


        for(int row=0; row < guestList.length; row++) //går igenom alla rader
        {
            if(guestList[row][1].equalsIgnoreCase("") == false) { //om raden inte är tom

                //stämmer if-satsen om de nästlade satser stämmer

                int Guest = Integer.parseInt(guestList[row][1]); //omvandla ålder-kolumnen till int för att jämföra


                if (Guest > max) //max ålder
                {
                    max = Guest; //max får ett nytt värde med den gästens ålder
                    oldestName = guestList[row][0];
                    oldestAge = guestList[row][1];

                }

                if (Guest < min) //min ålder
                {
                    min = Guest; // min får ett nytt värde med den gästens ålder
                    youngestName = guestList[row][0];
                    youngestAge = guestList[row][1];

                }

                //för att räkna antal vuxna och barn:
                if (Guest > 13) //vuxen
                {
                    totalAdults++; //öka antal vuxna med 1
                } else { //barn
                    totalChildren++; //öka antal barn med 1
                }
            }

        }
        System.out.println("Total adults: " + totalAdults);
        System.out.println("Total children: " + totalChildren);
        System.out.println(" * * * * * * *");
        System.out.println("The oldest is: " + oldestName + ", " + oldestAge); //den äldsta och dennes ålder
        System.out.println("The youngest is: " + youngestName + ", " + youngestAge); //den yngsta och dennes ålder
    }

    public static void addGuest(String name, String age) {
        System.out.println("You chose to add a guest\n");
        //gästens namn & ålder
        System.out.print("Write your name: ");
        name = in.next(); //matar in sitt namn
        System.out.print("Write your age: ");
        age = in.next(); //matar in sin ålder
        boolean available = false; //boolean initiliseras som false i början

        for(int row = 0; row < guestList.length; row++) { //for-loop som går igenom alla row i arrayen

            //då ett namn-index är tom, (""), så är dess ålder-index också tom
            //dörför jämförs med bara row och inte koloumn:
            if(guestList[row][0].equalsIgnoreCase("")){

                guestList[row] = new String[]{name, age}; //row på denna counter/row matas med namn och sedan ålder
                available = true; //boolean för ledig får ett nytt värde; true
                break; //går utanför loopen när 1 gäst tilläggs ("")
            }
        } //slut för för-loop
        if (!available) //om den inte är ledig; dvs false
        {
            System.out.println("\nThere is no empty place!"); //meddelas att ingen plats hittas då !Ledig
        }
        else System.out.println("\nThe guest is added!");
    } //slut för metoden


    public static void printGuestList() {
        System.out.println("You chose to print the guest list"); //you don't need to keep this line
        // Add your code here
        for(int index = 0; index < guestList.length; index++){
            System.out.println(Arrays.deepToString(guestList[index])); //Skriver ut hela gästlistan enligt index
        }
    }

    public static void main(String[] args) {
        // Add you code here with the main loop that handles the user's menu choices.
        printMenu();

    }
}
