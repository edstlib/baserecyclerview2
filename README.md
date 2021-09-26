# baserecyclerview2
# BaseRecyclerView2

## Setup
### Gradle

Add this to your project level `build.gradle`:
```groovy
allprojects {
 repositories {
    maven { url "https://jitpack.io" }
 }
}
```
Add this to your app `build.gradle`:
```groovy
dependencies {
    implementation 'com.github.edtslib:baserecyclerview2:latest'
}
```
# Usage

Create enum class helper, for define your holder type. An example is shown below.
```kotlin
enum class MyAdapterType {
    Header, ItemText, ItemImage
}
```

Create a holder for every your adapter type. An example is shown below.
```kotlin
class TextHolder(private val binding: AdapterItemBinding): BaseViewHolder<String>(binding) {
    override fun setData(t: String?) {
        binding.textView.text = t
    }

}

class ImageHolder(private val binding: AdapterImageBinding): BaseViewHolder<PhotoData>(binding) {
    override fun setData(t: PhotoData?) {
        Glide.with(itemView.context).load(t?.url).into(binding.imageView)
        binding.textView.text = t?.caption
    }

}
```

Create your adapter extend to BaseRecyclerView2, adn implement the abstrach method. And you can define listener implentation for every holder. An example is shown below.

```kotlin
class TestAdapter: BaseRecyclerView2() {
    override fun createHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        return when(viewType) {
            MyAdapterType.ItemText.ordinal -> {
                val binding = AdapterItemBinding.inflate(inflater, parent, false)
                TextHolder(binding)
            }
            MyAdapterType.ItemImage.ordinal -> {
                val binding = AdapterImageBinding.inflate(inflater, parent, false)
                val holder = ImageHolder(binding)
                holder.delegate = object : BaseRecyclerView2AdapterDelegate<PhotoData> {
                    override fun onClick(t: PhotoData?, position: Int, viewBinding: ViewBinding) {
                    }

                    override fun onDraw(t: PhotoData?, position: Int, viewBinding: ViewBinding) {
                    }
                }

                holder
            }
            else -> {

                val binding = AdapterHeaderBinding.inflate(inflater, parent, false)
                BaseViewHolder<Any>(binding)
            }
        }
    }

}
```
