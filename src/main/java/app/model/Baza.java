package app.model;

import java.io.*;
import java.util.*;

public class Baza {
    private Map<String, List<Raspored>> fullRaspored = new HashMap<>();
    private List<Grupa> grupe = new ArrayList<>();
    private static Baza instance = new Baza();

    private Baza(){
        ucitajRaspored();
        brojCasova();
    }

    public static Baza getInstance() {
        return instance;
    }

    private void ucitajRaspored(){
        File file = new File("src/main/resources/rasporedPoNastavnicima-grupa2.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linija = null;
            String profesor = null;
            while((linija = br.readLine()) != null){
                String[] splitovano = linija.split(",");
                if(splitovano.length == 1){
                    // profesor
                    profesor = splitovano[0];
                }else {
                    String reg = "[a-zA-Z]+[0-9]+";
                    if(!splitovano[3].matches(reg)){
                        System.out.println(linija);
                    }
                    List<String> gr = new ArrayList<>(Arrays.asList(splitovano[5].split(" ")));

                    Raspored raspored = new Raspored(profesor, splitovano[0], splitovano[1], gr, splitovano[4], splitovano[2]);
                    if(!fullRaspored.containsKey(splitovano[3])){
                        fullRaspored.put(splitovano[3], new ArrayList<>());
                    }

                    fullRaspored.get(splitovano[3]).add(raspored);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Doslo je do greske prilikom citanja iz fajla");
        }
    }

    private void brojCasova(){
        for(Map.Entry<String, List<Raspored>> entry : fullRaspored.entrySet()){
            for(Raspored raspored : entry.getValue()){
                // Administracija i odrzavanje sistema 2,P i V,PET,Raf3,9-12,1s1
                // Interakcija covek-racunar,Predavanja,SRE,Raf21,9-11,301 302 303 304a 304b 305 306 307 308
                try {
                    Integer odKad = Integer.valueOf(raspored.getTermin().split("-")[0]);
                    Integer doKad = Integer.valueOf(raspored.getTermin().split("-")[1]);

                    for (String grupa : raspored.getGrupe()) {
                        Grupa gr = new Grupa(grupa, raspored.getDan(), 0);

                        if (this.grupe.contains(gr)) {
                            Grupa uListi = this.grupe.get(this.grupe.indexOf(gr));
                            uListi.setBrojCasova(uListi.getBrojCasova() + doKad - odKad);
                        } else {

                            gr.setBrojCasova(doKad - odKad);
                            this.grupe.add(gr);
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("Greska " + raspored.getPredmet() + raspored.getProfesor());
                }

            }
        }

        grupe.sort(null);
    }

    public Map<String, List<Raspored>> getFullRaspored() {
        return fullRaspored;
    }

    public List<Grupa> getGrupe() {
        return grupe;
    }
}
