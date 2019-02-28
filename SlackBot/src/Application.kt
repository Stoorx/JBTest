package slackBot

import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress


class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val server: HttpServer = HttpServer.create(InetSocketAddress(8080), 1)
            val context = server.createContext("/")
            context.handler = HttpHandler { exchange ->
                val out = "<html><head><meta charset=\"utf-8\"></head>" +
                        "<body>" +
                        " ${Message(Input(exchange?.requestURI?.query.orEmpty())).text} " +
                        "</body></html>"
                val byteResponse = out.toByteArray()
                exchange?.sendResponseHeaders(200, byteResponse.size.toLong())
                exchange?.responseBody?.write(byteResponse)
                exchange?.responseBody?.close()
            }
            server.start()
        }
    }
}