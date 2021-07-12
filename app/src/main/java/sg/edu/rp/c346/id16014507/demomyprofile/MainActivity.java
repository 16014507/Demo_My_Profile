package sg.edu.rp.c346.id16014507.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String gpa = etGpa.getText().toString();
        float fgpa = 0f;
        if(gpa.length() > 0){
            fgpa = Float.parseFloat(gpa);
        }
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString("name", etName.getText().toString());
        prefsEditor.putFloat("gpa", fgpa);
        prefsEditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa", 0f);

        etName.setText(name);
        etGpa.setText(gpa + "");
    }
}