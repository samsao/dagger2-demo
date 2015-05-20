//package samsao.daggerdemo;
//
//import dagger.Module;
//import dagger.Provides;
//import samsao.daggerdemo.rest.AuthenticatedRestClient;
//import samsao.daggerdemo.rest.RestClient;
//import samsao.daggerdemo.rest.User;
//
///**
// * @author Lukasz Piliszczuk <lukasz.pili@gmail.com>
// */
//@Module
//public class UserModule {
//
//    private User user;
//
//    public UserModule(User user) {
//        this.user = user;
//    }
//
//    @Provides
//    @DaggerScope
//    public AuthenticatedRestClient providesRestClient(RestClient restClient, User user) {
//        return new AuthenticatedRestClient(user, restClient);
//    }
//}
