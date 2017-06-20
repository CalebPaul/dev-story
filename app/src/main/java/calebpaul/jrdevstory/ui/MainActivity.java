package calebpaul.jrdevstory.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.newrelic.agent.android.NewRelic;

import calebpaul.jrdevstory.Constants;
import calebpaul.jrdevstory.R;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();

    private EditText nameField;
    private Button startButton;
    private MediaPlayer start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = MediaPlayer.create(this, R.raw.start);
        start.start();

        nameField = (EditText) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });

        NewRelic.withApplicationToken(
                Constants.NEW_RELIC_TOKEN
        ).start(this.getApplication());
    }

    @Override
    protected void onResume() {
        super.onResume();
        start.start();
        nameField.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_credits) {
            aboutIntent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void aboutIntent() {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
