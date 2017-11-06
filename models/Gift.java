package models;

import java.util.Date;

public class Gift {

    private String name;
    private String description;
    private Date date;

    public Gift() {
    }

    public Gift(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean equals(Gift other) {
        if (!this.name.equals(other.name))
            return false;
        if (!this.description.equals(other.description))
            return false;
        if (!this.date.equals(other.date))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
