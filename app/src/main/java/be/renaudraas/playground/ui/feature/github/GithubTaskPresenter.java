package be.renaudraas.playground.ui.feature.github;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

import java.util.List;

import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.business.task.GetRepositoriesTask;
import be.renaudraas.playground.util.mvp.BaseTaskMvpPresenter;

class GithubTaskPresenter extends BaseTaskMvpPresenter<GithubMvpView> {

    void fetchRepositories(String user) {
        getView().onLoading(true);
        Task<List<Repository>> repositories = Tasks.call(getExecutor(), new GetRepositoriesTask(user));
        repositories.addOnSuccessListener(repositories1 -> {
            getView().onLoading(false);
            getView().onRepositoriesFetched(repositories1);
        });
    }
}
