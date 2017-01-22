package be.renaudraas.playground.business.network.response;


import be.renaudraas.playground.business.model.Repository;

public class RepositoryResponse {

    private long id;
    private String name;
    private String description;
    private boolean isPrivate;
    private UserResponse user;

    public Repository toRepository() {
        Repository repository = new Repository();

        repository.setId(id);
        repository.setName(name);
        repository.setPrivate(isPrivate);

        if (user != null) {
            repository.setUser(user.toUser());
        }

        return repository;
    }
}