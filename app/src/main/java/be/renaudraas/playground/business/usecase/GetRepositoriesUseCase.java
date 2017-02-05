package be.renaudraas.playground.business.usecase;


import java.util.List;

import be.renaudraas.playground.business.mapper.RepositoryMapper;
import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.business.network.RxApiManager;
import be.renaudraas.playground.util.ListUtils;
import rx.Observable;

public class GetRepositoriesUseCase implements UseCase<List<Repository>> {

    private String user;

    public GetRepositoriesUseCase(String user) {
        this.user = user;
    }

    @Override
    public Observable<List<Repository>> execute() {
        return RxApiManager.getInstance().getGithubApi().getRepositories(user)
                .map(repositoryResponses -> ListUtils.convert(repositoryResponses, new RepositoryMapper()));
    }
}