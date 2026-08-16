package CRUD;

public class Authors {
    private int id;
    private String name;
    private String score;
    public Authors(int id, String name, String score){
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId(){return id;}
    public String getName(){
        return name;
    }
    public String getScore(){return score;}
}
