package myapp.com.samplefragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new BlankFragment()).commit();
    }
}
