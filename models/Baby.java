package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Baby {

    private String name;
    private Date birthday;
    private char gender;
    private Gift gift;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmm");

    public static ArrayList<Baby> gifts = new ArrayList<>();

    public Baby() {
    }

    public Baby(String name, Date birthday, char gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Baby(String name, String birthday, char gender) {
        this.name = name;
        this.gender = gender;
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (Exception e) {
            System.out.println("The date is not valid. It must be yyyyMMdd HHmm");
        }
    }

    public boolean isOlder(Baby baby) {
        if (this.getBirthday().compareTo(baby.getBirthday()) > 0) {
            return true;
        }
        return false;
    }

    public int howOld() {
        long diff = new Date().getTime() - this.getBirthday().getTime();
        return (int) (diff / (1000 * 60 * 60 * 24) + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public boolean equals(Baby other) {
        if (!this.name.equals(other.name))
            return false;
        if (!this.birthday.equals(other.birthday))
            return false;
        if (this.gender != other.gender)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
