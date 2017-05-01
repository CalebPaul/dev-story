package calebpaul.jrdevstory.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import calebpaul.jrdevstory.R;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
