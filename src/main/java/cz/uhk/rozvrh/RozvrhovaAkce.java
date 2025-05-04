package cz.uhk.rozvrh;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class RozvrhovaAkce {

    @SerializedName("nazev")
    private String name;
    @SerializedName("predmet")
    private String module;
    @SerializedName("vsichniUciteleJmenaTituly")
    private String teacher;
    @SerializedName("typAkce")
    private String type;
    @SerializedName("den")
    private String day;
    @SerializedName("hodinaSkutOd")
    private LocalTime timeFrom;
    @SerializedName("hodinaSkutDo")
    private LocalTime timeTo;
    @SerializedName("mistnost")
    private String room;


    public RozvrhovaAkce() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public String getRoom() { return room;}
    public void setRoom(String room) { this.room = room; }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", module='" + module + '\'' +
                ", teacher='" + teacher + '\'' +
                ", type='" + type + '\'' +
                ", day='" + day + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                '}';
    }




}
