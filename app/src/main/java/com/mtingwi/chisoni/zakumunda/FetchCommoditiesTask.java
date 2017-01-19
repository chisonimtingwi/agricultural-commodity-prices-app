package com.mtingwi.chisoni.zakumunda;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import org.json.JSONObject;

/**
 * Created by E.Kachale on 12/9/2016.
 */

public class FetchCommoditiesTask extends AsyncTask<String, String, JSONObject> {

    private Fragment fragment;
    private JSONAsyncTaskDelegate asyncTaskDelegate;
    private Context context;


    public FetchCommoditiesTask(Fragment fragment, JSONAsyncTaskDelegate asyncTaskDelegate) {
        this.fragment = fragment;
        this.asyncTaskDelegate = asyncTaskDelegate;
        this.context = null;
    }


    public FetchCommoditiesTask(Context context, JSONAsyncTaskDelegate asyncTaskDelegate) {
        this.asyncTaskDelegate = asyncTaskDelegate;
        this.context = context;
        this.fragment = null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return null;
    }


    @Override
    protected void onPostExecute(JSONObject response) {
        if (fragment != null) {
            if (fragment.isAdded() && response != null) {
                super.onPostExecute(response);
                asyncTaskDelegate.onTaskCompleted(response);
            } else {
                this.cancel(true);
            }
        } else {
            super.onPostExecute(response);
            asyncTaskDelegate.onTaskCompleted(response);
        }
    }
}
