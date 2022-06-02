fun main() {
    val req = fetch("https://www.cisco.com/")
    val document = KtDom(req)

    val elm = document.getElementById("hero-heading-1")

    if (elm != null) {

        val href = elm.getAttribute("id")

        // Log to console
        println(
            elm.innerHTML
        )

    }

}