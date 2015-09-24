package work.andrerodrigues.galeriadefilmes;

import java.util.ArrayList;

/**
 * Created by USER01 on 24/09/2015.
 */
public class Utils {

    public static String URL_BASE = "http://andrecode.com.br/cakephp27/";
    public static String URL_CATEGORIES = URL_BASE + "categories/getindex.json";
    public static String URL_GENRES = URL_BASE + "genres/getindex.json";
    public static String URL_GENRES_MOVIES = URL_BASE + "genres_movies/getindex.json";
    public static String URL_MOVIES = URL_BASE + "movies/getindex.json";

    public static ArrayList<String> ARRAY_CATEGORIES = new ArrayList<>();
    public static ArrayList<String> ARRAY_GENRES = new ArrayList<>();
    public static ArrayList<String> ARRAY_GENRES_MOVIES = new ArrayList<>();
    public static ArrayList<String> ARRAY_MOVIES = new ArrayList<>();
}
