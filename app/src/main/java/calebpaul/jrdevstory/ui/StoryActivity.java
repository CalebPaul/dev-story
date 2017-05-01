package calebpaul.jrdevstory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import calebpaul.jrdevstory.R;
import calebpaul.jrdevstory.model.Page;

public class StoryActivity extends AppCompatActivity {

    public final static String TAG = StoryActivity.class.getSimpleName();

    private Page[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (name == null || name.isEmpty()) {
            name = "friend";
        }

//        pages = new Page[]
    }
}
