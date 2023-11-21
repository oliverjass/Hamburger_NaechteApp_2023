package com.example.myapplication.data.remote

import com.example.myapplication.data.datamodels.Locations
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

val BASE_URL = "https://public.syntax-institut.de/apps/batch9/OliverJass/"                          // Hier wird der URL link hergerufen

                                                                                                    // Moshi Convertet die Url in JSON in kotlin dateien zu erstellen um sie einfach und effizienter zu machen
                                                                                                    // KotlinJsonAdapterFactory ist wahrscheinlich überflüssig
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


val retrofit = Retrofit.Builder()                                                                   // Ein RetrofitService übernimmt die Kommunikation mit dem Serverund übersetzt die Antwort in Kotlin Objekte
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface LocationApiService {
    @GET("locations.json")                                                                          //mittels GET wird eine Liste an Usern geladen
    suspend fun getLocationsFromAPI(): List<Locations>                                              //Liefert eine Locationlist variable zurück welche eine Liste an Location daten beinhaltet

    @GET("{contextPath}locations.json")
    suspend fun getLocationsFromAPI(@Path("contextPath") contextPath: String = ""): List<Locations>

}

                                                                                                    // Singleton-Instanz namens LocationApi: retrofit service stellt die verbindung zum server her. bereitstellung der daten um zu interagieren
object LocationApi {
    val retrofitService: LocationApiService by lazy { retrofit.create(LocationApiService::class.java) }
}