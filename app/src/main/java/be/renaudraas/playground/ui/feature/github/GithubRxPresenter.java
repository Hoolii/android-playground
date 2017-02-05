package be.renaudraas.playground.ui.feature.github;

import java.util.List;

import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.business.usecase.GetRepositoriesUseCase;
import be.renaudraas.playground.util.mvp.BaseRxMvpPresenter;

public class GithubRxPresenter extends BaseRxMvpPresenter<GithubMvpView, List<Repository>> {

    void fetchRepositories(String user) {
        getView().onLoading(true);
        subscribe(new GetRepositoriesUseCase(user).execute());
    }

    @Override
    protected void onNext(List<Repository> repositories) {
        getView().onLoading(false);
        getView().onRepositoriesFetched(repositories);
    }

    @Override
    protected void onError(Throwable e) {
        getView().onLoading(false);
        getView().onError(e);
    }

    @Override
    protected void onCompleted() {
    }
}
