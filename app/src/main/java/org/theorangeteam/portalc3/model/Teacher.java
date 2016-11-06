package org.theorangeteam.portalc3.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class Teacher implements Parcelable
{
    @SerializedName("professorNome")
    private String name;

    @SerializedName("professorLattes")
    private String lattesUrl;

    @SerializedName("professorImagemUrl")
    private String imageUrl;

    @SerializedName("professorTitulacao")
    private String titles;

    @SerializedName("professorInteresses")
    private String interests;

    @SerializedName("professorEmail")
    private String email;

    @SerializedName("professorTelefone")
    private String phone;

    public Teacher()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getLattesUrl()
    {
        return lattesUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getTitles()
    {
        return titles;
    }

    public String getInterests()
    {
        return interests;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.lattesUrl);
        dest.writeString(this.imageUrl);
        dest.writeString(this.titles);
        dest.writeString(this.interests);
        dest.writeString(this.email);
        dest.writeString(this.phone);
    }

    protected Teacher(Parcel in)
    {
        this.name = in.readString();
        this.lattesUrl = in.readString();
        this.imageUrl = in.readString();
        this.titles = in.readString();
        this.interests = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>()
    {
        @Override
        public Teacher createFromParcel(Parcel source)
        {
            return new Teacher(source);
        }

        @Override
        public Teacher[] newArray(int size)
        {
            return new Teacher[size];
        }
    };
}
