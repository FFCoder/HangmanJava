package Images;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.util.ArrayList;

public class Galley implements TextImage {
    private char[][] image = {
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ','*','-','-','-','-','-','-','-','-','-','*',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ','_','_','_','_','_','_','_','_','_','_','|','_','_','_','_','_',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}


    };
    public Galley() {

    }

    @Override
    public TerminalSize getSize() {
        return new TerminalSize(20,15);
    }

    @Override
    public TextCharacter getCharacterAt(TerminalPosition terminalPosition) {
        int row = terminalPosition.getRow();
        int col = terminalPosition.getColumn();
        TextCharacter character = new TextCharacter(image [row][col]);
        return character;
    }

    @Override
    public TextCharacter getCharacterAt(int i, int i1) {
        try {
            return new TextCharacter(image[i1][i]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return new TextCharacter(' ');
        }

    }

    @Override
    public void setCharacterAt(TerminalPosition terminalPosition, TextCharacter textCharacter) {
        int row = terminalPosition.getRow();
        int col = terminalPosition.getColumn();
        image[row][col] = textCharacter.getCharacter();
    }

    @Override
    public void setCharacterAt(int i, int i1, TextCharacter textCharacter) {
        image[i][i1] = textCharacter.getCharacter();
    }

    @Override
    public void setAll(TextCharacter textCharacter) {
        for (int i = 0; i<15;i++){
            for (int y = 0;y<20;y++){
                image[i][y] = textCharacter.getCharacter();
            }
        }
    }

    @Override
    public TextGraphics newTextGraphics() {

        return null;
    }

    @Override
    public TextImage resize(TerminalSize terminalSize, TextCharacter textCharacter) {
        return null;
    }

    @Override
    public void copyTo(TextImage textImage) {

    }

    @Override
    public void copyTo(TextImage textImage, int i, int i1, int i2, int i3, int i4, int i5) {

    }

    @Override
    public void scrollLines(int i, int i1, int i2) {

    }
}
