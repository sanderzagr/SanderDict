package ua.pp.sanderzet.sanderdict.view.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ua.pp.sanderzet.sanderdict.R;
import ua.pp.sanderzet.sanderdict.data.model.FavoriteModel;
import ua.pp.sanderzet.sanderdict.view.adapter.FavoriteListAdapter;
import ua.pp.sanderzet.sanderdict.viewmodel.FavoriteListViewModel;
import ua.pp.sanderzet.sanderdict.viewmodel.MainActivityViewModel;

/**
 * Created by sander on 31.10.17.
 */

public class FragmentFavoriteList extends Fragment {
    private FavoriteListViewModel favoriteListViewModel;
    private MainActivityViewModel mainActivityViewModel;
private List<FavoriteModel>  favoriteModels;
    private View rootView;
    private RecyclerView recyclerView;
    private FavoriteListAdapter favoriteListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.favorite_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = rootView.findViewById(R.id.rv_favoriteList);

        favoriteListViewModel = ViewModelProviders.of(getActivity()).get(FavoriteListViewModel.class);
        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        favoriteListViewModel.getAllWords().observe(getActivity(), new Observer<List<FavoriteModel>>() {
            @Override
            public void onChanged(@Nullable List<FavoriteModel> favoriteModels) {
                if (recyclerView.getAdapter() == null) {
                    favoriteListAdapter = new FavoriteListAdapter(favoriteModels, mainActivityViewModel);
                    recyclerView.setAdapter(favoriteListAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
                else favoriteListAdapter.updateList(favoriteModels);
            }
        });

    }
}
