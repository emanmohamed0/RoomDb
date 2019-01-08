package demomap.al7osam.com.roomdb.db;

import android.arch.lifecycle.LiveData;
import java.util.List;
import demomap.al7osam.com.roomdb.model.Item;

public interface Repository {

    void addItem(Item item);
    void deleteItem(Item item);
    LiveData<List<Item>> getItems();

}