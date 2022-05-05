import java.net.URL
import java.util.*

class fetch(address: String) {
    val url: URL
    val data: String

    init {
        this.url = URL(address);
        this.data = request();
    }

    private fun request(): String {
        val urlScanner = Scanner(this.url.openStream())
        var data = "";
        while (urlScanner.hasNext()) data += urlScanner.nextLine() + "\n";
        return data;
    }

    constructor(name: String, parent: String) : this(name) {
        println("boom");
    }

}