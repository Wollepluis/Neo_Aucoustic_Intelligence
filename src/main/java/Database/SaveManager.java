package Database;

import javafx.scene.chart.PieChart;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Database.Database.hashMap;
import static Database.Database.mapje;

public class SaveManager {
    private static final boolean debug = false;
    private static final String DATA_PATH = "Aucoustic-intelligence"; // Define the data directory path
    private static final String persistentDataPath = System.getProperty("user.dir") + "/" + DATA_PATH; // Construct the persistent data path


    private static void writeToFile(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
                data.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return data.toString();
    }

    private static void checkFolder(String path) {
        Path folderPath = Paths.get(path);
        if (!Files.exists(folderPath)) {
            try {
                Files.createDirectories(folderPath);
                if (debug){
                    System.out.println("Created Folder: " + folderPath);
                }
            } catch (IOException e) {
                System.err.println("Error creating folder: " + e.getMessage());
            }
        }
        else{
            if (debug){
                System.out.println("Folder Already Exists At: " + folderPath);
            }
        }
    }

    private static void checkAllFolders(){
        checkFolder(persistentDataPath + "/Data"); // data folder
        checkFolder(persistentDataPath + "/Data/UserData"); // user data folder
        checkFolder(persistentDataPath + "/Data/ChatData"); // chat data folder
        checkFolder(persistentDataPath + "/Data/GeschiedenisData"); // geschiedenis data folder
    }

    public static void saveData(SaveData saveData, DataObject dataObject){
        checkAllFolders();
        checkFolder(persistentDataPath + "/Data/" + dataObject.type + "/" + dataObject.id);
        writeToFile(saveData.getData(), persistentDataPath + "/Data/" + dataObject.type + "/" + dataObject.id + "/" + dataObject.id + ".txt");
    }

    public static UserData loadUserData(String id) {
        SaveData saveData = new SaveData();
        String rawData = readFile(persistentDataPath + "/Data/UserData/" + id + "/" + id + ".txt").trim();
        saveData.setData(rawData);
        UserData dataObject = new UserData();
        dataObject.load(saveData);
        return dataObject;

    }
    public static DataObject loadDataObject(String id, String type){
        SaveData saveData = new SaveData();
        String rawData = readFile(persistentDataPath + "/Data/" + type + "/" + id + "/" + id + ".txt").trim();
        saveData.setData(rawData);
        DataObject dataObject;
        switch (type) {
            case "UserData":
                dataObject = new UserData();
                break;
            case "ChatData":
                dataObject = new ChatData();
                break;
            case "GeschiedenisData":
                dataObject = new GeschiedenisData();
                break;
            default:
                dataObject = null;
        }
        dataObject.load(saveData);

        return dataObject;
    }

    public static Map<Map<String, String>, DataObject> loadAllDataObjecten(String type) {
        checkAllFolders();
        File dataFolder = new File(persistentDataPath + "/Data/" + type + "/");
        File[] dataFolders = dataFolder.listFiles();
        if (dataFolders != null) {
            for (File dataF : dataFolders) {
                if (dataF.isDirectory()) {
                    String id = dataF.getName();
                    hashMap.put(id, type);
                    mapje.put(hashMap, loadDataObject(id, type));
                }
            }
        }
        return mapje;
    }

    public static void initialize(){
        MockupDatabase database = new MockupDatabase();
        database.mapje = loadAllDataObjecten("UserData");
        mapje = loadAllDataObjecten("ChatData");
    }
}