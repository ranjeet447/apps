package com.example.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static com.example.webview.R.id.webview;

public class MainActivity extends AppCompatActivity {

    EditText searchEditText;
    Button okButton;
    Button googleButton;
    Button youTubeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText=(EditText)findViewById(R.id.search_EditText);
        okButton = (Button) findViewById((R.id.button1));
        googleButton = (Button)findViewById(R.id.button2);
        youTubeButton = (Button)findViewById(R.id.button3);

        final Intent intent = new Intent(getApplicationContext(),webviewActivity.class);



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String url = searchEditText.getText().toString();
                url ="https://www.google.com/search?q=" + url;
                bundle.putString("URL",url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                String  url ="https://www.google.com";
                bundle.putString("URL",url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        youTubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                String url = "https://www.youtube.com";
                bundle.putString("URL",url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


}
