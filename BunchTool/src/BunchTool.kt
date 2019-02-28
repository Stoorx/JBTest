package bunchTool

import java.io.File
import kotlin.system.exitProcess

class BunchTool {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 1) {
                println("Incorrect args!")
                exitProcess(1)

            }
            val directory = File(args[0])
            if (directory.exists())
                directory.walk().forEach {
                    if (it.isFile && it.extension in arrayOf("java", "kt")) {
                        it.renameTo(File(it.absolutePath + ".2019"))
                    }
                }
            else {
                println("Directory not exists!")
                exitProcess(2)
            }
        }
    }
}