package lucasqrib.com.br.data.remote.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val API_KEY = "e01dc4b493ffb4793bcf34f930e25d68"

    fun createApi(): Api {

        return Retrofit.Builder()
            .client(provideOkttp())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(Api::class.java)
    }

     fun provideOkttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().let {
            it.addInterceptor(interceptor).build()
            it.addInterceptor(getQueryInterceptor())
            it.build()
        }

    }

    private fun getQueryInterceptor(): Interceptor = Interceptor {
        val request = it.request()
        val newUrl = request.url().newBuilder()
            .addQueryParameter("apikey", API_KEY)
            .build()
        val requestBuilder = request.newBuilder().url(newUrl)
            .build()
        it.proceed(requestBuilder)
    }
}