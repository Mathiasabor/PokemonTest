import Models.Pokemons
import Models.TypePokemon

suspend fun main(args: Array<String>) {
    //println("Hello World!")
val Hand = Handlers()
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
   // println("Program arguments: ${args.joinToString()}")
    var option: Int
    var option1 : Int
    var option2 : Int
    println("Affichage des types de pokemon")
    val allpoktype :TypePokemon = Hand.executeGetAllPokemonType()
    lateinit var allPokByType : Pokemons


    while (true) {

        println("1 pour la liste des types")
        println("2 pour la liste des pokemon par types")
        println("3 pour le détail des pokemon par types")

        option = readLine()!!.toInt()

        when(option){
            1->{
                println(allpoktype)
            }
            2->{
                println("entrer le id du type pour voir la liste des pokemon")
                option1 = readLine()!!.toInt()
               // var id = allpoktype.results[option1].url.takeLast(2).first().toString().toInt()
                var id = extraireEntier(allpoktype.results[option1].url)
                println(id)



                allPokByType = Hand.executeGetAllPokemonByType(id!!)
                println("final   "+allPokByType)

            }

            3->{
                println("entrer le id du type pour voir la liste des pokemon")
                option2 = readLine()!!.toInt()

               // var id = allPokByType.pokemon[option2].pokemon.url.takeLast(2).first().toString().toInt()
                var id = extraireEntier(allPokByType.pokemon[option2].pokemon.url)
                var pokDetail = Hand.executeGetPokemonById(id!!)
                println("final   "+pokDetail)
            }
        }
    }

    }

fun extraireEntier(chaine: String): Int? {
    val regex = Regex("""/(\d+)/$""")
    val matchResult = regex.find(chaine)

    return matchResult?.groupValues?.get(1)?.toIntOrNull()
}