package com.crowdtogo.crowdie.network;


import com.crowdtogo.crowdie.model.AccessTokenResponse;
import com.crowdtogo.crowdie.model.UsersResponse;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

public class UsersInterfaceSpiceService extends RetrofitGsonSpiceService {


    private final static String BASE_URL = "http://devapp.crowdtogo.com";

    @Override
    public void onCreate() {
        super.onCreate();
       // addRetrofitInterface(UsersResponse.class);
        addRetrofitInterface(UsersInterface.class);
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        return new RestAdapter.Builder()
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                          //access token add to header here
                         // request.addHeader("Authorization", "PiO57dpd0aRTNE3kxCoHvaSwarnT6QKbJroI4tSU");
                    }
                })
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create()))
                .setClient(new OkClient())
                .setLogLevel(RestAdapter.LogLevel.FULL);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }



}
