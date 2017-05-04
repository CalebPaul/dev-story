package calebpaul.jrdevstory.model;

public class Page {
    private int ImgId;
    private int TextId;
    private Choice choice1;
    private Choice choice2;
    private boolean isEndPage = false;

    public Page(int imgId, int textId) {
        ImgId = imgId;
        TextId = textId;
        this.isEndPage = true;
    }

    public Page(int imgId, int textId, Choice choice1, Choice choice2) {
        ImgId = imgId;
        TextId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public boolean isEndPage() {
        return isEndPage;
    }

    public void setEndPage(boolean endPage) {
        isEndPage = endPage;
    }

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
