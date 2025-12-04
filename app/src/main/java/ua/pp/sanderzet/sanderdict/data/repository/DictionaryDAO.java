
package ua.pp.sanderzet.sanderdict.data.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ua.pp.sanderzet.sanderdict.data.model.DictionaryModel;

import static androidx.room.OnConflictStrategy.IGNORE;

/**
 * Created by sander on 13.02.18.
 */

@Dao
public interface DictionaryDAO {

    @Query("select * from dict ")
    LiveData<List<DictionaryModel>> getAllDictionaryItems();

    @Query("select * from dict where word like :suggestedWords")
    LiveData<List<DictionaryModel>> getSuggestedDictionaryItems(String suggestedWords);

    @Query("select * from dict where word like :searchedWord ")
    LiveData<DictionaryModel> getDictionaryItem(String searchedWord);


    @Insert(onConflict = IGNORE)
    void addDictionary(DictionaryModel dictionaryModel);



}
