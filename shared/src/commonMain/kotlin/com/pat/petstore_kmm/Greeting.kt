package com.pat.petstore_kmm

import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.HttpResponse
import org.openapitools.client.models.Pet

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    @Throws(Throwable::class)
    suspend fun getPet(): HttpResponse<Pet>{
        return PetApi().getPetById(1)
    }
}