fun main() {
    val req = fetch("https://scb.se/")
    val document = KtDom(req)

    val elm = document.getElementById("scb-logotype");

    if (elm != null) {

        val href = elm.getAttribute("href");

        // Log to console
        println(
            href
        )

    };

}