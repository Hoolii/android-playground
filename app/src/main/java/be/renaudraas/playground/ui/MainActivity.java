package be.renaudraas.playground.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import be.renaudraas.playground.R;
import be.renaudraas.playground.ui.feature.github.GithubRxActivity;
import be.renaudraas.playground.ui.feature.github.GithubTaskActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        findViewById(R.id.rx_github).setOnClickListener(v -> startActivity(GithubRxActivity.makeIntent(this)));
        findViewById(R.id.task_github).setOnClickListener(v -> startActivity(GithubTaskActivity.makeIntent(this)));
    }
}
