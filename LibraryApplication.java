
import java.util.*;

// IFilm interface
interface IFilm {

    String getTitle();

    String getDirector();

    int getYear();
}

// Film class implementing IFilm interface
class Film implements IFilm {

    private final String title;
    private final String director;
    private final int year;

    public Film(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " (" + director + ", " + year + ")";
    }
}
// FilmLibrary interface

interface IFilmLibrary {

    void addFilm(IFilm film);

    void removeFilm(String title);

    List<IFilm> getFilms();

    List<IFilm> searchFilms(String query);

    int getTotalFilmCount();
}

// FilmLibrary class implementing IFilmLibrary
class FilmLibrary implements IFilmLibrary {

    private final List<IFilm> films;

    public FilmLibrary() {
        films = new ArrayList<>();
    }

    @Override
    public void addFilm(IFilm film) {
        films.add(film);
    }

    @Override
    public void removeFilm(String title) {
        for (Iterator<IFilm> it = films.iterator(); it.hasNext();) {
            IFilm film = it.next();
            if (film.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Removed Film: " + film);
                it.remove();
                return;
            }
        }
        System.out.println("Film not found: " + title);
    }

    @Override
    public List<IFilm> getFilms() {
        return films;
    }

    @Override
    public List<IFilm> searchFilms(String query) {
        List<IFilm> results = new ArrayList<>();
        for (IFilm film : films) {
            if (film.getTitle().toLowerCase().contains(query.toLowerCase())
                    || film.getDirector().toLowerCase().contains(query.toLowerCase())) {
                results.add(film);
            }
        }
        return results;
    }

    @Override
    public int getTotalFilmCount() {
        return films.size();
    }
}

public class LibraryApplication {

    public static void main(String[] args) {
        System.out.println("Enter the number of films:");
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());

            // Add films to the library
            FilmLibrary library = new FilmLibrary();
            for (int i = 0; i < n; i++) {
                String[] parts = sc.nextLine().split(" ");
                String title = parts[0];
                String director = parts[1];
                int year = Integer.parseInt(parts[2]);
                library.addFilm(new Film(title, director, year));
            }

            // Search films by query
            System.out.println("Enter the search query:");
            String query = sc.nextLine();
            // Title of the film to delete
            System.out.println("Enter the title of the film to delete:");
            String toDelete = sc.nextLine();

            // Output the total number of films in the library
            System.out.println("Total Film Count: " + library.getTotalFilmCount());

            // Output the search results for the query
            System.out.println("Search Results for " + query + ":");
            for (IFilm film : library.searchFilms(query)) {
                System.out.println(film);
            }

            library.removeFilm(toDelete);

            System.out.println("All Films:");
            for (IFilm film : library.getFilms()) {
                System.out.println(film);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers for film count and year.");
        }
    }
}
