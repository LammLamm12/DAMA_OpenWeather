package pt.ipt.dama.dama_project2


import org.json.JSONException
import org.json.JSONObject
import kotlin.math.round

class WeatherDetails {

    lateinit var apiCity: String
    lateinit var apiTemperature: String
    lateinit var apiIcon: String

    lateinit var apiWeather: String
    var apiWeatherID = 0

    companion object {
        fun fromJson(jsonObject: JSONObject): WeatherDetails? {
            try {
                val weatherD = WeatherDetails()
                weatherD.apiCity = jsonObject.getString("name")
                weatherD.apiWeatherID =
                    jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id")
                weatherD.apiIcon = updateWeatherIcon(weatherD.apiWeatherID)
                weatherD.apiWeather =
                    jsonObject.getJSONArray("weather").getJSONObject(0).getString("main")

                val tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15
                val roundedValue = round(tempResult).toInt()
                weatherD.apiTemperature = roundedValue.toString()
                return weatherD

            } catch (e: JSONException) {
                e.printStackTrace()
                return null
            }

        }

        private fun updateWeatherIcon(condition: Int): String {
            when {
                condition in 0..300 -> {
                    return "thunder"
                }
                condition in 300..500 -> {
                    return "rain"
                }
                condition in 500..600 -> {
                    return "rain"
                }
                condition in 600..700 -> {
                    return "snow"
                }
                condition in 701..771 -> {
                    return "h"
                }
                condition in 772..799 -> {
                    return "h"
                }
                condition == 800 -> {
                    return "clear"
                }
                condition in 801..804 -> {
                    return "clouds"
                }
                condition in 900..902 -> {
                    return "clouds"
                }
                condition == 903 -> {
                    return "more_clouds"
                }
                condition == 904 -> {
                    return "more_clouds"
                }
                (condition >= 905) && (condition <= 1000) -> {
                    return "more_clouds"
                }
                else -> return "download"
            }
        }


    }

    fun getTemperature(): String {
        return "$apiTemperature°C"
    }

    fun getCity(): String {
        return apiCity
    }

    fun getIcon(): String {
        return apiIcon
    }

}