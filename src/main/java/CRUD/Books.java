package CRUD;

public class Books {
    private int author_id;
    private int book_id;
    private String book_name;
    private String book_added_date;
    private String book_type;
    private String book_language;
    private int book_page_number;

    public Books(int author_id, int book_id, String book_name, String book_added_date, String book_type, String book_language, int book_page_number){
        this.author_id = author_id;
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_added_date = book_added_date;
        this.book_type = book_type;
        this.book_language = book_language;
        this.book_page_number = book_page_number;
    }
    public int getAuthor_id(){
        return author_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_added_date() {
        return book_added_date;
    }

    public String getBook_language() {
        return book_language;
    }

    public int getBook_page_number() {
        return book_page_number;
    }

    public String getBook_type() {
        return book_type;
    }
}
