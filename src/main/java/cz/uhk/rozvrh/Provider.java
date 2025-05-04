package cz.uhk.rozvrh;
import cz.uhk.rozvrh.RozvrhovaAkce;
import java.util.List;

public interface Provider {

    public List<RozvrhovaAkce> getRoomActivites(String budova, String mistnost);
    // diriguje to spusteni
}
