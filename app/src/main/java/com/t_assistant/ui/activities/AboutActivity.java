package com.t_assistant.ui.activities;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.t_assistant.R;
import com.t_assistant.base.BaseActivity;


public class AboutActivity extends BaseActivity {

    private Toolbar
            toolbar;

    @Override
    protected int layoutID() {
        return R.layout.activity_about;
    }

    @Override
    protected void ui() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void function() {
        toolbar.setTitle(R.string.About);
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }
}