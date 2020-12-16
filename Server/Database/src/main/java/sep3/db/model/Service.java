package sep3.db.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

public class Service {
    private ObjectId _id;
    @Expose(serialize = true, deserialize = true)
    private String id;
    @Expose(serialize = true, deserialize = true)
    private String pictureUrl;
    @Expose(serialize = true, deserialize = true)
    private String title;
    @Expose(serialize = true, deserialize = true)
    private String description;
    @Expose(serialize = true, deserialize = true)
    private int duration;
    @Expose(serialize = true, deserialize = false)
    private ObjectId _businessId;
    @Expose(serialize = true, deserialize = true)
    private String businessId;

    public Service(ObjectId _id, String id, String pictureUrl, String title, String description, int duration) {

    }


    public ObjectId get_businessId() {
        return _businessId;
    }

    public void set_businessId(ObjectId _businessId) {
        this._businessId = _businessId;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
