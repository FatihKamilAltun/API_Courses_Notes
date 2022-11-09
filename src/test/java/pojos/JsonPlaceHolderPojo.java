package pojos;

public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private String completed;

    public JsonPlaceHolderPojo(Integer userId, String title, String completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
