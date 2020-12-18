package sep3.db.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

/**
 * The type Service.
 */
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

    /**
     * Instantiates a new Service.
     *
     * @param _id         the id
     * @param id          the id
     * @param pictureUrl  the picture url
     * @param title       the title
     * @param description the description
     * @param duration    the duration
     */
    public Service(ObjectId _id, String id, String pictureUrl, String title, String description, int duration) {

    }


    /**
     * Gets business id.
     *
     * @return the business id
     */
    public ObjectId get_businessId() {
        return _businessId;
    }

    /**
     * Sets business id.
     *
     * @param _businessId the business id
     */
    public void set_businessId(ObjectId _businessId) {
        this._businessId = _businessId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Sets id.
     *
     * @param _id the id
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
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
