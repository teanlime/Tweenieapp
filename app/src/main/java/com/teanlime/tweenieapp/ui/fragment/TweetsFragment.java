package com.teanlime.tweenieapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teanlime.tweenieapp.tweenieapp.R;

/**
 * @author Anna on 10/10/2015.
 */
public class TweetsFragment extends Fragment {

    public static TweetsFragment newInstance() {
        return new TweetsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tweets, container, false);
    }
}
