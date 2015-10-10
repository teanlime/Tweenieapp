package com.teanlime.tweenieapp.ui.activity.tweets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.teanlime.tweenieapp.tweenieapp.R;
import com.teanlime.tweenieapp.ui.fragment.TweetsFragment;

/**
 * @author Anna on 10/10/2015.
 */
public class TweetsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            setContentView(R.layout.activity_content_and_toolbar);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, TweetsFragment.newInstance()).commit();

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_plain);
            toolbar.setTitle(R.string.activity_tweets_title);
            setSupportActionBar(toolbar);
        }
    }
}
