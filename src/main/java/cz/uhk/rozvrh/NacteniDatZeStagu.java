package cz.uhk.rozvrh;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NacteniDatZeStagu implements Provider {

    private static final String TIMETABLE_URL = "https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?semestr=zs&budova=%s&mistnost=%s&outputFormat=JSON";

    @Override
    public List<RozvrhovaAkce> getRoomActivites(String budova, String mistnost){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalTime.class, new TypeAdapter<LocalTime>() {
            @Override
            public void write(JsonWriter jsonWriter, LocalTime localTime) throws IOException {
                //jenom cteme, tak neni treba
            }

            @Override
            public LocalTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                jsonReader.nextName();
                LocalTime time = LocalTime.parse(jsonReader.nextString());
                jsonReader.endObject();
                return time;
            }
        });
        //totez pro datum
        builder.registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {

            @Override
            public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                //jenom cteme, tak neni treba
            }

            @Override
            public LocalDate read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                jsonReader.nextName();
                LocalDate dat = LocalDate.parse(jsonReader.nextString(), DateTimeFormatter.ofPattern("d.M.yyyy"));
                jsonReader.endObject();
                return dat;
            }
        });
        Gson gson = builder.create();
        List<RozvrhovaAkce> akce = null;

        try{
            JsonElement object = gson.fromJson(
                    new InputStreamReader(
                            new URL(String.format(TIMETABLE_URL, budova, mistnost)).openStream()
                    ),
                    JsonElement.class

            );



            //System.out.print(object.getAsString());

            akce = gson.fromJson(object.getAsJsonObject().get("rozvrhovaAkce"), new TypeToken<List<RozvrhovaAkce>>() {}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return akce;  //bud se zadari a v seznamu neco bude, nebo bude prazdny

    }

}