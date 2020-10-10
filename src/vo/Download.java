package vo;

public class Download {
    private int id;
    private String name;
    private String description;
    private String path;
    private Float size;
    private Integer start;
    private String img;

    public Download() {
    }

    public Download(int id, String name, String description, String path, Float size, Integer start, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.size = size;
        this.start = start;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Download{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", img='" + img + '\'' +
                '}';
    }
}
