package com.Kwelekwele_Developer.Mafa.Online.Store.exception;

public class EmailAlReadyInUse extends RuntimeException{

    public EmailAlReadyInUse() {
        super();
    }

    public EmailAlReadyInUse(String message){
        super(message);
    }
}
