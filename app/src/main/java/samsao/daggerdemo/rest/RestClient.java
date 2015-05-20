package samsao.daggerdemo.rest;

/**
 * @author Lukasz Piliszczuk <lukasz.pili@gmail.com>
 */
public class RestClient {

    private OkHttp okHttp;

    public RestClient(OkHttp okHttp) {
        this.okHttp = okHttp;
    }
}
