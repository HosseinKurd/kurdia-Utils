package com.hosseinkurd.kurdiautils.toolbox.utiles;

import android.os.Handler;
import android.text.Html;

/**
 * Created by Kurdia on 4/15/17.
 */

public class TextTyper extends Thread {

    private String Text;
    private int Counter = 0;
    private CTV tv;


    public void setTextView(CTV view) {
        tv = view;
    }


    public void setText(String value) {
        Text = value;
    }

    private Handler handler = new Handler();
    @Override
    public void run() {
        super.run();
        while (Counter < Text.length()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Counter++;
            if (tv != null) {
                handler.post(new Runnable() {

                    public void run() {
                        tv.setText(Html.fromHtml(Text.substring(0, Counter)));
                    }
                });
            }
        }
    }
}
