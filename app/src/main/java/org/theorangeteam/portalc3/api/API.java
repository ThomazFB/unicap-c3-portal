package org.theorangeteam.portalc3.api;

import android.os.AsyncTask;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.api.message.CreateLoadingDialogEvent;
import org.theorangeteam.portalc3.api.message.DismissLoadingDialogEvent;
import org.theorangeteam.portalc3.api.message.ErrorMessage;
import org.theorangeteam.portalc3.api.message.GETMessage;
import org.theorangeteam.portalc3.api.message.Message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

public class API
{
    public void request(Message message)
    {
        //TODO: handle EventBus.getDefault().post(new CreateLoadingDialogEvent());
        new NetworkAsyncTask().execute(message);
    }

    private void handleRequest(Message message)  throws Exception
    {
        if(message instanceof GETMessage)
        {
            handleGET((GETMessage) message);
        }
    }

    private void handleGET(GETMessage message) throws Exception
    {
        String json = fetchJSONTo(message);
        message.setJsonResponse(json);
    }

    private String fetchJSONTo(GETMessage message) throws Exception
    {
        HttpURLConnection apiConnection = createConnection(message.getUrl(), "GET");
        return buildStringFrom(apiConnection.getInputStream());
    }

    private HttpURLConnection createConnection(String urlText,
            String requestMethod) throws Exception
    {
        URL url = new URL(urlText);
        HttpURLConnection apiConnection = (HttpURLConnection) url.openConnection();
        apiConnection.setRequestMethod(requestMethod);
        apiConnection.setConnectTimeout(10000);
        apiConnection.setReadTimeout(10000);
        return apiConnection;
    }

    private String buildStringFrom(InputStream apiInputStream)
    {
        try
        {
            String stringLine;
            InputStreamReader apiInputStreamReader = new InputStreamReader(apiInputStream);
            BufferedReader bufferedReader = new BufferedReader(apiInputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while ((stringLine = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(stringLine);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Error while building the JSON String");
        }
    }

    private class NetworkAsyncTask extends AsyncTask<Message, Void, Message>
    {
        @Override
        protected Message doInBackground(Message... messages)
        {
            Message requestedMessage = messages[0];
            try
            {
                handleRequest(requestedMessage);
            }
            catch (Exception ex)
            {
                requestedMessage.setErrorID(R.string.network_error_text);
                cancel(true);
            }
            return requestedMessage;
        }

        @Override
        protected void onPostExecute(Message message)
        {
            EventBus.getDefault().post(new DismissLoadingDialogEvent());
            EventBus.getDefault().post(message);
        }

        @Override
        protected void onCancelled(Message message)
        {
            EventBus.getDefault().post(new DismissLoadingDialogEvent());
            EventBus.getDefault().post(new ErrorMessage(message.getErrorID()));
        }
    }
}