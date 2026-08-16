package CRUD;

public class FinishedBooks {
    private int book_id;
    private String book_finished_date;
    private String book_read_time;
    private int book_score;
    private String book_summary;
    public FinishedBooks(int book_id, String book_finished_date, String book_read_time, int book_score, String book_summary){
        this.book_id = book_id;
        this.book_finished_date = book_finished_date;
        this.book_read_time = book_read_time;
        this.book_score = book_score;
        this.book_summary = book_summary;
    }
    public int getBook_id(){
        return book_id;
    }
    public String getBook_finished_date(){
        return book_finished_date;
    }
    public  String getBook_read_time(){
        return book_read_time;
    }
    public int getBook_score(){
        return book_score;
    }
    public String getBook_summary(){
        return book_summary;
    }
}
