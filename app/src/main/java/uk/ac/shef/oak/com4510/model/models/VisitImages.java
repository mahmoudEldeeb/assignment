package uk.ac.shef.oak.com4510.model.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//The beginning of Areej part

/**
 * this is entity class uses to create a table in room database
 * for images of visits
 *  * @author Areej
 */
@Entity(tableName = "visit_images")

public class VisitImages {

    @ColumnInfo(name = "visitId")
    public  Long visitId;



    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;


    public VisitImages(Long visitId, byte[] image) {
        this.visitId = visitId;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public Long getVisitId() {
        return visitId;
    }
}

//The end of Areej part