package be.renaudraas.playground.ui.feature.github;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import be.renaudraas.playground.R;
import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.ui.BaseFragment;
import be.renaudraas.playground.util.DebugLog;

public class GithubTaskFragment extends BaseFragment {

    private ViewHolder viewHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.github_fragment, container, false);

        viewHolder = new ViewHolder();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GithubTaskPresenter githubPresenter = new GithubTaskPresenter();
        githubPresenter.attachView(new GithubMvpView() {
            @Override
            public void onLoading(boolean isLoading) {
                DebugLog.d("onLoading : " + isLoading);
            }

            @Override
            public void onRepositoriesFetched(List<Repository> repositories) {
                DebugLog.d("onRepositoriesFetched : " + repositories.size());
            }

            @Override
            public void onError(Throwable t) {
                DebugLog.d("onError : " + t.getLocalizedMessage());
            }
        });
        githubPresenter.fetchRepositories("Hoolii");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        viewHolder = null;
    }

    private static class ViewHolder {

    }
}
