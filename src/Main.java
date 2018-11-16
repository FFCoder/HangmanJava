import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService service =  Executors.newFixedThreadPool(2);
        Future<String>  future = service.submit(new WordPicker());
        while(!future.isDone()){
            System.out.println("Please Wait. Guessing Word");
            Thread.sleep(1000);
        }
        WordGuesser guesser = WordGuesser.getInstance();
        guesser.setWord(future.get());

        Scanner input = new Scanner(System.in);
        while (!guesser.is_finished()){
            for (Character c : guesser.getWordArray()){
                System.out.print(c);
                System.out.print(' ');
            }
            // Print a Blank Line
            System.out.println();
            System.out.println("Please Guess a Letter: ");
            String guess = input.next();
            char guessChar = guess.charAt(0);
            guesser.guessLetter(guessChar);
            System.out.println("\n");

        }
        System.out.println("Congratulations! You Guessed the Correct Word of: ");
        String result = "";
        for (Character c : guesser.getWordArray()){
            result+=c;
        }
        System.out.print(result);

        service.shutdown();


    }
}
