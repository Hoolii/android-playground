package be.renaudraas.playground.ui.feature.github;

import android.os.Bundle;
import android.support.annotation.Nullable;

import be.renaudraas.playground.R;
import be.renaudraas.playground.ui.BaseActivity;

public class GithubActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_activity);
    }
}
