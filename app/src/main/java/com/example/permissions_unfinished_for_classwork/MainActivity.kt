package com.example.permissions_unfinished_for_classwork

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * UNFINISHED CLASSROOM VERSION
 *
 * Students should implement the TODOs:
 *  - Handle permission results in permissionsLauncher
 *  - Implement requestPermission(permission: String)
 *  - Implement requestStoragePermission() (Android 13+ versus legacy)
 *  - Implement updateAllStatuses() to read actual permission state
 */

class MainActivity : AppCompatActivity() {

    // UI
    private lateinit var btnSms: Button
    private lateinit var btnLocation: Button
    private lateinit var btnCamera: Button
    private lateinit var btnStorage: Button
    private lateinit var btnNotifPolicy: Button

    private lateinit var tvSmsStatus: TextView
    private lateinit var tvLocationStatus: TextView
    private lateinit var tvCameraStatus: TextView
    private lateinit var tvStorageStatus: TextView
    private lateinit var tvNotifPolicyStatus: TextView

    private val TAG = "PermDemo"

    // Launcher for permission requests — callback intentionally minimal for exercise
    private val permissionsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        // TODO (exercise): inspect results map and update corresponding TextViews (Granted / Not granted)
        Log.d(TAG, "permissionsLauncher called (UNFINISHED) -> $results")
        // placeholder to avoid crashes
        updateAllStatuses()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // bind views
        btnSms = findViewById(R.id.btnSms)
        btnLocation = findViewById(R.id.btnLocation)
        btnCamera = findViewById(R.id.btnCamera)
        btnStorage = findViewById(R.id.btnStorage)
        btnNotifPolicy = findViewById(R.id.btnNotifPolicy)

        tvSmsStatus = findViewById(R.id.tvSmsStatus)
        tvLocationStatus = findViewById(R.id.tvLocationStatus)
        tvCameraStatus = findViewById(R.id.tvCameraStatus)
        tvStorageStatus = findViewById(R.id.tvStorageStatus)
        tvNotifPolicyStatus = findViewById(R.id.tvNotifPolicyStatus)

        // set click listeners
        btnSms.setOnClickListener { requestPermission(Manifest.permission.READ_SMS) }
        btnLocation.setOnClickListener { requestPermission(Manifest.permission.ACCESS_FINE_LOCATION) }
        btnCamera.setOnClickListener { requestPermission(Manifest.permission.CAMERA) }
        btnStorage.setOnClickListener { requestStoragePermission() }

        // Notification policy access - left intact to open settings
        btnNotifPolicy.setOnClickListener { handleNotificationPolicyAccess() }
    }

    override fun onResume() {
        super.onResume()
        updateAllStatuses()
    }

    // Update all status TextViews (placeholders for students to implement)
    private fun updateAllStatuses() {
        // TODO (exercise): replace placeholders with actual permission checks.
        // Example: tvSmsStatus.text = permissionStatusText(Manifest.permission.READ_SMS)
        tvSmsStatus.text = "Status: (implement check)"
        tvLocationStatus.text = "Status: (implement check)"
        tvCameraStatus.text = "Status: (implement check)"
        tvStorageStatus.text = "Status: (implement check)"
        tvNotifPolicyStatus.text = if (isNotificationPolicyAccessGranted()) "Granted" else "Not granted"
    }

    // Helper students can use
    private fun permissionStatusText(permission: String): String {
        val granted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        return if (granted) "Granted" else "Not granted"
    }

    // Storage status intentionally left as placeholder
    private fun storageStatusText(): String {
        // TODO (exercise): implement proper checks for Android 13+ (READ_MEDIA_*) and legacy storage
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            "Storage: (implement READ_MEDIA_* checks)"
        } else {
            "Storage: (implement legacy check)"
        }
    }

    // UNFINISHED: request a single permission
    private fun requestPermission(permission: String) {
        // TODO (exercise):
        // - If permission already granted -> update UI and return
        // - Else call permissionsLauncher.launch(arrayOf(permission))
        Toast.makeText(this, "TODO: implement requestPermission for $permission", Toast.LENGTH_SHORT).show()
    }

    // UNFINISHED: request storage permissions
    private fun requestStoragePermission() {
        // TODO (exercise):
        // - API >= 33: launch READ_MEDIA_IMAGES, READ_MEDIA_VIDEO, READ_MEDIA_AUDIO
        // - else: request READ_EXTERNAL_STORAGE
        Toast.makeText(this, "TODO: implement requestStoragePermission()", Toast.LENGTH_SHORT).show()
    }

    // Notification policy helper (keeps working behavior)
    private fun isNotificationPolicyAccessGranted(): Boolean {
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return nm.isNotificationPolicyAccessGranted
    }

    private fun handleNotificationPolicyAccess() {
        if (isNotificationPolicyAccessGranted()) {
            Toast.makeText(this, "Notification policy access already granted", Toast.LENGTH_SHORT).show()
            return
        }
        val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        startActivity(intent)
    }
}
