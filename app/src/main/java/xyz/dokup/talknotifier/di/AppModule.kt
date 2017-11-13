package xyz.dokup.talknotifier.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import xyz.dokup.talknotifier.api.service.TalkNotifierService
import xyz.dokup.talknotifier.di.constant.PrefKeys
import xyz.dokup.talknotifier.di.provider.OrmaProvider
import javax.inject.Singleton

/**
 * Created by e10dokup on 2017/11/13.
 */
@Module
class AppModule(private val context: Context) {

    companion object {
        private fun createGson(): Gson {
            return GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create()
        }
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideOrmaDatabase(context: Context): OrmaProvider {
        return OrmaProvider(context)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PrefKeys.KEY_PREF, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideTalkNotifierService(): TalkNotifierService {
        return Retrofit.Builder()
                .baseUrl("https://10-dot-talknorifier.appspot.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build().create(TalkNotifierService::class.java)
    }

}