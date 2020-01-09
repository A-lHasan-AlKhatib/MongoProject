package Controller;

import Model.*;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static Controller.ExamController.*;

public class XtraController {

    private static MongoCollection<Document> courseColl = DBController.getInstance().getCollection(DBController.COLLECTION_COURSE);
    private static MongoCollection<Document> teacherColl = DBController.getInstance().getCollection(DBController.COLLECTION_TEACHER);
    private static MongoCollection<Document> offerColl = DBController.getInstance().getCollection(DBController.COLLECTION_OFFER);

    public static ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        for (Document doc : courseColl.find()) {
            courses.add(new GsonBuilder().create().fromJson(doc.toJson(), Course.class));
        }
        return courses;
    }

    public static ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Document doc : teacherColl.find()) {
            teachers.add(new GsonBuilder().create().fromJson(doc.toJson(), Teacher.class));
        }
        return teachers;
    }

    public static ArrayList<Offer> getAllOffers() {
        ArrayList<Offer> offers = new ArrayList<>();
        for (Document doc : offerColl.find()) {
            offers.add(new GsonBuilder().create().fromJson(doc.toJson(), Offer.class));
        }
        return offers;
    }

    public static ArrayList<Course> searchCourse(Operators operator, String key, Object value) {
        ArrayList<Course> courses = new ArrayList<>();
        FindIterable<Document> iterable;
        BasicDBObject obj = new BasicDBObject();
        obj.put(key, new BasicDBObject("$" + operator, value));
        iterable = courseColl.find(obj);
        for (Document doc : iterable) {
            courses.add(new GsonBuilder().create().fromJson(doc.toJson(), Course.class));
        }
        return courses;
    }

    public static ArrayList<Teacher> searchTeacher(Operators operator, String key, Object value) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        FindIterable<Document> iterable;
        BasicDBObject obj = new BasicDBObject();
        obj.put(key, new BasicDBObject("$" + operator, value));
        iterable = teacherColl.find(obj);
        for (Document doc : iterable) {
            teachers.add(new GsonBuilder().create().fromJson(doc.toJson(), Teacher.class));
        }
        return teachers;
    }

    public static ArrayList<Offer> searchOffer(Operators operator, String key, Object value) {
        ArrayList<Offer> offers = new ArrayList<>();
        FindIterable<Document> iterable;
        BasicDBObject obj = new BasicDBObject();
        obj.put(key, new BasicDBObject("$" + operator, value));
        iterable = offerColl.find(obj);
        for (Document doc : iterable) {
            offers.add(new GsonBuilder().create().fromJson(doc.toJson(), Offer.class));
        }
        return offers;
    }

    public static long updateCourse(Operators operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        Document doc = new Document("$set", new Document(updateKey, updateValue));
        UpdateResult result = null;
        switch (operator) {
            case eq:
                result = courseColl.updateMany(Filters.eq(searchKey, searchValue), doc);
                break;
            case gt:
                result = courseColl.updateMany(Filters.gt(searchKey, searchValue), doc);
                break;
            case gte:
                result = courseColl.updateMany(Filters.gte(searchKey, searchValue), doc);
                break;
            case lt:
                result = courseColl.updateMany(Filters.lt(searchKey, searchValue), doc);
                break;
            case lte:
                result = courseColl.updateMany(Filters.lte(searchKey, searchValue), doc);
                break;
            case ne:
                result = courseColl.updateMany(Filters.ne(searchKey, searchValue), doc);
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getModifiedCount();
    }

    public static long updateTeacher(Operators operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        Document doc = new Document("$set", new Document(updateKey, updateValue));
        UpdateResult result = null;
        switch (operator) {
            case eq:
                result = teacherColl.updateMany(Filters.eq(searchKey, searchValue), doc);
                break;
            case gt:
                result = teacherColl.updateMany(Filters.gt(searchKey, searchValue), doc);
                break;
            case gte:
                result = teacherColl.updateMany(Filters.gte(searchKey, searchValue), doc);
                break;
            case lt:
                result = teacherColl.updateMany(Filters.lt(searchKey, searchValue), doc);
                break;
            case lte:
                result = teacherColl.updateMany(Filters.lte(searchKey, searchValue), doc);
                break;
            case ne:
                result = teacherColl.updateMany(Filters.ne(searchKey, searchValue), doc);
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getModifiedCount();
    }

    public static void addCourse(Course course) {
        Document doc = new Document("id", course.getId()).append("name", course.getName())
                .append("hours", course.getHours());
        courseColl.insertOne(doc);
    }

    public static void addTeacher(Teacher teacher) {
        Document doc = new Document("id", teacher.getId()).append("name", teacher.getName())
                .append("password", teacher.getPassword()).append("salary", teacher.getSalary());
        teacherColl.insertOne(doc);
    }

    public static void addOffer(Offer offer) {
        Document doc = new Document("offer_num", offer.getOffer_num()).append("teacherId", offer.getTeacherId())
                .append("courseId", offer.getCourseId()).append("room", offer.getRoom()).append("time", offer.getTime());
        offerColl.insertOne(doc);
    }

    public static long deleteCourse(Operators operator, String key, Object value) {
        DeleteResult result;
        switch (operator) {
            case eq:
                result = courseColl.deleteOne(Filters.eq(key, value));
                break;
            case gt:
                result = courseColl.deleteOne(Filters.gt(key, value));
                break;
            case gte:
                result = courseColl.deleteOne(Filters.gte(key, value));
                break;
            case lt:
                result = courseColl.deleteOne(Filters.lt(key, value));
                break;
            case lte:
                result = courseColl.deleteOne(Filters.lte(key, value));
                break;
            case ne:
                result = courseColl.deleteOne(Filters.ne(key, value));
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getDeletedCount();
    }

    public static long deleteTeacher(Operators operator, String key, Object value) {
        DeleteResult result;
        switch (operator) {
            case eq:
                result = teacherColl.deleteOne(Filters.eq(key, value));
                break;
            case gt:
                result = teacherColl.deleteOne(Filters.gt(key, value));
                break;
            case gte:
                result = teacherColl.deleteOne(Filters.gte(key, value));
                break;
            case lt:
                result = teacherColl.deleteOne(Filters.lt(key, value));
                break;
            case lte:
                result = teacherColl.deleteOne(Filters.lte(key, value));
                break;
            case ne:
                result = teacherColl.deleteOne(Filters.ne(key, value));
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getDeletedCount();
    }

    public static void main(String[] args) {
//        ExamController.coll.drop();
//        teacherColl.drop();
//        offerColl.drop();
//        courseColl.drop();
//        Teacher.setCount(0);
//        Course.setCount(0);
//        Offer.setCount(0);
//        Exam.setCount(0);
//
//        addTeacher(new Teacher("Basim", "abcd", 1500));
//        addTeacher(new Teacher("Tawfeeq", "12345", 2200));
//        addTeacher(new Teacher("Hasan", "hasan", 2800));
//        addTeacher(new Teacher("Iyad", "it", 1800));
////
//        addCourse(new Course("Programming", 3));
//        addCourse(new Course("Web", 3));
//        addCourse(new Course("DB", 3));
//        addCourse(new Course("OS", 2));
//        addCourse(new Course("Networks", 2));
//
////
////
//        addOffer(new Offer(1,1,"K205","13:00"));
//        addOffer(new Offer(2,2,"P403","09:30"));
//        addOffer(new Offer(2,2,"I307","10:00"));
//        addOffer(new Offer(2,3,"I116","14:00"));
//        addOffer(new Offer(3,3,"K517","09:00"));
//        addOffer(new Offer(3,4,"P503","10:30"));
//        addOffer(new Offer(4,4,"K117","15:30"));
//        addOffer(new Offer(4,2,"I405","09:30"));
////
//        addExam(new Exam(1,"I116","02/01/2020","10:30"));
//        addExam(new Exam(2,"I116","02/01/2020","10:30"));
//        addExam(new Exam(3,"K207","01/01/2020","12:00"));
//        addExam(new Exam(4,"I117","08/01/2020","09:30"));
//        addExam(new Exam(5,"I116","09/01/2020","11:30"));
//        addExam(new Exam(6,"I403","10/01/2020","11:00"));
//        addExam(new Exam(7,"I405","27/12/2019","10:00"));
//        addExam(new Exam(8,"I305","31/12/2019","15:00"));
//////
//        for (Teacher t : getAllTeachers())
//            System.out.println(t);
//
//        System.out.println("");
//
//        for (Course c : getAllCourses())
//            System.out.println(c);
//        System.out.println("");
//        for (Offer f : getAllOffers())
//            System.out.println(f);
//        System.out.println("");
//        for (Exam e : getAllExams())
//            System.out.println(e);

    }


    public static String[] getExamText(int id) {
        ArrayList<Offer> of = searchOffer(Operators.eq, "teacherId", id);
        ArrayList<Exam> exams = new ArrayList<>();
        for (Offer offer : of)
            exams.addAll(ExamController.searchExam(Operators.eq, "offer_id", offer.getOffer_num()));
        String[] re = new String[exams.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = exams.get(i).getId() + " : ";
            String courseName = "";
            for (Offer offer : of)
                if (offer.getOffer_num() == exams.get(i).getOffer_id())
                    courseName = searchCourse(Operators.eq, "id", offer.getCourseId()).get(0).getName();
            re[i] += courseName;
        }
        return re;
    }

    public static String[] getAddText(int id) {
        ArrayList<Offer> offers = searchOffer(Operators.eq, "teacherId", id);
        String[] re = new String[offers.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = offers.get(i).getOffer_num() + " : ";
            String courseName = searchCourse(Operators.eq, "id", offers.get(i).getCourseId()).get(0).getName();
            re[i] += courseName;
        }
        return re;
    }


    public static String[][] displayExamsTeacherId(int id) {
        ArrayList<Offer> offers = searchOffer(Operators.eq, "teacherId", id);
        ArrayList<Exam> exams = new ArrayList<>();
        for (Offer offer : offers)
            exams.addAll(ExamController.searchExam(Operators.eq, "offer_id", offer.getOffer_num()));
        String[][] re = new String[exams.size()][5];
        for (int i = 0; i < re.length; i++) {
            Offer of = searchOffer(Operators.eq, "offer_num", exams.get(i).getOffer_id()).get(0);
            Teacher te = searchTeacher(Operators.eq, "id", of.getTeacherId()).get(0);
            Course co = searchCourse(Operators.eq, "id", of.getCourseId()).get(0);
            re[i][0] = te.getName();
            re[i][1] = co.getName();
            re[i][2] = exams.get(i).getRoom();
            re[i][3] = exams.get(i).getDate();
            re[i][4] = exams.get(i).getTime();
        }
        return re;
    }

    public static String[][] displayExams() {
        ArrayList<Exam> exams = getAllExams();
        String[][] re = new String[exams.size()][5];
        for (int i = 0; i < re.length; i++) {
            Offer of = searchOffer(Operators.eq, "offer_num", exams.get(i).getOffer_id()).get(0);
            Teacher te = searchTeacher(Operators.eq, "id", of.getTeacherId()).get(0);
            Course co = searchCourse(Operators.eq, "id", of.getCourseId()).get(0);
            re[i][0] = te.getName();
            re[i][1] = co.getName();
            re[i][2] = exams.get(i).getRoom();
            re[i][3] = exams.get(i).getDate();
            re[i][4] = exams.get(i).getTime();
        }
        return re;
    }


    public static String[][] displayExamsTeacher(String name) {
        ArrayList<Teacher> teachers = searchTeacher(Operators.eq, "name", name);
        ArrayList<Offer> offers = new ArrayList<>();
        for (Teacher t : teachers)
            offers.addAll(searchOffer(Operators.eq, "teacherId", t.getId()));
        ArrayList<Exam> exams = new ArrayList<>();
        for (Offer offer : offers)
            exams.addAll(ExamController.searchExam(Operators.eq, "offer_id", offer.getOffer_num()));
        String[][] re = new String[exams.size()][5];
        for (int i = 0; i < re.length; i++) {
            Offer of = searchOffer(Operators.eq, "offer_num", exams.get(i).getOffer_id()).get(0);
            Teacher te = searchTeacher(Operators.eq, "id", of.getTeacherId()).get(0);
            Course co = searchCourse(Operators.eq, "id", of.getCourseId()).get(0);
            re[i][0] = te.getName();
            re[i][1] = co.getName();
            re[i][2] = exams.get(i).getRoom();
            re[i][3] = exams.get(i).getDate();
            re[i][4] = exams.get(i).getTime();
        }
        return re;
    }

    public static String[][] displayExamsCourse(String name) {
        ArrayList<Course> courses = searchCourse(Operators.eq, "name", name);
        ArrayList<Offer> offers = new ArrayList<>();
        for (Course t : courses)
            offers.addAll(searchOffer(Operators.eq, "courseId", t.getId()));
        ArrayList<Exam> exams = new ArrayList<>();
        for (Offer offer : offers)
            exams.addAll(ExamController.searchExam(Operators.eq, "offer_id", offer.getOffer_num()));
        String[][] re = new String[exams.size()][5];
        for (int i = 0; i < re.length; i++) {
            Offer of = searchOffer(Operators.eq, "offer_num", exams.get(i).getOffer_id()).get(0);
            Teacher te = searchTeacher(Operators.eq, "id", of.getTeacherId()).get(0);
            Course co = searchCourse(Operators.eq, "id", of.getCourseId()).get(0);
            re[i][0] = te.getName();
            re[i][1] = co.getName();
            re[i][2] = exams.get(i).getRoom();
            re[i][3] = exams.get(i).getDate();
            re[i][4] = exams.get(i).getTime();
        }
        return re;
    }

    public static Teacher loginVerf(int id, String password) {
        Teacher t = new Teacher(id, password);
        Document doc = teacherColl.find(Filters.and(Filters.eq("id", id), Filters.eq("password", t.getPassword()))).first();
        if (doc == null)
            return null;
        return new GsonBuilder().create().fromJson(doc.toJson(), Teacher.class);

    }

}