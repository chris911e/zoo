package hahahahahahaha;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        boolean active = true;

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Gehege> zoo = new ArrayList<>();

        String[] reptilien = {"Kreuzotter", "Schlingnatter", "Waldeidechse", "Blindschleiche", "Aspisviper"};
        String[] reptilien_essen = {"Schnecke", "Wurm", "Fische", "Pflanzen"};
        Gehege reptilien_gehege = new Gehege(reptilien, reptilien_essen, "r", "Reptilien");
        zoo.add(reptilien_gehege);

        String[] fische = {"Flussbarsch", "Streber", "Zander", "Zingel", "Bachforelle"};
        String[] fische_essen = {"Algen", "Krebs", "Insekt", "Plfanze", "Plankton"};
        Gehege fische_gehege = new Gehege(fische, fische_essen, "f", "Fische");
        zoo.add(fische_gehege);

        String[] raubtiere = {"Bär", "Otter", "Wildkatze", "Seelöwe", "Bärhund"};
        String[] raubtiere_essen = {"Schweinefleisch", "Rindfleisch", "Hühnchenfleisch", "Beeren", "Grass"};
        Gehege raubtiere_gehege = new Gehege(raubtiere, raubtiere_essen, "z", "Raubtiere");
        zoo.add(raubtiere_gehege);

        String[] saeugetiere = {"Hund", "Katze", "Pferd", "Wal", "Delphin"};
        String[] saeugetiere_essen = {"Pflanze", "Schweinefleich", "Hühnchenfleisch", "Grass", "Wurm"};
        Gehege saeugetiere_gehege = new Gehege(saeugetiere, saeugetiere_essen, "s", "Säugetiere");
        zoo.add(saeugetiere_gehege);

        String[] voegel = {"Haussperling", "Amsel", "Buchfink", "Kohlmeise", "Eisvogel"};
        String[] voegel_essen = {"Korn", "Mohn", "Obst", "Haferflocken", "Sonnenblumenkern"};
        Gehege voegel_gehege = new Gehege(voegel, voegel_essen, "v", "Vögel");
        zoo.add(voegel_gehege);

        while (active) {

            System.out.println("Willkommen im Zoo!!!\n");
            System.out.println("+------------------+------------------------------------------------------------+\n" +
                    "| Zoo Karte        |                                                 +--------+ |\n" +
                    "+------------------+                             XXXXXXXX            |        | |\n" +
                    "|                                             XXXXXXXXXXXXXXXXXXXXXX +----  I | |\n" +
                    "|  Eingang  +-----------+                   XXXXXXXXXXXXXXXXXXXXXXXXXXX  |  n | |\n" +
                    "|                       v                  XX+--------------------+...XX |  f | |\n" +
                    "|                       XX                XX |                    |....XX|  o | |\n" +
                    "| +--------------+ +---------+           XX..|                    |....XX|  r | |\n" +
                    "| |              | |   Zoo   |           XX..|                    |....XX|  m | |\n" +
                    "| |              | +---------+          XX...|   Raubtiere (Z)    |....XX|  a | |\n" +
                    "| | Reptilien (R)| |    XX   |          XX...|                    |...XX |  t | |\n" +
                    "| |              | +    XX   +        XXX....|                    |..XX+--  i | |\n" +
                    "| |              |   XXXXX           XX......|                    |.XX |    k | |\n" +
                    "| +--------------+XXXX XXX          XXXX.....+--------------------+XX  |      | |\n" +
                    "|              XXX~~~~~~XXXX      XXXXXXXXX................XXXXXXXXX   +------+ |\n" +
                    "|  +--------+XXX~~~~~~~~~~~~XXXXXXX~~~~~XXXXXXXXXXXXXXXXXXXXX+----------------+ |\n" +
                    "|  |        |XX.~~~~~~~~~~~~~~~~~~~~~~~~~~XXX+-------------+X|                | |\n" +
                    "|  |        |XX.~~~~~~~~~~~~~~~~~~~~~~~~~XX+               |X|    Vögel (V)   | |\n" +
                    "|  | Fische |XX.~~~~~~~~~~~~~~~~~~~~~~~XXX+                |X+---            -+ |\n" +
                    "|  |  (F)   | XXXX~~~~~~~~~~~~~~~~~~~~XX+--  Säugetiere (S)|XXX +---+        |  |\n" +
                    "|  |        |    XXXXXXXXXXXXXXXXXXXXXX |                  |  XXXXXX|        |  |\n" +
                    "|  |        |                           |                  |     XXX+--------+  |\n" +
                    "|  +--------+                           +------------------+                    |\n" +
                    "+-------------------------------------------------------------------------------+");

            System.out.println("Welche Tiere wollen sie besuchen? (R/Z/F/S/V)");
            String suche_abbvr = keyboard.nextLine();

            for (int i = 0; i < zoo.size(); i++){
                    if (suche_abbvr.toLowerCase().equals(zoo.get(i).getAbbvr())) {
                        boolean visit_gehege = true;
                        while (visit_gehege) {
                            System.out.printf("Wilkommen im %s Gehege!\nWelches Tier wollen sie besuchen?\n", zoo.get(i).getGehege_name());
                            for (int c = 0; c < zoo.get(i).getTiere().size(); c++){
                                System.out.println(c + " " + zoo.get(i).getTiere().get(c));
                            }
                            int snum = zoo.get(i).getTiere().size() + 1;
                            System.out.println(snum + " Zurück");
                            String choice = keyboard.nextLine();
                            if(choice.equals(Integer.toString(snum))) {
                                visit_gehege = false;
                                System.out.println(choice + snum);
                            } else{
                                for (int f = 0; f < zoo.get(i).getTiere().size(); f++) {
                                    if (choice.equals(Integer.toString(f))) {
                                        boolean visit_tier = true;
                                        while (visit_tier) {
                                            System.out.printf("Du besuchst den %s\nWas willst du machen?\n0 Besichtigen\n1 Füttern \n2 Zurück\n", zoo.get(i).getTierName(f));
                                            int activity = keyboard.nextInt();
                                            switch(activity){
                                                case 0:
                                                    System.out.println(zoo.get(i).watch(zoo.get(i).getTierName(f)));
                                                    break;
                                                case 1:
                                                    System.out.println("Wähle etwas was du dem Tier füttern willst");
                                                    for (int l = 0; l < zoo.get(i).getEssen().size(); l++) {
                                                        System.out.println(l + " " + zoo.get(i).getEssenName(l));
                                                    }
                                                    int essen_choice = keyboard.nextInt();
                                                    System.out.println(zoo.get(i).feed(zoo.get(i).getTierName(f), zoo.get(i).getEssenName(essen_choice)));
                                                    break;
                                                case 2:
                                                    visit_tier = false;
                                                    break;
                                                default:
                                                    System.out.println("Bitte wählen sie etwas aus");
                                            }

                                        }
                                    }
                                }
                            }

                        }
                    }
            }

        }

    }
}
