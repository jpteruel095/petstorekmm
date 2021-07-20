package com.pat.petstore_kmm

import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.HttpResponse
import org.openapitools.client.models.Pet

class PetStoreService{
    @Throws(Throwable::class)
    suspend fun getPetById(petId: Long): PetObject {
        return ClientWrapper.getPetById(petId)
    }
}

internal object ClientWrapper {
    private val api = PetApi()

    @Throws(Throwable::class)
    suspend fun getPetById(petId: Long): HttpResponse<Pet> {
        return api.getPetById(petId)
    }
}

internal class PetObj(name: String) : PetObject(name) {
}