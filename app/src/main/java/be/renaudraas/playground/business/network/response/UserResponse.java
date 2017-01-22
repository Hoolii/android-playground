package be.renaudraas.playground.business.network.response;


import be.renaudraas.playground.business.model.User;

public class UserResponse {

    long id;
    String login;

    public User toUser() {
        User user = new User();

        user.setId(id);
        user.setLogin(login);

        return user;
    }

}
