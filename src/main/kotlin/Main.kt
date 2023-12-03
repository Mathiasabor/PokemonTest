fun main(args: Array<String>) {
    //println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
   // println("Program arguments: ${args.joinToString()}")

    val a = "localhost/ami/dr/2/"
    val b = "localhost/dr/1200/"
    val c = "localhost/dr/120/"
    val d = "localhost/dr/12/"

    val entierA = extraireEntier(a)
    val entierB = extraireEntier(b)
    val entierC = extraireEntier(c)
    val entierD = extraireEntier(d)

    println("Entier extrait de '$a': $entierA")
    println("Entier extrait de '$b': $entierB")
    println("Entier extrait de '$c': $entierC")
    println("Entier extrait de '$d': $entierD")
}

fun extraireEntier(chaine: String): Int? {
    val regex = Regex("""/(\d+)/$""")
    val matchResult = regex.find(chaine)

    return matchResult?.groupValues?.get(1)?.toIntOrNull()
}