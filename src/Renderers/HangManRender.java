package Renderers;

import Components.HangManView;
import Images.Galley;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.ComponentRenderer;
import com.googlecode.lanterna.gui2.TextGUIGraphics;

public class HangManRender implements ComponentRenderer<HangManView> {

    private void drawHead(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(2,3),"O");
    }
    private static void drawNeck(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(2,4),"|");
    }
    private static void drawTorso(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(2,5),"|");
    }
    private static void drawLeftArm(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(1,4),"/");
    }
    private static void drawRightArm(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(3,4),"\\");
    }
    private static void drawLeftLeg(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(1,6),"/");
    }
    private static void drawRightLeg(TextGUIGraphics graphics){
        graphics.putString(new TerminalPosition(3,6),"\\");
    }

    @Override
    public TerminalSize getPreferredSize(HangManView hangManView) {
        return new TerminalSize(30,18);
    }

    @Override
    public void drawComponent(TextGUIGraphics textGUIGraphics, HangManView hangManView) {
        textGUIGraphics.drawImage(TerminalPosition.TOP_LEFT_CORNER,new Galley());
        switch (hangManView.getNumOfParts()){
            case 0:
                break;
            case 1:
                drawHead(textGUIGraphics);
                break;
            case 2:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                break;
            case 3:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                drawLeftArm(textGUIGraphics);
                break;
            case 4:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                drawLeftArm(textGUIGraphics);
                drawRightArm(textGUIGraphics);
                break;
            case 5:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                drawLeftArm(textGUIGraphics);
                drawRightArm(textGUIGraphics);
                drawTorso(textGUIGraphics);
                break;
            case 6:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                drawLeftArm(textGUIGraphics);
                drawRightArm(textGUIGraphics);
                drawTorso(textGUIGraphics);
                drawLeftLeg(textGUIGraphics);
                break;
            case 7:
                drawHead(textGUIGraphics);
                drawNeck(textGUIGraphics);
                drawLeftArm(textGUIGraphics);
                drawRightArm(textGUIGraphics);
                drawTorso(textGUIGraphics);
                drawLeftLeg(textGUIGraphics);
                drawRightLeg(textGUIGraphics);
                break;
        }


    }


}
