package kerstein.physics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answer= (TextView)findViewById(R.id.answer);
        Intent intent=getIntent();
        double angle=intent.getDoubleExtra("ANGLE", 0.0);
        double velocity=intent.getDoubleExtra("VELOCITY", 0.0);
        double time=intent.getDoubleExtra("TIME", 0.0);
        Projectile p = new Projectile( Double.parseDouble(String.valueOf(angle)), Double.parseDouble(String.valueOf(velocity)), Double.parseDouble(String.valueOf(time)));
        double answerX = p.getAnswerX();
        double answerY = p.getAnswerY();
        answer.setText("x= " +answerX+ "\n"+"y= "+answerY);

    }
}
