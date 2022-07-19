package pojo;

public class PojoHerOkuBody {
    private String title;
    private String body;
    private float userId;
    private float id;


    // Getter Methods

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public float getUserId() {
        return userId;
    }

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public void setId(float id) {
        this.id = id;
    }

    public PojoHerOkuBody(String title, String body, float userId, float id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
}
