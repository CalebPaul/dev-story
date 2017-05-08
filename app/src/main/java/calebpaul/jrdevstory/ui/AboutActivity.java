package calebpaul.jrdevstory.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import us.feras.mdv.MarkdownView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MarkdownView markdownView = new MarkdownView(this);
        setContentView(markdownView);
        markdownView.loadMarkdownFile("file:///android_asset/credits.md");
//        markdownView.loadMarkdown("https://raw.githubusercontent.com/CalebPaul/graveyard-ninja/master/README.md");
    }
}
