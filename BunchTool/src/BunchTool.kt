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
            val directory = File(args[0]).takeIf { it.exists() }
            if (directory === null) {
                println("Directory not exists.")
                exitProcess(2)
            }
            if(directory.isFile){
                println("File passed. Expected directory.")
                exitProcess(3)
            }

            directory.walk()
                    .filter { it.isFile && it.extension in arrayOf("java", "kt") }
                    .forEach {
                        it.renameTo(File(it.absolutePath + ".2019"))
                        println(it.absolutePath)
                    }

        }
    }
}