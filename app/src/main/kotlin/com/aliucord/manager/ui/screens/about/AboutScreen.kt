/*
 * Copyright (c) 2022 Juby210 & zt
 * Licensed under the Open Software License version 3.0
 */

package com.aliucord.manager.ui.screens.about

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.aliucord.manager.ui.components.*
import com.aliucord.manager.ui.screens.about.components.LeadContributor
import com.aliucord.manager.ui.util.paddings.*
import dev.goon.manager.R
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class AboutScreen : Screen, Parcelable {
    @IgnoredOnParcel override val key = "About"

    @Composable
    override fun Content() {
        val model = koinScreenModel<AboutModel>()

        AboutScreenContent(state = model.state.collectAsState())
    }
}

@Composable
fun AboutScreenContent(state: State<AboutScreenState>) {
    Scaffold(
            topBar = {
                TopAppBar(
                        title = { Text(stringResource(R.string.navigation_about_manager)) },
                        navigationIcon = { BackButton() },
                )
            }
    ) { paddingValues ->
        LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding =
                        paddingValues
                                .exclude(PaddingValuesSides.Horizontal + PaddingValuesSides.Top)
                                .add(PaddingValues(vertical = 16.dp)),
                modifier =
                        Modifier.padding(paddingValues.exclude(PaddingValuesSides.Bottom))
                                .padding(horizontal = 14.dp),
        ) {
            item(key = "MANAGER_CREDIT_DISCLAIMER_BANNER") {
                Box(
                        contentAlignment = Alignment.Center,
                        modifier =
                                Modifier.padding(bottom = 24.dp)
                                        .border(
                                                width = 2.dp,
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.medium
                                        )
                                        .clip(MaterialTheme.shapes.medium)
                                        .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                ) {
                    Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 14.dp)
                    ) {
                        Text(
                                text =
                                        stringResource(
                                                R.string.about_manager_credit_disclaimer_notice
                                        ),
                                style = MaterialTheme.typography.labelMedium,
                        )
                    }
                }
            }

            item(key = "PROJECT_HEADER") { ProjectHeader() }

            item(key = "HEADER_DIVIDER") {
                TextDivider(
                        text = stringResource(R.string.contributors_lead),
                        modifier = Modifier.padding(top = 18.dp, bottom = 20.dp),
                )
