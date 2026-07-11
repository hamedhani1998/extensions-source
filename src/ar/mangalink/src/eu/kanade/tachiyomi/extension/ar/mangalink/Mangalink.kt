package eu.kanade.tachiyomi.extension.ar.mangalink

import eu.kanade.tachiyomi.extension.interceptor.CloudflareInterceptor
import eu.kanade.tachiyomi.multisrc.madara.Madara
import keiyoushi.annotation.Source
import java.text.SimpleDateFormat
import java.util.Locale

@Source
abstract class Mangalink : Madara() {
    override val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale("ar"))
    override val chapterUrlSuffix = ""
    override val useLoadMoreRequest = LoadMoreStrategy.Always

    override val client = network.client.newBuilder()
        .addInterceptor(CloudflareInterceptor())
        .build()
}
