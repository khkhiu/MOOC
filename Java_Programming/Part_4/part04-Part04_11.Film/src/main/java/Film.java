/*
 * Create a film class with the instance variables name (String) and ageRating (int). 
 * Write the constructor public Film(String filmName, int filmAgeRating) 
 * for the class, and also the methods public String name() and public int ageRating(). 
 * The first of these returns the film title and the second returns its rating.
 */
public class Film {
    private String name;
    private int ageRating;

    public Film(String filmName, int filmAgeRating){
        this.name = filmName;
        this.ageRating = filmAgeRating;
    }

    public String name(){
        return this.name;
    }

    public int ageRating(){
        return this.ageRating;
    }
}
