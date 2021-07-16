package com.pat.petstore_kmm

import io.ktor.client.engine.*
import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.HttpResponse
import org.openapitools.client.models.Pet

object PetService {
    private val api = PetApi(httpClientEngine = Injections().engine)

    @Throws(Throwable::class)
    suspend fun fetchPet(): HttpResponse<Pet>{
        return api.getPetById(1)
    }
}

expect class Injections(){
    val engine: HttpClientEngine
}