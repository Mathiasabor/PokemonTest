import Models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.ResponseBody
import java.lang.Exception

class Handlers {

    suspend fun executeGetAllPokemonType() : TypePokemon{
       return GlobalScope.async(context = Dispatchers.IO){
           lateinit var typePokemonList: TypePokemon
            try {
                val response = ApiClient.apiService.getAllPokemonType()
                //println(response.body()!!)
                if(response.isSuccessful && response.body()!=null){

                    typePokemonList = response.body()!!
                }

            }catch (e : Exception){
                println(e.message)
            }

            return@async typePokemonList
        }.await()
    }


    suspend fun executeGetAllPokemonByType(id : Int): Pokemons {
        return GlobalScope.async(context = Dispatchers.IO){
           lateinit  var pokemonListByType : Pokemons
            try {

                val response = ApiClient.apiService.getAllPokemonByType(id)
                println("reponse"+response.body()!!)
                if(response.isSuccessful && response.body()!=null){
                    pokemonListByType = response.body()!!
                }

            }catch (e : Exception){
                println("excep"+e.message)
            }

            return@async pokemonListByType
        }.await()
    }

    suspend fun executeGetPokemonById(id : Int) : PokemonDetail{
        return GlobalScope.async(context = Dispatchers.IO){
            lateinit  var pokemonDetail : PokemonDetail

            try {

                val response = ApiClient.apiService.getPokemonById(id)
                println("reponse"+response.body()!!)
                if(response.isSuccessful && response.body()!=null){
                    pokemonDetail = response.body()!!
                }

            }catch (e : Exception){
                println("excep"+e.message)
            }

            return@async pokemonDetail
        }.await()


    }

}