package bunchTool

import java.io.File
import java.io.FileNotFoundException

class BunchTool {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 1) {
                println("Incorrect args!")
                return
            }
            try {
                File(args[0]).walk().forEach {
                    if (it.isFile && it.extension in arrayOf("java", "kt")) {
                        println("${it.extension} ${it.name} ${it.absolutePath}")
                        it.renameTo(File(it.absolutePath + ".2019"))
                    }
                }
            } catch (e: FileNotFoundException) {
                println(e.localizedMessage)
            }
        }
    }
}