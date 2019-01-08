package demomap.al7osam.com.roomdb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import demomap.al7osam.com.roomdb.model.Item;


@Database(entities = {Item.class}, version = 1 ,exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase{

    public abstract ItemDao itemDao();

}