import java.util.*

class HTMLElement(private val StringElement: String) {

    private val rawStringTag: String;
    val nodeName: String;
    val innerHTML: String?;

    private fun matchTagName(tag: String): String {
        val reg = Regex("<([^\\s>]+)(\\s|>)+");
        val tagName = reg.find(tag);

        if (tagName != null) {
            return tagName.groupValues.get(1).uppercase();
        } else throw error("Failed to parse node name.");
    }

    private fun getInnerHTML(tag: String, nodeNameUppercase: String): String? {
        val nodeName = nodeNameUppercase.lowercase();
        val reg = Regex("<$nodeName(.*?)>(.*?)</$nodeName>");

        val innerHTML = reg.find(tag);

        if (innerHTML != null) {
            return innerHTML.groupValues.get(2);
        } else return null;
    }

    init {
        this.rawStringTag = StringElement;
        this.nodeName = matchTagName(StringElement);
        this.innerHTML = getInnerHTML(StringElement, this.nodeName);
    }

    fun getAttribute(name: String): String? {
        val reg = Regex(
            "<${this.nodeName.lowercase()}[^>]*?${name}=([\\\"\\'])?((?:.(?!\\1|>))*.?)\\1?"
        );
        val attr = reg.find(this.rawStringTag);

        if(attr != null) {
            return attr.groupValues.get(2);
        }

        return null;
    }
}
