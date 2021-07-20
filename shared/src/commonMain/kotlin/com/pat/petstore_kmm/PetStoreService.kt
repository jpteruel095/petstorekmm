package com.pat.petstore_kmm

import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.HttpResponse
import org.openapitools.client.models.Pet

class PetStoreService{
    @Throws(Throwable::class)
    suspend fun getPetById(petId: Long): PetObject {
        val resp = ClientWrapper.api.getPetById(petId).body()
        return PetObj(resp.name)
    }
}

internal object ClientWrapper {
    val api = PetApi()
}

sealed class PetObject(val name: String) {
}

internal class PetObj(name: String) : PetObject(name) {
}