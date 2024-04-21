package com.example.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Planet implements Parcelable {
    private int imageId, image1, image2, image3;
    private final String name;
    private final String content;

    public Planet(int imageId, int image1, int image2, int image3, String name, String content) {
        this.imageId = imageId;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.name = name;
        this.content = content;
    }

    protected Planet(Parcel in) {
        imageId = in.readInt();
        image1 = in.readInt();
        image2 = in.readInt();
        image3 = in.readInt();
        name = in.readString();
        content = in.readString();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeInt(image1);
        dest.writeInt(image2);
        dest.writeInt(image3);
        dest.writeString(name);
        dest.writeString(content);
    }
}
