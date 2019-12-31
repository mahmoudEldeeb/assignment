package uk.ac.shef.oak.com4510.view.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uk.ac.shef.oak.com4510.utils.Constants;
import uk.ac.shef.oak.com4510.view.Adapters.SinglePathAdapter;
import uk.ac.shef.oak.com4510.model.Objects.PathItem;
import uk.ac.shef.oak.com4510.R;
import uk.ac.shef.oak.com4510.view_model.ViewModelA;

public class PathActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SinglePathAdapter singlePathAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ViewModelA viewModelA;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Constants.context=this;
        setContentView(R.layout.path_layout);
        buildRecyclerView();
        viewModelA= ViewModelProviders.of(this).get(ViewModelA.class);
        viewModelA.getPathItemList().observe(this, new Observer<List<PathItem>>() {
            @Override
            public void onChanged(List<PathItem> pathItems) {
                singlePathAdapter.refreshData(pathItems);
            }
        });
    }

    public void buildRecyclerView(){
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        singlePathAdapter =new SinglePathAdapter(new ArrayList<PathItem>());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(singlePathAdapter);
        singlePathAdapter.setOnPathListener(new SinglePathAdapter.OnPathClickListener() {
            @Override
            public void onPathClick(int position) {
                Intent intent = new Intent(PathActivity.this, SpecificPathActivity.class);
                intent.putExtra("VisitID", singlePathAdapter.getClickedPath(position).getVisit().getId());
                startActivity(intent);
            }
        });
    }
}

