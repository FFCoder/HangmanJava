
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class WordPicker implements Callable<String> {
    @Override
    public String call(){
        URI uri = URI.create("file://dictionary.txt");
        int lineLength = 41258;

        while (true) {
            int lineNumber = new Random().nextInt(lineLength);
            try {
                String lineR = Files.readAllLines(Paths.get("./src/dictionary.txt")).get(lineNumber);
                if (lineR.length() <= 10){

                    return lineR;
                }
            } catch (NoSuchFileException x){
                System.out.println(Paths.get("").toAbsolutePath().toString());
                x.printStackTrace();
                System.exit(-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
