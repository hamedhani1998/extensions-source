package eu.kanade.tachiyomi.extension.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class CloudflareInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code == 403) {
            response.close()
            throw IOException("Cloudflare protection detected")
        }

        return response
    }
}
