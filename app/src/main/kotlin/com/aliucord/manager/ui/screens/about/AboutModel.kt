package com.aliucord.manager.ui.screens.about

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.aliucord.manager.network.models.Developer
import com.aliucord.manager.network.services.HttpService
import com.aliucord.manager.ui.util.toUnsafeImmutable
import com.aliucord.manager.util.launchIO
import kotlinx.collections.immutable.persistentListOf

class AboutModel(
    private val http: HttpService,
) : StateScreenModel<AboutScreenState>(AboutScreenState.Loading) {
    init {
        fetchDevelopers()
    }

    fun fetchDevelopers() = screenModelScope.launchIO {
        mutableState.value = AboutScreenState.Loading

        val allDevelopers = persistentListOf(
            Developer(
                username = "kmmiio99o",
                avatarUrl = "https://github.com/kmmiio99o.png",
                commits = 0,
                repositories = emptyList(),
                role = "ShiggyCord - Creator"
            ),
          Developer(
                username = "jonatanktk",
                avatarUrl = "https://github.com/jonatanktk.png",
                commits = 0,
                repositories = emptyList(),
            ),
            Developer(
                username = "OTKUSteyler",
                avatarUrl = "https://github.com/OTKUSteyler.png",
                commits = 0,
                repositories = emptyList(),
            ),
            Developer(
                username = "rushiiMachine",
                avatarUrl = "https://github.com/rushiiMachine.png",
                commits = 0,
                repositories = emptyList(),
            ),
            Developer(
                username = "maisymoe",
                avatarUrl = "https://github.com/maisymoe.png",
                commits = 0,
                repositories = persistentListOf<com.aliucord.manager.network.models.Contributor.Repository>()
            ),
            Developer(
                username = "kmmiio99o",
                avatarUrl = "https://github.com/kmmiio99o.png",
                commits = 0,
                repositories = emptyList(),
            ),
           Developer(
                username = "pylixonly",
                avatarUrl = "https://github.com/pylixonly.png",
                commits = 0,
                repositories = emptyList(),
            )
        )
        
        )

        mutableState.value = AboutScreenState.Loaded(allDevelopers.toUnsafeImmutable())
    }
}
