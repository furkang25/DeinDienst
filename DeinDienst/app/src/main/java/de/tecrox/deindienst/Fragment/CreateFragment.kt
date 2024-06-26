package de.tecrox.deindienst.Fragment

import de.tecrox.deindienst.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CreateFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

}

    /*
    private lateinit var buttonAddImage: ImageButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    private val images = mutableListOf<Uri>()

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imagePreview: ImageView = itemView.findViewById(R.id.imagePreview)

        fun bind(imageUri: Uri) {
            imagePreview.setImageURI(imageUri)
            adjustImageSize(imagePreview)
            imagePreview.scaleType = ImageView.ScaleType.CENTER_CROP
        }

        // extension function to convert dp to pixels
        fun Int.dpToPx(): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                this.toFloat(),
                Resources.getSystem().displayMetrics
            ).toInt()
        }

        private fun adjustImageSize(imageView: ImageView) {
            val screenWidth = resources.displayMetrics.widthPixels
            val targetWidth = screenWidth - (2 * 16.dpToPx()) // 16dp margin on each side
            val layoutParams = imageView.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.width = targetWidth
            layoutParams.height = targetWidth // keep aspect ratio
            imageView.layoutParams = layoutParams
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create, container, false)

        //buttonAddImage = view.findViewById(R.id.buttonAddImage)
        //recyclerView = view.findViewById(R.id.recyclerView)

        imageAdapter = ImageAdapter(images)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = imageAdapter
        }

        buttonAddImage.setOnClickListener {
            addImage()
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data
            images.add(imageUri!!)
            imageAdapter.notifyDataSetChanged()
        }
    }

    private fun addImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_IMAGE)
    }

    companion object {
        private const val REQUEST_CODE_IMAGE = 1
    }
}


     */