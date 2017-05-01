package calebpaul.jrdevstory.model;

/**
 * Created by calebpaul on 4/28/17.
 */

public class Page {
    private int ImgId;
    private int TextId;
    private Choice choice1;
    private Choice choice2;

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public int getTextId() {
        return TextId;
    }

    public void setTextId(int textId) {
        TextId = textId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
