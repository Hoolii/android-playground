package be.renaudraas.playground.ui.feature.github;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import be.renaudraas.playground.business.model.Repository;

public interface GithubMvpView extends MvpView {
    void onLoading(boolean isLoading);

    void onRepositoriesFetched(List<Repository> repositories);

    void onError(Throwable t);
}
