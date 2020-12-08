package sep3.rest.appmngt.model;

import org.bson.types.ObjectId;

public class Service {
    private ObjectId _id;
    private String id;
    private String name;
    private int duration;

    public Service(ObjectId _id, String id, String name, int duration) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
