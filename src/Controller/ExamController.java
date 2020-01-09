package Controller;

import Model.Exam;
import Model.Operators;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;

public class ExamController {
    static MongoCollection<Document> coll = DBController.getInstance().getCollection(DBController.COLLECTION_EXAM);
    //must use before add new exams for the first time after you start the system
    public static int getLastExamId(){
        ArrayList<Exam> exams = getAllExams();
        if (exams.size() == 0)
            return 0;
        return exams.get(exams.size()-1).getId();
    }

    static ArrayList<Exam> getAllExams() {
        ArrayList<Exam> exams = new ArrayList<>();
        for (Document doc : coll.find()) {
            exams.add(new GsonBuilder().create().fromJson(doc.toJson(), Exam.class));
        }
        return exams;
    }

    public static ArrayList<Exam> searchExam(Operators operator, String key, Object value) {
        ArrayList<Exam> exams = new ArrayList<>();
        FindIterable<Document> iterable;
        BasicDBObject obj = new BasicDBObject();
        obj.put(key, new BasicDBObject("$" + operator, value));
        iterable = coll.find(obj);
        for (Document doc : iterable) {
            exams.add(new GsonBuilder().create().fromJson(doc.toJson(), Exam.class));
        }

        return exams;
    }

    public static long updateExam(Operators operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        Document doc = new Document("$set", new Document(updateKey, updateValue));
        UpdateResult result = null;
        switch (operator) {
            case eq:
                result = coll.updateMany(Filters.eq(searchKey, searchValue), doc);
                break;
            case gt:
                result = coll.updateMany(Filters.gt(searchKey, searchValue), doc);
                break;
            case gte:
                result = coll.updateMany(Filters.gte(searchKey, searchValue), doc);
                break;
            case lt:
                result = coll.updateMany(Filters.lt(searchKey, searchValue), doc);
                break;
            case lte:
                result = coll.updateMany(Filters.lte(searchKey, searchValue), doc);
                break;
            case ne:
                result = coll.updateMany(Filters.ne(searchKey, searchValue), doc);
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getModifiedCount();
    }

    public static void replaceStudent(Operators operator, String searchKey, Object searchValue, Exam exam) {
        Document doc = new Document("id", exam.getId()).append("offer_id", exam.getOffer_id()).append("room", exam.getRoom()).append("date", exam.getDate()).append("time", exam.getTime());
        UpdateResult result;
        switch (operator) {
            case eq:
                result = coll.replaceOne(Filters.eq(searchKey, searchValue), doc);
                break;
            case gt:
                result = coll.replaceOne(Filters.gt(searchKey, searchValue), doc);
                break;
            case gte:
                result = coll.replaceOne(Filters.gte(searchKey, searchValue), doc);
                break;
            case lt:
                result = coll.replaceOne(Filters.lt(searchKey, searchValue), doc);
                break;
            case lte:
                result = coll.replaceOne(Filters.lte(searchKey, searchValue), doc);
                break;
            case ne:
                result = coll.replaceOne(Filters.ne(searchKey, searchValue), doc);
                break;
            default:
                System.out.println("Wrong Operator!!");
                return;
        }
        result.getModifiedCount();
    }

    public static void addExam(Exam exam) {
        Document doc = new Document("id", exam.getId()).append("offer_id", exam.getOffer_id()).append("room", exam.getRoom()).append("date", exam.getDate()).append("time", exam.getTime());
        coll.insertOne(doc);
    }


    public static void delete(Operators operator, String key, Object value) {
        BasicDBObject query = new BasicDBObject();
        query.put(key,new BasicDBObject("$"+operator,value));
        coll.findOneAndDelete(query);
    }
}