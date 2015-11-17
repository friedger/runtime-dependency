package de.friedger.android.runtime_dependency;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            StringBuffer stringBuffer = readFile();

                            Snackbar.make(view, "Content: " + stringBuffer.toString(), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );
    }

    @NonNull
    private StringBuffer readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/sdcard/omnijar.txt"));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = in.readLine()) != null) {
            stringBuffer.append(line);
        }
        return stringBuffer;
    }
}
