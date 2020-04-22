package com.mike.tennisnotes.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionsUtils {

    companion object {
        fun allPermissionsGranted(requiredPermission: Array<String>, context: Context?) =
            requiredPermission.all {
                ContextCompat.checkSelfPermission(
                    (context as Activity?)!!, it
                ) == PackageManager.PERMISSION_GRANTED
            }
    }


}