package Components;

import Renderers.HangManRender;
import com.googlecode.lanterna.gui2.AbstractComponent;
import com.googlecode.lanterna.gui2.ComponentRenderer;

import java.util.ArrayList;

public class HangManView extends AbstractComponent<HangManView> {
    private int numOfParts = 0;
    @Override
    protected ComponentRenderer<HangManView> createDefaultRenderer() {
        return new HangManRender();
    }
    public void addPart() throws Exception {
        if (this.numOfParts < 6){
            this.numOfParts +=1;
            this.invalidate();
        }
        else {
            this.numOfParts += 1;
            this.invalidate();
            throw new Exception("No more parts to add.");
        }

    }

    public int getNumOfParts() {
        return numOfParts;
    }
}
