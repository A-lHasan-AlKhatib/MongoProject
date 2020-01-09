package Model;

public class Offer {
    private static int count = 0;
    private int offer_num;
    private int teacherId;
    private int courseId;
    private String room;
    private String time;

    public Offer(int teacherId, int courseId, String room, String time) {
        this.offer_num = ++count;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.room = room;
        this.time = time;
    }

    public static void setCount(int count) {
        Offer.count = count;
    }

    public int getOffer_num() {
        return offer_num;
    }

    public void setOffer_num(int offer_num) {
        this.offer_num = offer_num;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "offer Num : " + offer_num +
                " , teacherId : " + teacherId +
                " , courseId : " + courseId +
                " , room : " + room +
                " , time : " + time;
    }
}