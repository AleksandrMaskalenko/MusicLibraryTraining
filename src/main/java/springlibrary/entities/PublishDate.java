package springlibrary.entities;

/**
 * Created by aleksandrsmaskalenko on 04/03/2017.
 */
public class PublishDate {
    private int id;
    private int date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublishDate that = (PublishDate) o;

        if (id != that.id) return false;
        if (date != that.date) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date;
        return result;
    }

    @Override
    public String toString() {
        return date + "";
    }
}
