class KtDom(private val req: fetch) {

    fun getElementById(id: String): HTMLElement? {
        val idRegex = Regex("<[^>]+?id=\"([^\"]+)\".*");
        val matches = idRegex.findAll(req.data);
        val tag = matches.find { tag -> id == tag.groupValues.get(1) }

        if (tag != null) return HTMLElement(tag.value);

        return null;
    }

}