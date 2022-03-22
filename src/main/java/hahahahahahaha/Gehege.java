package hahahahahahaha;

import java.util.ArrayList;

public class Gehege {

    private String abbvr = "";
    private String gehege_name = "";
    private ArrayList<String> tiere = new ArrayList<>();
    private ArrayList<String> essen = new ArrayList<>();

    public Gehege(String[] tier, String[] essen, String abbvr, String gehege_name) {
        this.abbvr = abbvr;
        this.gehege_name = gehege_name;
        for (int b = 0; b < tier.length; b++){
            this.tiere.add(tier[b]);
        }
        for (int o = 0; o < essen.length; o++){
            this.essen.add(essen[o]);
        }
    }

    public String watch(String tier){
        return tier + " schaut dich gerade agressive an!";
    }

    public String feed(String tier, String essen){
        return tier + " sieht zufrieden und glücklich mit " + essen + " aus";
    }


    public String getGehege_name(){
        return this.gehege_name;
    }

    public String getTierName(int index){
        return this.tiere.get(index);
    }

    public String getEssenName(int index){
        return this.essen.get(index);
    }

    public ArrayList<String> getEssen(){
        return this.essen;
    }

    public ArrayList<String> getTiere() {
        return this.tiere;
    }

    public String getAbbvr(){
        return this.abbvr;
    }

}
