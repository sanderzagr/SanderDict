package ua.pp.sanderzet.sanderdict.data.repository;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import ua.pp.sanderzet.sanderdict.data.model.DictionaryModel;

/**
 * Created by sander on 18.02.18.
 */

public class DictionaryRepository {
    private final String LOG_TAG = "SanderZet"+getClass().getName();
    private static Application mApplication;
    private static DictionaryRepository mDictionaryRepository = null;
    private DictionaryDAO dictionaryDAO;
    private String databaseName;

    //    Make DictionaryRepository as Singleton

    public DictionaryRepository(Application application, String databaseName) {
        this.mApplication = application;
        this.databaseName = databaseName;
        dictionaryDAO = DictionaryDatabase.getDatabase(application, databaseName).dictionaryDAO();


    }

    public static DictionaryRepository getInstance (Application application, String databaseName) {
    if (mDictionaryRepository == null || (application != mApplication ))
        mDictionaryRepository = new DictionaryRepository(application, databaseName);
    return mDictionaryRepository;
    }

    public  LiveData<List<DictionaryModel>> getSuggestedWords(String query) {
        String pattern = (query.isEmpty())? query : query+"%";
        return dictionaryDAO.getSuggestedDictionaryItems(pattern);
    }

    public LiveData<DictionaryModel> getSearchedWord (String word) {
        return dictionaryDAO.getDictionaryItem(word);
    }


}

