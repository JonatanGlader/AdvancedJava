import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    static List<Finding> answers = new ArrayList<>();
    static int amountFound = 0;
    static int part = 0;

    public static void main(String[] args) {
        String urlPath = "src\\text.txt";

    //part 1
        //patterns to find
        String alphabet = "[Aa][Bb][Cc][Dd][Ee][Ff][Gg][Hh][Ii][Jj]";

        readFile(urlPath, alphabet, true);
        amountFound = 0;

    //part 2
        String ola = "[Oo][Ll][Aa]";

        readFile(urlPath, ola, true);
        amountFound = 0;

    //part 3
        //Hitta stort eller litet a, och det ska vara 3-5 stycken
        String as = "[Aa]{3,5}";

        readFile(urlPath, as, true);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

    //part 4
        String noAlfaNum = "[\\W]{2,}";

        readFile(urlPath, noAlfaNum, false);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

    //Part 5
        String email = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}";

        readFile(urlPath, email, true);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

    //part 6
        //All mobile and "homephones" numbers allowed here
        //example of formats:
        //0nn nnnnn<
        //0n-nnnnn<
        //0nnn-nnnn
        String phoneNumber = "0[0-9]{1,3}[\\s/-]?[0-9]{5,}";

        readFile(urlPath, phoneNumber, true);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

    //part 7
        //"Capture group and boundaries"
        String fourOfAKind = "([A-Za-z])\\1{3}";

        readFile(urlPath, fourOfAKind, false);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

    //part 8
        //both Capital and common letters are allowed here
        String regNmr = "[A-Za-z]{3}[/_][0-9]{3}";

        readFile(urlPath, regNmr, true);
        amountFound = 0;

    //part 9
        //Paranthesis with the following formats: (can be longer than 3)
        //(abc)
        //(123)
        //(   )
        String matchingParenthesis = "[(][A-Za-z]+[)]|[(][0-9]+[)]|[(][\\s]+[)]";

        readFile(urlPath, matchingParenthesis, true);
        answers.add(new Finding(part, amountFound));
        amountFound = 0;

   //part 10
        String ifOrFor = "if[\\s]?[(]|for[\\s]?[(]";

        readFile(urlPath, ifOrFor, true);
        amountFound = 0;

        System.out.println(answers);
    }

    public static void readFile(String path, String pattern, boolean findPosition) {
        try {
        part++;
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        int currentLine = 1;

            while (myReader.hasNextLine()) {
                String lineText = myReader.nextLine();
                findPattern(lineText, currentLine, pattern, findPosition);
                currentLine++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void findPattern(String lineText, int currentLine, String pattern, boolean findPosition) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(lineText);

        while(matcher.find()){
            if(matcher.group().length() != 0) {
                if(findPosition) {
                    answers.add(new Finding(part, matcher.group(), currentLine, matcher.start(), matcher.end()));
                    amountFound++;
                } else {
                    amountFound++;
                }
            }
        }
    }
}