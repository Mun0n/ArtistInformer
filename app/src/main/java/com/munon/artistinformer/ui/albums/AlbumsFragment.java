package com.munon.artistinformer.ui.albums;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Album;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.ui.albums.adapter.AlbumAdapter;
import com.munon.artistinformer.ui.albums.adapter.MarginDecoration;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class AlbumsFragment extends Fragment {

    public static final String ALBUM_DATA = "albums";

    private Album[] albums;

    @InjectView(R.id.listAlbums)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ALBUM_DATA)) {
            Artist artist = (Artist) getArguments().getSerializable(ALBUM_DATA);
            albums = artist.getAlbums();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new MarginDecoration(getResources().getInteger(R.integer.card_view_margin)));
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.card_view_columns));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new AlbumAdapter(getActivity(), albums));

    }
}
