package be.renaudraas.playground.business.network;


import java.util.List;

import be.renaudraas.playground.business.network.response.RepositoryResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubApi {

    @GET("users/{user}/repos")
    Observable<List<RepositoryResponse>> getRepositories(@Path("user") String user);
}
