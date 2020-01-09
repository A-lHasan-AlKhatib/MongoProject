package Controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;

public class DBController {

    private static MongoClient mongo;
    private static MongoDatabase instance;
    static String COLLECTION_EXAM = "exam";
    static String COLLECTION_COURSE = "course";
    static String COLLECTION_TEACHER = "teacher";
    static String COLLECTION_OFFER = "offer";

    private DBController() {
    }

    //this method starts mongclient if null.
    private static void startClient() {
        if (mongo == null) {
            try {
                String IP = "localhost";
                int PORT = 27017;
                mongo = new MongoClient(IP, PORT);
            } catch (MongoException ex) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "MongoDB ERROR", "ERROR!!", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong in mongo", "ERROR!!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //
    private static void init() {
        startClient();
        String DB_NAME = "IUG_DB";
        instance = mongo.getDatabase(DB_NAME);
    }

    public void close() {
        if (mongo != null) {
            try {
                mongo.close();
                mongo = null;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong in mongo", "ERROR!!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "DB is already null", "ERROR!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    static MongoDatabase getInstance() {
        init();
        return instance;
    }
}