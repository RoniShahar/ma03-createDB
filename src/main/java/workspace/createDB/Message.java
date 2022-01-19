package workspace.createDB;

public class Message {

    public void printEntityNotFoundMessage(String entityName, String dbName){
        System.out.println(entityName + " entity not found in " + dbName + " DB");
    }

    public void printKeyNotFoundMessage(String entityName, Object key){
        System.out.println(key.toString() + " key not found in " + entityName + " entity");
    }
}
