package ua.alegator1209.image_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ua.alegator1209.image_app.core.datasource.PhotoDataSource
import ua.alegator1209.image_app.core.model.Photo
import ua.alegator1209.image_app.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class PhotoActivity : AppCompatActivity() {
    private val scope = CoroutineScope(Dispatchers.Main)
    private val adapter = PhotoAdapter()

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var dataSource: PhotoDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.also {
            it.layoutManager = GridLayoutManager(this, 3)
            it.adapter = adapter
        }

        Fresco.initialize(this)

        loadImages()
    }

    private fun loadImages() {
        scope.launch {
            dataSource.search("summer", perPage = 30)
                .flowOn(Dispatchers.IO)
                .collect(this@PhotoActivity::showPhotos)
        }
    }
    
    private fun showPhotos(photos: List<Photo>) {
        adapter.addPhotos(photos)
    }
}
