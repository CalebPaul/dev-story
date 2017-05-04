package calebpaul.jrdevstory.model;

import calebpaul.jrdevstory.R;

public class Story {
    private Page[] pages;

    public Story() {
        pages = new Page[11];

        pages[0] = new Page(R.drawable.main,
                R.string.page0,
                new Choice(R.string.page0_choice1, 1),
                new Choice(R.string.page0_choice2, 2)
        );

        pages[1] = new Page(R.drawable.main,
                R.string.page1,
                new Choice(R.string.page1_choice1, 4),
                new Choice(R.string.page1_choice2, 3)
        );

        pages[2] = new Page(R.drawable.main,
                R.string.page2,
                new Choice(R.string.page2_choice1, 3),
                new Choice(R.string.page2_choice2, 5)
        );

        pages[3] = new Page(R.drawable.main,
                R.string.page3,
                new Choice(R.string.page3_choice1, 6),
                new Choice(R.string.page3_choice2, 9)
        );

        pages[4] = new Page(R.drawable.main,
                R.string.page4,
                new Choice(R.string.page4_choice1, 7),
                new Choice(R.string.page4_choice2, 10)
        );

        pages[5] = new Page(R.drawable.main,
                R.string.page5,
                new Choice(R.string.page5_choice1, 11),
                new Choice(R.string.page5_choice2, 8)
        );

        pages[6] = new Page(R.drawable.main,
                R.string.page3_lose
        );

        pages[7] = new Page(R.drawable.main, R.string.page4_lose);

        pages[8] = new Page(R.drawable.main, R.string.page5_lose);

        pages[9] = new Page(R.drawable.main, R.string.page3_win);

        pages[10] = new Page(R.drawable.main, R.string.page4_win);

        pages[11] = new Page(R.drawable.main, R.string.page5_win);

    }
}