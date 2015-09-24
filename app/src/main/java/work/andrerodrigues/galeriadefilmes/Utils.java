package work.andrerodrigues.galeriadefilmes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by USER01 on 24/09/2015.
 */
public class Utils {

    public static String URL_BASE = "http://andrecode.com.br/cakephp27/";
    public static String EXTENSION = ".json";
    public static String DIR_IMAGE = "img/movies/";

    public static ArrayList<String> ARRAY_CATEGORIES = new ArrayList<>();
    public static ArrayList<String> ARRAY_GENRES = new ArrayList<>(Arrays.asList("Todos"));
    public static ArrayList<String> ARRAY_GENRES_MOVIES = new ArrayList<>();
    public static ArrayList<String> ARRAY_MOVIES = new ArrayList<>();

    public static String URL_CATEGORIES(String limit) {
        if (limit == null) {
            return URL_BASE + "categories/getindex" + EXTENSION;
        }
        return URL_BASE + "categories/getindex/limit:" + limit + EXTENSION;
    }
    public static String URL_GENRES(String limit) {
        return URL_BASE + "genres/getindex" + EXTENSION;
    }
    public static String URL_GENRES_MOVIES(String limit) {
        if (limit == null) {
            return URL_BASE + "genres_movies/getindex" + EXTENSION;
        }
        return URL_BASE + "genres_movies/getindex/limit:" + limit + EXTENSION;
    }
    public static String URL_MOVIES(String limit) {
        return URL_BASE + "movies/getindex" + EXTENSION;
    }
}
