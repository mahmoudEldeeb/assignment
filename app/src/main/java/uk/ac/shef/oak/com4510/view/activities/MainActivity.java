package uk.ac.shef.oak.com4510.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import uk.ac.shef.oak.com4510.R;
import uk.ac.shef.oak.com4510.databinding.ActivityMainBinding;
import uk.ac.shef.oak.com4510.utils.Constants;


//The beginning of Areej part

/**
 * this my first page  it contain two button start for start of capture images of visit
 * and another one to show all vists data
 * @author Areej
 *
 */

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if title is empty or not
                if (!binding.insertTitleEditText.getText().toString().isEmpty()) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            Main2Activity.class);
                    intent.putExtra("title", binding.insertTitleEditText.getText().toString());
                    intent.putExtra("description", binding.description.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.entre_title),Toast.LENGTH_LONG).show();
                }
            }
        });


        Constants.context=this;
        binding.showPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,selectActivity.class));
            }
        });
        binding.showVisits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ShowVisitDataActivity.class));
            }
        });



    }
}
//The end of Areej part