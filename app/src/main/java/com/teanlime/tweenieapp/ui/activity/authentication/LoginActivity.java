package com.teanlime.tweenieapp.ui.activity.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.teanlime.tweenieapp.ui.activity.tweets.TweetsActivity;
import com.teanlime.tweenieapp.tweenieapp.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    private TwitterLoginButton loginButton;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(getString(R.string.twitter_key), getString(R.string.twitter_secret));
        Fabric.with(this, new Twitter(authConfig));

        setContentView(R.layout.activity_login);

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new LoginHandler());
        status = (TextView) findViewById(R.id.status);
        final String text = "Status: Ready";
        status.setText(text);

    }

    private class LoginHandler extends Callback<TwitterSession> {
        @Override
        public void success(Result<TwitterSession> twitterSessionResult) {
            startActivity(new Intent(LoginActivity.this, TweetsActivity.class));
//            String output = "Status: " +
//                    "Your login was successful " +
//                    twitterSessionResult.data.getUserName() +
//                    "\nAuth Token Received: " +
//                    twitterSessionResult.data.getAuthToken().token;
//
//            status.setText(output);
        }

        @Override
        public void failure(TwitterException e) {
            final String text = "Status: Login Failed";
            status.setText(text);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}

