package com.mtingwi.chisoni.zakumunda;

import org.json.JSONObject;

public interface JSONAsyncTaskDelegate {
    void onTaskCompleted(JSONObject response);
}
