fun message(channel: String, msg: String?) {
    println("""TECHIO> message --channel "$channel" "$msg"""")
}

fun success(success: Boolean) {
    println("TECHIO> success $success")
}

class Channel(private val name: String) {
    fun write(msg: String?) = message(name, msg)
    fun annotate(filePath: String, line: Int, msg: String, column: Int?, type: AnnotateType = AnnotateType.ERROR) =
        annotate(filePath, line, msg, column, type, name)
}

fun channel(name: String, block: Channel.() -> Unit) {
    Channel(name).apply(block)
}

enum class AnnotateType(val label: String) {
    INFO("info"),
    WARNING("warning"),
    ERROR("error")
}

fun annotate(
    filePath: String,
    line: Int,
    msg: String,
    column: Int? = null,
    type: AnnotateType = AnnotateType.ERROR,
    channel: String? = null
) {
    fun String.escape() = """"${replace('"', '\'')}""""

    val position = if (column != null) "$line:$column" else "$line"

    val fileOption = "file" to filePath
    val positionOption = "position" to position
    val typeOption = "type" to type.label
    val channelOption = "channel" to channel

    val options = listOf(fileOption, positionOption, typeOption, channelOption).filter { it.second != null }
        .joinToString(separator = " ") {
            "--${it.first} ${it.second?.escape()}"
        }

    println("TECHIO> annotate $options ${msg.escape()}")
}