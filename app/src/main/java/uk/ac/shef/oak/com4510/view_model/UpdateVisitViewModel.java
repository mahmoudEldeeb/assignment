package uk.ac.shef.oak.com4510.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import uk.ac.shef.oak.com4510.model.models.Visit;
import uk.ac.shef.oak.com4510.model.repositry.RetrieveDataRepository;
import uk.ac.shef.oak.com4510.model.repositry.UpdateAndDeleteRepositry;

public class UpdateVisitViewModel extends ViewModel {



public void update(Visit visit){
    new UpdateAndDeleteRepositry().update(visit);
}
}
