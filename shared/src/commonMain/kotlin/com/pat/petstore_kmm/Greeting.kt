package com.pat.petstore_kmm

import io.ktor.client.engine.*
import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.HttpResponse
import org.openapitools.client.models.Pet

object Greeting {
    private val api = PetApi(httpClientEngine = Injections().engine)
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    @Throws(Throwable::class)
    suspend fun getPet(): HttpResponse<Pet>{
        return api.getPetById(1)
    }

    @Throws(Throwable::class)
    suspend fun getSomething(): String{
        return api.getPetById(1).run {
            return body().name
        }
    }
}

expect class Injections(){
    val engine: HttpClientEngine
}