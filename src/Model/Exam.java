package Model;

public class Exam {
    private static int count = 0;
    private int id;
    private int offer_id;
    private String room;
    private String date;
    private String time;

    public Exam(int offer_id, String room, String date, String time) {


        this.id = ++count;
        this.offer_id = offer_id;
        this.room = room;
        this.date = date;
        this.time = time;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Exam.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Id : " + id +
                " , Offer Id : " + offer_id +
                " , room : " + room +
                " , date : " + date +
                " , time : " + time;
    }
}