package kerstein.physics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    private EditText fieldA;
    private EditText fieldV;
    private EditText fieldT;
    private Button button;
    private ImageView imageView;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates preferences for us to save and retrieve data
        preferences=this.getSharedPreferences("DEFAULT", MODE_PRIVATE);


        imageView = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load("http://www.physicsclassroom.com/Class/vectors/u3l2c1.gif").into(imageView);

        fieldA= (EditText) findViewById(R.id.angleEdit);
        fieldV= (EditText) findViewById(R.id.velocityEdit);
        fieldT= (EditText) findViewById(R.id.timeEdit);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAnswer();
            }
        });
    }

    private void ShowAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("ANGLE",Double.parseDouble(fieldA.getText().toString()));
        intent.putExtra("VELOCITY", Double.parseDouble(fieldV.getText().toString()));
        intent.putExtra("TIME", Double.parseDouble(fieldT.getText().toString()));

        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

    //edits preferences
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("Angle", fieldA.getText().toString());
        editor.putString("Velocity", fieldV.getText().toString());
        editor.putString("Time", fieldT.getText().toString());

        editor.apply();
    }

    @Override
    public void onResume(){
        super.onResume();
        fieldA.setText(preferences.getString("Angle", ""));
        fieldV.setText(preferences.getString("Velocity",""));
        fieldT.setText(preferences.getString("Time", ""));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
