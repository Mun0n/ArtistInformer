package com.munon.artistinformer.ui.main;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hrules.busline.BusLine;
import com.hrules.busline.BusLineEvent;
import com.hrules.busline.BusLineListener;
import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.model.ConverterObject;
import com.munon.artistinformer.ui.albums.AlbumsActivity;
import com.munon.artistinformer.ui.main.adapter.MainListAdapter;
import com.munon.artistinformer.ui.main.adapter.MainListAdapterListener;
import com.munon.artistinformer.ui.main.events.MainListBusLineEvent;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainFragment extends Fragment implements MainListAdapterListener, BusLineListener {

    private Listener listener = dummyListener;

    @InjectView(R.id.progress)
    ProgressBar progress;
    @InjectView(R.id.text)
    TextView text;
    @InjectView(R.id.list)
    RecyclerView list;

    private List<Artist> listItems;

    public interface Listener {
        void onItemSelected(Artist position);
    }

    private static final Listener dummyListener = new Listener() {
        @Override
        public void onItemSelected(Artist position) {
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
        list.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }
        });
    }

    @Override
    public void onEvent(BusLineEvent busLineEvent) {
        if (busLineEvent.getAction().equals(MainListBusLineEvent.ACTION_SHOW_LIST)) {
            try {
                listItems = (java.util.List<Artist>) busLineEvent.getObject();
                list.setAdapter(new MainListAdapter(getActivity(), listItems, this, ((MainActivity) getActivity()).isTabletLayout()));
                showList();

            } catch (Exception e) {
                showText(getString(R.string.not_found));
            }

        } else if (busLineEvent.getAction().equals(MainListBusLineEvent.ACTION_SHOW_PROGRESS)) {
            showProgress();

        } else if (busLineEvent.getAction().equals(MainListBusLineEvent.ACTION_SHOW_TEXT)) {
            showText((String) busLineEvent.getObject());

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Listener)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks");
        }
        listener = (Listener) activity;

        BusLine.with(activity).register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = dummyListener;

        BusLine.with(getActivity()).unregister();
    }

    @Override
    public void onClick(int position) {
        listener.onItemSelected(listItems.get(position));
    }



    private void showProgress() {
        list.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    private void showList() {
        list.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);

    }

    private void showText(String message) {
        list.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        text.setText(message);
    }
}
