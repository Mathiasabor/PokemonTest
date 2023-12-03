package Models


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

@GET("type/")
suspend fun getAllPokemonType() : Response<TypePokemon>

@GET("type/{id}")
suspend fun getAllPokemonByType(@Path("id") id : Int): Response<Pokemons>

@GET("pokemon/{id}")
suspend fun getPokemonById(@Path("id") id : Int): Response<PokemonDetail>


}