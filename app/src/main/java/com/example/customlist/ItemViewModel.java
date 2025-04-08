package com.example.customlist;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {
    private MutableLiveData<List<Item>> itemList;

    public LiveData<List<Item>> getItems() {
        if (itemList == null) {
            itemList = new MutableLiveData<>();
            loadItems();
        }
        return itemList;
    }

    private void loadItems() {
        // Simulate loading data from a data source
        List<Item> items = new ArrayList<>();

        // Add stunning sample items
        items.add(new Item(R.drawable.nature, "Mountain Sunrise", "Breathtaking view at dawn"));
        items.add(new Item(R.drawable.nature2, "Ocean Waves", "Crystal clear blue waters"));
        items.add(new Item(R.drawable.nature3, "Forest Path", "Mystical morning fog"));
        items.add(new Item(R.drawable.nature4, "Desert Dunes", "Golden sands stretching far"));
        items.add(new Item(R.drawable.nature5, "Northern Lights", "Dancing colors in the sky"));
        itemList.setValue(items);
    }
}