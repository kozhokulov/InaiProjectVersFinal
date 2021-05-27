package com.t_assistant.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public abstract class BaseActivity extends AppCompatActivity {

    /**
     * abstract methods
     * @return
     */
    protected abstract int layoutID();
    protected abstract void ui();
    protected abstract void function();
    protected abstract Fragment setfragment();
    protected abstract int setContainerId();

    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layoutID());
        ui();
        function();
    }

    /**
     * Fragment Load
     */
    public void FrgamentLoader(){
        getSupportFragmentManager().beginTransaction().replace(setContainerId(), setfragment()).commit();
    }

}
