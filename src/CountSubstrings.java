import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class CountSubstrings {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner user = new Scanner(System.in);
        System.out.println("Please enter the path for the input file: ");
        String path = user.nextLine();
        System.out.println("Enter the pattern to look for: ");
        String pattern = user.nextLine();
        arr(pattern,path);
        lin(pattern,path);
        // C:\Users\Phuc\Desktop\LesMis.txt
    }

    /**
     * This function find and display the number of times the word that the user choose appear in the document
     * using ArrayLists.
     * The function also output the time the function take to find and output the result.
     * @param pattern is the word that the user choose
     * @param path is the location of the file
     * @throws FileNotFoundException throws an exception when the file
     * that the user choose is not found at the location that the user provide
     */
    public static void arr(String pattern, String path) throws FileNotFoundException{
        long start = System.currentTimeMillis();
        ArrayList<Character> pat = new ArrayList<>();
        int counter = 0;
        for(int x = 0; x<pattern.length();x++){
            pat.add(pattern.charAt(x));
        }
        File file = new File(path);
        Scanner s = new Scanner(file);
        ArrayList<Character> lst = new ArrayList<Character>();
        while(s.hasNext()) {
            String word = s.next();
            for(int i = 0; i< word.length();i++){
                lst.add(word.charAt(i));
            }
            if(findBrute(lst,pat)!=-1){
                counter++;
                lst.clear();
            }else{
                lst.clear();
            }
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Using ArrayLists: "+ counter+" matches, derived  in "+time+" milliseconds.");
    }

    /**
     * This function find and display the number of time the word that the user choose
     * appear in the document using LinkedLists.
     * The function also display the time it take for this function to find and display the output.
     * @param pattern is the word that the user choose to find the number of occurrence in the document
     * @param path is the location of the file that the user provide
     * @throws FileNotFoundException throws an exception when the file that the user choose is not found at the location
     * that the user provide
     */
    public static void lin(String pattern, String path) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        LinkedList<Character> pat = new LinkedList<Character>();
        int count = 0;
        for(int x = 0; x<pattern.length();x++){
            pat.add(pattern.charAt(x));
        }
        File file = new File(path);
        Scanner s = new Scanner(file);
        LinkedList<Character> lst = new LinkedList<Character>();
        while(s.hasNext()) {
            String word = s.next();
            for(int i = 0; i< word.length();i++){
                lst.add(word.charAt(i));
            }
            if(findBrute(lst,pat)!=-1){
                count++;
                lst.clear();
            }else{
                lst.clear();
            }
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Using LinkedLists: "+ count+" matches, derived  in "+time+" milliseconds.");
    }
    /*
     * Returns the lowest index at which substring pattern begins in text (or
     * else -1).
     */
    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index
            // within text
            int k = 0; // k is index into pattern
            while (k < m && text.get(i + k) == pattern.get(k))
                // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }
}
