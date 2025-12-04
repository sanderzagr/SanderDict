package ua.pp.sanderzet.sanderdict.data.repository;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

import ua.pp.sanderzet.sanderdict.data.model.FavoriteModel;
import ua.pp.sanderzet.sanderdict.data.util.DateConverter;

/**
 * Created by sander on 27/08/17.
 */

@Database(entities = {FavoriteModel.class}, version = 1 )
@TypeConverters({DateConverter.class})
public abstract class FavoriteDatabase extends RoomDatabase {
    public abstract FavoriteDAO favoriteDAO();
    private static FavoriteDatabase INSTANCE ;
    public static FavoriteDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),FavoriteDatabase.class,
                    "favorite.db").setJournalMode(JournalMode.TRUNCATE).build();
        }
      return INSTANCE;
    }
}
