package cz.uhk.rozvrh;

public class RozvrhovaAkce {

    public char budova;
    public String mistnost;
    public String denVTydnu;
    public String casZacatek;
    public String casKonec;
    public Ucitel ucitel;


    public RozvrhovaAkce(char budova, String mistnost, String denVTydnu, String casZacatek, String casKonec, Ucitel ucitelVRozvrhu) {

        this.budova = budova;
        this.mistnost = mistnost;
        this.denVTydnu = denVTydnu;
        this.casZacatek = casZacatek;
        this.casKonec = casKonec;
        this.ucitel = ucitelVRozvrhu;

    }

}
