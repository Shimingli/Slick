package com.github.slick.sample.fragment.dagger;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.slick.Presenter;
import com.github.slick.SlickFragment;
import com.github.slick.sample.App;
import com.github.slick.sample.R;
import com.github.slick.Slick;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaggerFragment extends SlickFragment<DaggerFragmentView, DaggerFragmentPresenter>
        implements DaggerFragmentView {

    @Inject
    Provider<DaggerFragmentPresenter> presenterProvider;
    @Presenter
    DaggerFragmentPresenter presenter;

    public DaggerFragment() {
        // Required empty public constructor
    }

    public static DaggerFragment newInstance() {
        return new DaggerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_example, container, false);
        ((TextView) view.findViewById(R.id.text_view_fragment)).setText("Dagger Fragment.");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.getDaggerComponent(getActivity()).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Object bind() {
        return Slick.bind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getActivity().isFinishing()) {
            App.disposeDaggerComponent(getActivity());
        }
    }
}