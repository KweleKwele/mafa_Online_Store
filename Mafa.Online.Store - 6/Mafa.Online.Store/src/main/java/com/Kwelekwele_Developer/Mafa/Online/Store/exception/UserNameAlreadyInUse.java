package com.Kwelekwele_Developer.Mafa.Online.Store.exception;

public class UserNameAlreadyInUse extends RuntimeException{

    public UserNameAlreadyInUse() {
        super();
    }

    public UserNameAlreadyInUse(String message){
        super(message);
    }
}
