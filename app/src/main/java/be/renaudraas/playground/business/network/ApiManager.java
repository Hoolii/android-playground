package be.renaudraas.playground.business.network;

import com.google.gson.Gson;

import be.renaudraas.playground.R;
import be.renaudraas.playground.application.PlaygroundApplication;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static ApiManager ourInstance = new ApiManager();

    public static ApiManager getInstance() {
        return ourInstance;
    }

    private GithubApi githubApi;

    private ApiManager() {
        Gson gson = new Gson();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(PlaygroundApplication.getContext().getString(R.string.config_github_api_base_url))
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }

    public GithubApi getGithubApi() {
        return githubApi;
    }
}