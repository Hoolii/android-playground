package be.renaudraas.playground.business.network;

import java.util.List;

import be.renaudraas.playground.business.network.response.RepositoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("users/{user}/repos")
    Call<List<RepositoryResponse>> getRepositories(@Path("user") String user);
}
