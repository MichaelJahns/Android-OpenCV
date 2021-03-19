//package org.opencv.samples.tutorial5
//
//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.opengl.ETC1
//import android.util.AttributeSet
//import android.util.Log
//import org.opencv.android.JavaCameraView
//import java.io.FileOutputStream
//
//class Camera(context: Context?, attrs: AttributeSet?) :
//        JavaCameraView(context, attrs) {
//    val effectList: List<String>
//        get() = mCamera.getParameters().getSupportedColorEffects()
//    val isEffectSupported: Boolean
//        get() = mCamera.getParameters().getColorEffect() != null
//    var effect: String?
//        get() = mCamera.getParameters().getColorEffect()
//        set(effect) {
//            val params: Camera.Parameters = mCamera.getParameters()
//            params.colorEffect = effect
//            mCamera.setParameters(params)
//        }
//    val resolutionList: List<Camera.Size>
//        get() = mCamera.getParameters().getSupportedPreviewSizes()
//    var resolution: Camera.Size
//        get() = mCamera.getParameters().getPreviewSize()
//        set(resolution) {
//            disconnectCamera()
//            mMaxHeight = resolution.height
//            mMaxWidth = resolution.width
//            connectCamera(ETC1.getWidth(), ETC1.getHeight())
//        }
//
//    fun takePicture(fileName: String) {
//        Log.i(TAG, "Tacking picture")
//        val callback: PictureCallback = object : PictureCallback {
//            private val mPictureFileName = fileName
//            override fun onPictureTaken(data: ByteArray, camera: Camera) {
//                Log.i(TAG, "Saving a bitmap to file")
//                val picture = BitmapFactory.decodeByteArray(data, 0, data.size)
//                try {
//                    val out = FileOutputStream(mPictureFileName)
//                    picture.compress(Bitmap.CompressFormat.JPEG, 90, out)
//                    picture.recycle()
//                    mCamera.startPreview()
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//        mCamera.takePicture(null, null, callback)
//    }
//
//    companion object {
//        private const val TAG = "Sample::SampleJavaCameraView"
//    }
//}