package com.fdanielpm.petagram.restApi;

public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4937288719.07c289e.7204ba70eeb4463ba08df7faf748c50b";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //                                                      users/self/media/recent/ + ?access_token= + 4937288719.07c289e.7204ba70eeb4463ba08df7faf748c50b
    //                         https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    //https://api.instagram.com/v1/users/search?q=android.devel&access_token=4937288719.07c289e.7204ba70eeb4463ba08df7faf748c50b
    public static final String KEY_FIND_USER = "users/search";

    public static final String URL_FIND_USER = KEY_FIND_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



}
