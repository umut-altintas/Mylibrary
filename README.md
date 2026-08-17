# Book Management System

A desktop book management application developed in **Java**. The application allows users to manage authors and books, track finished books, and store related information in a local SQLite database.

## Technologies Used

* **Java** — Main programming language
* **Java Swing** — Graphical User Interface
* **JDBC** — Database connectivity and database operations
* **SQLite** — Local relational database

## Features

* Add and manage authors
* Add and manage books
* View authors and books in tables
* Track finished books
* Store book finishing date
* Store reading time
* Store book scores
* Store book summaries
* Manage relationships between authors and books
* Automatically remove related books when an author is deleted using SQL foreign-key constraints
* Automatically remove related finished-book records when a book is deleted

## Database Structure

The application uses a relational SQLite database with three main tables:

```text
authors
   │
   │ author_id
   ▼
books
   │
   │ book_id
   ▼
finished_books
```

### `authors`

Stores information about authors.

* `author_id`
* `author_name`
* `author_score`

### `books`

Stores information about books and their authors.

* `book_id`
* `author_id`
* `book_name`
* `book_added_date`
* `book_type`
* `book_language`
* `book_page_number`

### `finished_books`

Stores information about completed books.

* `book_id`
* `book_finished_date`
* `book_read_time`
* `book_score`
* `book_summary`

Foreign-key relationships use `ON DELETE CASCADE` to maintain database consistency.

## Project Structure

```text
src/
└── main/
    ├── java/
    │   ├── CRUD/
    │   │   └── Database-related classes
    │   │
    │   └── UI/
    │       └── Swing user-interface classes
    │
    └── resources/
        └── CreateDb.sql
```

## Database

The application uses **SQLite** as a local database. Database operations are performed through the **JDBC API**.

SQLite foreign-key enforcement is enabled for each database connection using:

```sql
PRAGMA foreign_keys = ON;
```

This ensures that cascading deletes work correctly.

## User Interface

The graphical interface is built using **Java Swing**.

The UI uses components such as:

* `JFrame`
* `JPanel`
* `JTable`
* `JScrollPane`
* `JMenuBar`
* `JMenu`
* `JMenuItem`
* `JTextField`
* `JButton`

Different views are displayed through panels, allowing the application to switch between author, book, and finished-book tables.

## Purpose

This project was developed as a practical Java application to gain experience with:

* Object-oriented programming
* Java Swing
* JDBC
* SQL and relational databases
* SQLite
* CRUD operations
* Foreign-key relationships
* Event-driven GUI programming
* Separating UI and database logic

## Future Improvements

Possible future improvements include:

* Search and filtering
* Sorting books and authors
* Improved input validation
* Editing existing records
* Book cover images
* Statistics and reading progress
* Better UI styling
* Database backup and export
* Improved exception handling

## License

This project is intended for educational and personal use.
