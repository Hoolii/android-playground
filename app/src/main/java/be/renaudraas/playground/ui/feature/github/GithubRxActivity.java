package be.renaudraas.playground.ui.feature.github;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import be.renaudraas.playground.R;
import be.renaudraas.playground.ui.BaseActivity;

public class GithubRxActivity extends BaseActivity {

    public static Intent makeIntent(Context context) {
        Intent intent = new Intent(context, GithubRxActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_rx_activity);
    }
}
