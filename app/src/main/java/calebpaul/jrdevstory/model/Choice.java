package calebpaul.jrdevstory.model;

public class Choice {
    public Choice(int textId, int nextPage) {
        this.textId = textId;
        this.nextPage = nextPage;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    private int textId;
    private int nextPage;


    public int getNextPage() {
        return nextPage;
    }

    public int getTextId() {
        return textId;
    }
}
