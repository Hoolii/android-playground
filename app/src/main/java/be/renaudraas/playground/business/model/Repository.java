package be.renaudraas.playground.business.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Repository implements Parcelable {

    long id;
    String name;
    String description;
    boolean isPrivate;
    User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        RepositoryParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        public Repository createFromParcel(Parcel source) {
            Repository target = new Repository();
            RepositoryParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
