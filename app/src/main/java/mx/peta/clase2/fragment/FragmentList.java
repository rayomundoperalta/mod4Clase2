package mx.peta.clase2.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.peta.clase2.R;
import mx.peta.clase2.adapters.AdapterItemList;
import mx.peta.clase2.model.ModelItem;

/**
 * Created by rayo on 6/13/16.
 */
public class FragmentList extends Fragment {
    private ListView listView;
    private List<ModelItem> array = new ArrayList<>();
    private int counter;
    private boolean isWifi;

    @Nullable
    public View obCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listItems);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdapterItemList adapter = (AdapterItemList) parent.getAdapter();
                ModelItem modelItem = adapter.getItem(position);
                ModelItem modelItem2 = array.get(position);
                Toast.makeText(getActivity(), modelItem2.item, Toast.LENGTH_SHORT).show();
            }
        });

        final EditText mItemsText = (EditText) view.findViewById(R.id.mItemText);
        view.findViewById(R.id.btnAddItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemData = mItemsText.getText().toString();
                if (!TextUtils.isEmpty(itemData)) {
                    ModelItem item = new ModelItem();
                    item.item = itemData;
                    item.id = "Description " + counter;
                    item.resourceId = isWifi ? R.drawable.wifi : R.drawable.voice;
                    array.add(item);
                    listView.setAdapter(new AdapterItemList(getActivity(), array));
                    isWifi = !isWifi;
                    counter ++;
                    mItemsText.setText("");
                }
            }
        });
        return view;
    }
}
