package com.aliucord.manager.patcher.steps.download

import com.aliucord.manager.manager.PathManager
import com.aliucord.manager.network.services.ShiggyGithubService
import com.aliucord.manager.network.utils.SemVer
import com.aliucord.manager.network.utils.getOrThrow
import com.aliucord.manager.patcher.StepRunner
import com.aliucord.manager.patcher.steps.base.DownloadStep
import dev.goon.manager.R
import org.koin.core.component.inject

import com.aliucord.manager.patcher.steps.base.StepState

class DownloadShiggyXposedStep : DownloadStep() {
    private val paths: PathManager by inject()
    private val shiggyGithubService: ShiggyGithubService by inject()

    override val localizedName = R.string.patch_step_dl_wtxposed
    override val targetFile get() = paths.cachedShiggyXposed(targetVersion)
    override lateinit var targetUrl: String

    lateinit var targetVersion: SemVer
        private set

    override suspend fun execute(container: StepRunner) {
        val localXposed = listOf(
            paths.shiggyDir.resolve("GoonXposed.apk"),
            paths.shiggyDir.resolve("wt-xposed.apk")
        ).firstOrNull { it.exists() }

        if (localXposed != null) {
            container.log("Found local GoonXposed at ${localXposed.absolutePath}")
            targetVersion = SemVer(99, 0, 0)
            targetFile.parentFile?.mkdirs()
            localXposed.copyTo(targetFile, overwrite = true)
            state = StepState.Skipped
            container.log("Using local GoonXposed instead of remote download")
            return
        }

        val latestRelease = shiggyGithubService.getLatestXposedRelease().getOrThrow()
        container.log("Latest GoonXposed release is ${latestRelease.name}")

        targetVersion = SemVer.parse(latestRelease.name)
        targetUrl = latestRelease.assets.first { it.name == "app-release.apk" }.browserDownloadUrl
        super.execute(container)
    }
}
