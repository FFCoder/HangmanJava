import Components.HangManView;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        //Setup the initial Objects
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
        BasicWindow window = new BasicWindow();
        window.setTitle("Hangman");
        window.setHints(Collections.singleton(Window.Hint.CENTERED));

        // Setup a Task Pool to pull a new word on another thread.
        ExecutorService service =  Executors.newFixedThreadPool(2);
        Future<String>  future = service.submit(new WordPicker());

        // Show a Waiting message while Dictionary is accessed and word is picked.
        while(!future.isDone()){
            window.setComponent(new Label("Please Wait Guessing Word..."));
        }
        // Create a Word Guesser Singleton
        WordGuesser guesser = WordGuesser.getInstance();
        // Get the Word from the Thread Pool
        String word = future.get();
        // Give the word guesser the word.
        guesser.setWord(word);
        // Setup UI
        Panel hangManPanel = new Panel(new LinearLayout(Direction.VERTICAL));
        HangManView hangManView = new HangManView();
        hangManPanel.addComponent(hangManView);

        Panel inputPanel = new Panel(new GridLayout(2));
        hangManPanel.addComponent(inputPanel);

        Label lblWordArray = new Label(guesser.getStringResult());
        inputPanel.addComponent(lblWordArray);
        inputPanel.addComponent(new EmptySpace());
        inputPanel.addComponent(new Label("Guess: "));
        TextBox txtGuess = new TextBox();

        // Only accept letters
        txtGuess.setValidationPattern(Pattern.compile("[a-zA-Z]"));
        inputPanel.addComponent(txtGuess);
        Button guessButton = new Button("Guess");
        guessButton.addListener(new Button.Listener() {
            @Override
            public void onTriggered(Button button) {
                char letter;
                try {
                    letter = txtGuess.getText().toCharArray()[0];
                }
                catch (ArrayIndexOutOfBoundsException x){
                    letter = ' ';
                }
                if (guesser.guessLetter(letter)){
                    lblWordArray.setText(guesser.getStringResult());
                }
                else {
                    try {
                        hangManView.addPart();
                    } catch (Exception e) {
                        MessageDialog.showMessageDialog(gui,"Game Over","Game Over!!");
                        System.exit(0);
                    }
                }
                txtGuess.takeFocus();
                txtGuess.setText("");
                if (guesser.is_finished()){
                    MessageDialog.showMessageDialog(gui,"Congratulations!","You Win!");
                    System.exit(0);
                }
            }
        });
        inputPanel.addComponent(guessButton);

        window.setComponent(hangManPanel);
        gui.addWindowAndWait(window);



        service.shutdown();


    }
}
