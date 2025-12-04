package ua.pp.sanderzet.sanderdict.view.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ua.pp.sanderzet.sanderdict.R;
import ua.pp.sanderzet.sanderdict.data.model.DictionariesModel;
import ua.pp.sanderzet.sanderdict.view.adapter.DictionariesListAdapter;
import ua.pp.sanderzet.sanderdict.viewmodel.FragmentDictionariesViewModel;

public class FragmentDictionaries extends Fragment {
    private View rootview;
    private FragmentActivity myActivity;
    private RecyclerView recyclerView;
    private DictionariesListAdapter dictionariesListAdapter;
    private FragmentDictionariesViewModel fragmentDictionariesViewModel;
    private MutableLiveData<List<DictionariesModel>> listMutableLiveData;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.frag_dicts, container, false);
        return rootview;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myActivity = getActivity();
        recyclerView = rootview.findViewById(R.id.rv_dicts);


        fragmentDictionariesViewModel = ViewModelProviders.of(myActivity).get(FragmentDictionariesViewModel.class);
        fragmentDictionariesViewModel.receiveDictsList();

        fragmentDictionariesViewModel. getDictionariesModelMutableLiveData().
                observe(getViewLifecycleOwner(),new Observer<List<DictionariesModel>>() {
                    @Override
                    public void onChanged (@Nullable List < DictionariesModel > dictionariesModels) {
                        if (recyclerView.getAdapter() == null ) {
                            dictionariesListAdapter = new DictionariesListAdapter(dictionariesModels, myActivity);
                            recyclerView.setAdapter(dictionariesListAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(myActivity));

                                                    }
                                                    else dictionariesListAdapter.updateList(dictionariesModels);
                    }
                });

    }

    public void setOnClickItem(DictionariesModel dictionariesModel, View view) {
        fragmentDictionariesViewModel.onClickItem(dictionariesModel.getFileName(), view.getId());
    }

}
