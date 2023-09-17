package com.bbbrrr8877.wordcounter.core

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