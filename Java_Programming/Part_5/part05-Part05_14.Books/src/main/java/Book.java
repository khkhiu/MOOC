
public class Book {

    private String name;
    private int publicationYear;

    public Book(String name, int publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    //Code for comparing info on books enterred
    public boolean equals(Object compared){
        if (this == compared){
            return true;
        }
        if (!(compared instanceof Book)){
            return false;
        }

        Book compareBook = (Book) compared;

        if (this.name.equals(compareBook.name) &&
            this.publicationYear == compareBook.publicationYear
        ){
            return true;
        }
        return false;
    }
}
