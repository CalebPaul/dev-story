package calebpaul.jrdevstory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Stack;

import calebpaul.jrdevstory.Constants;
import calebpaul.jrdevstory.R;
import calebpaul.jrdevstory.model.Page;
import calebpaul.jrdevstory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public final static String TAG = StoryActivity.class.getSimpleName();

    private Story story;
    private String name;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private Stack<Integer> pageStack = new Stack<>();
    private InterstitialAd mInterstitialAd;
    private MediaPlayer typing;
    private MediaPlayer win;
    private MediaPlayer lose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        choice1Button = (Button) findViewById(R.id.choice1Button);
        choice2Button = (Button) findViewById(R.id.choice2Button);

        typing = MediaPlayer.create(this, R.raw.typing);
        win = MediaPlayer.create(this, R.raw.win);
        lose = MediaPlayer.create(this, R.raw.lose);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(Constants.AD_UNIT_ID);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if (name == null || name.isEmpty()) {
            name = "friend";
        }

        story = new Story();
        loadPage(0);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(Constants.TEST_DEVICE_ID)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        final Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImgId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        if (page.isEndPage()) {

            //TODO - Fix comparative operator logic
            if (pageText == ( "page3_win") || pageText == ( "page4_win" ) || pageText == ("page5_win" ) ) {
                win.start();
            } else {
                lose.start();
            }

            requestNewInterstitial();
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button_text);
            pageStack.clear();
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        finish();
                    } else {
                        finish();
                    }
                }
            });
        } else {
            typing.start();
            loadButtons(page);
        }
    }

    private void loadButtons(final Page page) {
        choice1Button.setVisibility(View.VISIBLE);
        choice1Button.setText(page.getChoice1().getTextId());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }

}
