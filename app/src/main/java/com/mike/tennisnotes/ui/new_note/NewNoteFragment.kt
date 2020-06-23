package com.mike.tennisnotes.ui.new_note

import android.Manifest
import android.os.Bundle
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageSavedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mike.tennisnotes.databinding.FragmentNewNoteBinding
import com.mike.tennisnotes.utils.PermissionsUtils
import java.io.File
import java.util.concurrent.Executors


private const val REQUEST_CODE_PERMISSIONS = 10

private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)

class NewNoteFragment : Fragment() {

    private lateinit var newNoteViewModel: NewNoteViewModel
    private lateinit var binding: FragmentNewNoteBinding
    private lateinit var imageCapture: ImageCapture

    private val executor = Executors.newSingleThreadExecutor()
    private val previewOutputUpdateListener =
        Preview.OnPreviewOutputUpdateListener {
            val parent = binding.viewFinder.parent as ViewGroup
            parent.removeView(binding.viewFinder)
            parent.addView(binding.viewFinder, 0)
            binding.viewFinder.surfaceTexture = it.surfaceTexture
            newNoteViewModel.updateTransform(binding.viewFinder)
        }
    private val captureButtonListener = View.OnClickListener {
        val file = File(
            context?.externalMediaDirs?.first(),
            "${System.currentTimeMillis()}.jpg"
        )

        imageCapture.takePicture(file, executor,
            object : OnImageSavedListener {
                override fun onError(
                    imageCaptureError: ImageCapture.ImageCaptureError,
                    message: String,
                    exc: Throwable?
                ) {
                    val msg = "Photo capture failed: $message"
                    binding.viewFinder.post {
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onImageSaved(file: File) {
                    val msg = file.absolutePath
                    binding.viewFinder.post {
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                        findNavController().navigate(
                            NewNoteFragmentDirections.actionNavigationNewNoteToEditNoteFragment(msg)
                        )
                        CameraX.unbindAll()
                    }
                }
            })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newNoteViewModel =
            ViewModelProvider(this).get(NewNoteViewModel::class.java)
        binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        binding.viewFinder.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
        }
        if (PermissionsUtils.allPermissionsGranted(REQUIRED_PERMISSIONS, context)) {
            binding.viewFinder.post { startCamera() }
        } else {
            requestPermissions(
                REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        return binding.root
    }


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {

        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (PermissionsUtils.allPermissionsGranted(REQUIRED_PERMISSIONS, context)) {
                binding.viewFinder.post { startCamera() }
            } else {
                Toast.makeText(
                    context,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }


    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder().apply {
            setTargetResolution(Size(640, 480))
        }.build()

        // Build the viewfinder use case
        val preview = Preview(previewConfig)


        // Every time the viewfinder is updated, recompute layout
        preview.setOnPreviewOutputUpdateListener(previewOutputUpdateListener)


        val imageCaptureConfig = ImageCaptureConfig.Builder()
            .apply {
                setCaptureMode(ImageCapture.CaptureMode.MIN_LATENCY)
            }.build()

        // Build the image capture use case and attach button click listener
        imageCapture = ImageCapture(imageCaptureConfig)
        binding.captureButton.setOnClickListener(captureButtonListener)
        CameraX.bindToLifecycle(this, preview, imageCapture)
    }

}
