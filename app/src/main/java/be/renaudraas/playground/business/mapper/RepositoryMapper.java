package be.renaudraas.playground.business.mapper;

import be.renaudraas.playground.business.model.Repository;
import be.renaudraas.playground.business.network.response.RepositoryResponse;

public class RepositoryMapper implements Mapper<RepositoryResponse, Repository> {

    @Override
    public Repository map(RepositoryResponse repositoryResponse) {
        return repositoryResponse.toRepository();
    }
}