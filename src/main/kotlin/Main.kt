fun main() {
    val req = fetch("https://landcon.org/")
    val document = KtDom(req)

    println(document.getElementById("counter"))
}