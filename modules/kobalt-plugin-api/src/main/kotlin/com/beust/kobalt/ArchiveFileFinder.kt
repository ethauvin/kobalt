package com.beust.kobalt

import com.beust.kobalt.api.KobaltContext
import com.beust.kobalt.api.Project
import com.beust.kobalt.archive.Zip
import com.beust.kobalt.misc.IncludedFile
import com.beust.kobalt.misc.KFiles
import java.io.File

interface ArchiveFileFinder {
    fun findIncludedFiles(project: Project, context: KobaltContext, zip: Zip) : List<IncludedFile>
    fun fullArchiveName(project: Project, context: KobaltContext, archiveName: String?, suffix: String) : File {
        val fullArchiveName = context.variant.archiveName(project, archiveName, suffix)
        val archiveDir = File(KFiles.libsDir(project))
        val result = File(archiveDir.path, fullArchiveName)
        return result
    }
}