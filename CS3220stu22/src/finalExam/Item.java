package finalExam;

public class Item {

  private int id;
  private String title;
  private String link;
  private int points;

  public Item(int id, String title, String link, int points) {
    super();
    this.id = id;
    this.title = title;
    this.points = points;
    this.link = link;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
