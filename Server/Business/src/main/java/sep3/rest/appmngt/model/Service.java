package sep3.rest.appmngt.model;

import org.bson.types.ObjectId;

/**
 * The type Service.
 */
public class Service {
    private String id;
    private String pictureUrl;
    private String title;
    private String description;
    private int duration;
    private String businessId;

    /**
     * Instantiates a new Service.
     *
     * @param id          the id
     * @param pictureUrl  the picture url
     * @param title       the title
     * @param description the description
     * @param duration    the duration
     * @param businessId  the business id
     */
    public Service(String id, String pictureUrl, String title, String description, int duration, String businessId) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.businessId = businessId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets picture url.
     *
     * @return the picture url
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets picture url.
     *
     * @param pictureUrl the picture url
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets business id.
     *
     * @return the business id
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * Sets business id.
     *
     * @param businessId the business id
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
