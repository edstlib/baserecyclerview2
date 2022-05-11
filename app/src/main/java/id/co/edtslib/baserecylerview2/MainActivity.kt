package id.co.edtslib.baserecylerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.edtslib.baserecyclerview2.AdapterData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TestAdapter()
        adapter.list.add(AdapterData(MyAdapterType.Header.ordinal, null))
        adapter.list.add(AdapterData(MyAdapterType.ItemImage.ordinal, PhotoData("https://pbs.twimg.com/profile_images/491390735749378050/ZK5nwUPR_400x400.jpeg", "abah ganteng")))
        repeat(5) {
            adapter.list.add(AdapterData(MyAdapterType.ItemText.ordinal, "Item $it"))
        }
        adapter.list.add(AdapterData(MyAdapterType.ItemImage.ordinal, PhotoData("https://pbs.twimg.com/profile_images/491390735749378050/ZK5nwUPR_400x400.jpeg", "abah ganteng")))
        repeat(10) {
            adapter.list.add(AdapterData(MyAdapterType.ItemText.ordinal, "Item ${it+5}"))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}