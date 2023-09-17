package com.bbbrrr8877.wordcounter.core


fun main() {

    val emptyText = ""
    val text =
        "Returns a view of the Returns a view of the Returns a view of the portion of this map whose keys range from fromKey, changes in the returned map are reflected in this map, and vice-versa. map supports."

    fun String.countWords(): Map<String, Int> {

        val map = mutableMapOf<String, Int>()
        var word: String
        var stringBuilder = StringBuilder()

        this.forEach {
            if (it.isLetter()) {
                stringBuilder.append(it)
            } else {
                word = stringBuilder.toString()
                stringBuilder.delete(0, stringBuilder.length)
                if (!map.containsKey(word)) {
                    map[word] = 1
                    word = ""
                } else {
                    var value = map[word]
                    value = value!! + 1
                    map.remove(word)
                    map[word] = value
                    word = ""
                }
            }
        }
        if (map.containsKey("")){
            map.remove("")
        }
        return map.toMap()
    }

    println(emptyText.countWords())
    println(text.countWords())

}


