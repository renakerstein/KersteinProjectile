package physics.kerstein;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView angle;
    private EditText fieldA;
    private TextView velocity;
    private EditText fieldV;
    private TextView time;
    private EditText fieldT;
    private Button button;
    private TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angle= (TextView) findViewById(R.id.angle);
        velocity= (TextView) findViewById(R.id.velocity);
        time= (TextView) findViewById(R.id.time);
        answer= (TextView) findViewById(R.id.answer);
        fieldA= (EditText) findViewById(R.id.angleEdit);
        fieldV= (EditText) findViewById(R.id.velocityEdit);
        fieldT= (EditText) findViewById(R.id.timeEdit);
        button= (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Double aString = Double.parseDouble(fieldA.getText().toString());
                Double vString = Double.parseDouble(fieldV.getText().toString());
                Double tString = Double.parseDouble(fieldT.getText().toString());
                Double radians = Math.toRadians(aString);
                double answerX = getX(radians, vString, tString);
                double answerY = getY(radians, vString, tString);
                StringBuilder builder= new StringBuilder();
                builder.append(answerX);
                builder.append(",  " );
                builder.append(answerY);
                answer.setText(builder);
            }
        });

    }
        private double getX(Double radians, Double vString, Double tString){
        return Math.sin(radians) * vString * tString;}

        private double getY(Double radians, Double vString, Double tString){
        return (Math.cos(radians) * vString * tString - (.5 * 9.8 * (tString*tString)));}

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
