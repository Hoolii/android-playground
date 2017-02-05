package be.renaudraas.playground.business.network;

import com.google.gson.Gson;

import be.renaudraas.playground.R;
import be.renaudraas.playground.application.PlaygroundApplication;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxApiManager {
    private static RxApiManager ourInstance = new RxApiManager();

    public static RxApiManager getInstance() {
        return ourInstance;
    }

    private RxGithubApi githubApi;

    private RxApiManager() {
        Gson gson = new Gson();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(PlaygroundApplication.getContext().getString(R.string.config_github_api_base_url))
                .build();

        githubApi = retrofit.create(RxGithubApi.class);
    }

    public RxGithubApi getGithubApi() {
        return githubApi;
    }
}