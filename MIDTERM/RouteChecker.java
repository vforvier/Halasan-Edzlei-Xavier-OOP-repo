import java.util.ArrayList;
import java.util.Scanner;

public class RouteChecker {
   public static void main (String [] args) {
       
        Scanner scan = new Scanner(System.in);
        double distance = 0;
       
        ArrayList<String> routeA = new ArrayList<String>();
              routeA.add("Cebu City (Emall)");
              routeA.add("Minglanila");
              routeA.add("San Fernando");
              routeA.add("Carcar");
            ArrayList<String> routeB = new ArrayList<String>();
              routeB.add("Barili");
              routeB.add("Dumanjug");
              routeB.add("Alcantara");
              routeB.add("Moalboal");
            ArrayList<String> routeC = new ArrayList<String>();
              routeC.add("Dumanjug");
              routeC.add("Alcantara");
              routeC.add("Moalboal (end)");
            ArrayList<String> routeD = new ArrayList<String>();
              routeD.add("Argao");
              routeD.add("Ronda");
              routeD.add("Alcantara");
              routeD.add("Moalboal (end)");
       
       for(int i = 0; i < routeA.size(); i++){
            System.out.println("route " +i+ " (" + routeA.get(i) + ")");
           }
       System.out.println("Is Barili blocked? [1] no [2] yes");
       
        int choiceA = scan.nextInt();
        if(choiceA == 1){
            for(int i = 0; i < routeB.size(); i++){
                System.out.println("route 4.1." + i + " ("+routeB.get(i)+")");
            }
        distance = 84.9;
       }
        else if (choiceA == 2){
            System.out.println("Route 4.2 (Sibunga)");
            routeA.add("Sibunga");
            System.out.println("Is Dumanjug blocked? [1] no [2] yes");
            int choiceB = scan.nextInt();
                if(choiceB == 1){
                    int o = 1;
                    for(int i = 0; i < routeC.size(); i++){
                        System.out.println("route 4.2." + o + " ("+routeC.get(i)+")");
                        o++;
                    }
                distance = 96.2;
                }
                else{
                    for(int i = 0; i < routeD.size(); i++){
                        System.out.println("route 5." + i + " ("+routeD.get(i)+")");
                    }
                distance = 103;
                }
            }
        System.out.print("How fast is your speed: ");
        double speed = scan.nextInt();
        System.out.println("speed: " +speed + "km/hr");
        System.out.println("total distance: " + distance + "km");
        double estTime = (distance/speed)*60;
        int hours = (int)estTime / 60;
        int minutes = (int)estTime % 60;
        System.out.printf("Estimated Time of Arrival: %d hrs %d minutes", hours,minutes);  
   }
}
