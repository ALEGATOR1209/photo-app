package ua.alegator1209.image_app.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.alegator1209.image_app.core.model.Photo
import ua.alegator1209.image_app.databinding.RecyclerItemPhotoBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    private val photos = mutableListOf<Photo>()

    fun addPhotos(photos: List<Photo>) {
        val newPhotosStart = photos.lastIndex + 1
        this.photos.addAll(photos)
        notifyItemRangeInserted(newPhotosStart, photos.size)
    }

    override fun getItemCount(): Int = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val binding = RecyclerItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photos[position])
    }

    class PhotoHolder(
        private val binding: RecyclerItemPhotoBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.image.setColorFilter(Color.parseColor(photo.avgColor))
        }
    }
}