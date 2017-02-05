package be.renaudraas.playground.business.task;

import java.util.List;
import java.util.concurrent.Callable;

import be.renaudraas.playground.business.mapper.RepositoryMapper;
import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.business.network.ApiManager;
import be.renaudraas.playground.business.network.response.RepositoryResponse;
import be.renaudraas.playground.util.ListUtils;
import retrofit2.Call;
import retrofit2.Response;

public class GetRepositoriesTask implements Callable<List<Repository>> {

    private String user;

    public GetRepositoriesTask(String user) {
        this.user = user;
    }

    @Override
    public List<Repository> call() throws Exception {
        Call<List<RepositoryResponse>> call = ApiManager.getInstance().getGithubApi().getRepositories(user);
        Response<List<RepositoryResponse>> response = call.execute();

        return ListUtils.convert(response.body(), new RepositoryMapper());
    }
}
