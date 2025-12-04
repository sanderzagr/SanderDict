package ua.pp.sanderzet.sanderdict.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by sander on 13.02.18.
 */
@Entity(tableName = "dict")
public class DictionaryModel {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    @ColumnInfo
    private String word;
    @ColumnInfo
    private String definition;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
