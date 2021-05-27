package com.t_assistant.misc.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import static com.t_assistant.misc.utils.Constants.PERMISSIONS_REQ;




public class PermissionManagers {

    /**
     * Array Permission
     */
    private static String[] arrayPermission = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_WIFI_STATE
    };

    /**
     * Check permission
     * @param activity
     * @return
     */
    public static boolean checkPermission(Activity activity){
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:arrayPermission) {
            result = ContextCompat.checkSelfPermission(activity,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),PERMISSIONS_REQ );
            return false;
        }
        return true;
    }
}
