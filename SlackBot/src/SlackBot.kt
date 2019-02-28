package slackBot

fun Message(m: Input): Output {
    val greeting = "Hello, ${m.text}"
    return Output(text = greeting)
}