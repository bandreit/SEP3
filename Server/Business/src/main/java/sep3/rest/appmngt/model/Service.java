package sep3.rest.appmngt.model;

import org.bson.types.ObjectId;

public class Service {
    private String id;
    private String pictureUrl;
    private String title;
    private String description;
    private int duration;
    private String businessId;

    public Service(String id, String pictureUrl, String title, String description, int duration, String businessId) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.businessId = businessId;
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
