package com.t_assistant.base;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {

    /**
     * Abstract method
     * @return
     */
    protected abstract int layoutId();
    protected abstract void ui(View rootview);
    protected abstract void function();
    protected abstract Fragment setfragment();
    protected abstract int setContainerId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(layoutId(), container, false);
        ui(rootview);
        function();
        return rootview;
    }



    /**
     * Fragment Load
     */
    public void FrgamentLoader(){
        getFragmentManager().beginTransaction().replace(setContainerId(), setfragment()).addToBackStack(null).commit();
    }

}
