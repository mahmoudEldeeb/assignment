package uk.ac.shef.oak.com4510.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import uk.ac.shef.oak.com4510.utils.Constants;
import uk.ac.shef.oak.com4510.view.Adapters.ImageAdapter;
import uk.ac.shef.oak.com4510.R;
import uk.ac.shef.oak.com4510.view_model.ViewModelA;
import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.models.VisitImages;

public class SpecificPathActivity extends AppCompatActivity implements ImageAdapter.ImageViewClickListener{
    private ViewModelA viewModelA;
    private TextView title;
    private ImageAdapter imageAdapter;
    private int visitID=0;
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_layout);
        Constants.context=this;
        title=findViewById(R.id.title);
        imageAdapter =new ImageAdapter(this,new ArrayList<VisitImages>());
        imageAdapter.setListener(this);
        gridView=(GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(imageAdapter);
        Intent intent=getIntent();
        visitID=intent.getExtras().getInt("visitID",0);
        viewModelA= ViewModelProviders.of(this).get(ViewModelA.class);
        viewModelA.getVisitByID(visitID).observe(this, new Observer<Visit>() {
            @Override
            public void onChanged(Visit visit) {
                title.setText(visit.getTitle());

            }
        });
        viewModelA.getImagesByVisitID(visitID).observe(this, new Observer<List<VisitImages>>() {
            @Override
            public void onChanged(List<VisitImages> images) {
                imageAdapter.refreshImageData(images);
            }
        });

    }

    @Override
    public void onImageViewClick(int position, VisitImages image) {
        long visitID=image.getVisitId();
        long imageKey=image.getId();
        Intent intent=new Intent(this, ImageDescriptionActivity.class);
        intent.putExtra("visitID",visitID);
        intent.putExtra("imageKey",imageKey);
        startActivity(intent);
    }
}
