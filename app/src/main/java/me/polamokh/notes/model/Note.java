package me.polamokh.notes.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Entity(tableName = "notes")
public class Note {

    private String title;

    private String description;

    @ColumnInfo(name = "modified_time")
    private String modifiedTime;

    @PrimaryKey(autoGenerate = true)
    private int id;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
        this.modifiedTime = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT,
                Locale.getDefault())
                .format(new Date());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Note) {
            return this.title.equals(((Note) obj).title) &&
                    this.description.equals(((Note) obj).description) &&
                    this.modifiedTime.equals(((Note) obj).modifiedTime);
        }
        return false;
    }
}
