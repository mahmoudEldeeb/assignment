package uk.ac.shef.oak.com4510.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import uk.ac.shef.oak.com4510.utils.Constants;
import uk.ac.shef.oak.com4510.view.Adapters.ImageAdapter;
import uk.ac.shef.oak.com4510.R;
import uk.ac.shef.oak.com4510.view_model.ViewModelA;
import uk.ac.shef.oak.com4510.model.models.VisitImages;


public class AllImagesActivity extends AppCompatActivity implements ImageAdapter.ImageViewClickListener {
    GridView gridView;
    ViewModelA viewModelA;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_layout);
        imageAdapter=new ImageAdapter(this,new ArrayList<VisitImages>());
        imageAdapter.setListener(this);
        Constants.context=this;
        buildGridView();
        viewModelA= ViewModelProviders.of(this).get(ViewModelA.class);
        viewModelA.getAllVisitImagesSorted().observe(this, new Observer<List<VisitImages>>() {
            @Override
            public void onChanged(List<VisitImages> visitImages) {
                imageAdapter.refreshImageData(visitImages);
            }
        });

    }
    public void buildGridView(){
        TextView title=findViewById(R.id.title);
        title.setText("All Images");
        gridView=(GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(imageAdapter);

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
