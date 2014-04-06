/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.project.capstone;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaActivity;

public class Capstone extends CordovaActivity 
{
    WebView webview;
    Touch_activity coordinate = new Touch_activity();
    String my_TAG = "asdf";


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.init();
        // Set by <content src="index.html" /> in config.xml
        super.loadUrl(Config.getStartUrl());
        //super.loadUrl("file:///android_asset/www/index.html");
        Log.v(my_TAG, coordinate.get_X());
        sendUrl(coordinate.get_X(), coordinate.get_Y());

    }

    public void sendUrl(String x, String y){
        setContentView(R.layout.main);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://1.209.21.74:8080/FBVOL_SERVER/Character/Move/%7B%22ID%22:%22izie%22,%22X%22:"+x+",%22Y%22:"+y+"%7D");
        //webview.loadUrl("http://1.209.21.74:8080/FBVOL_SERVER/Character/Move/%7B%22ID%22:%22izie%22,%22X%22:350,%22Y%22:250%7D");

        webview.setVisibility(webview.GONE);
        finish();
    }
}

