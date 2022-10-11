package dev.mobilerevolution.starter.f1.repository

import dev.mobilerevolution.starter.f1.api.response.season.SeasonResponse
import kotlin.test.Test
import kotlin.test.assertEquals

class SeasonResponseMapperTest {
    @Test
    fun mapSeasonResponseToDomain() {
        val response = dev.mobilerevolution.starter.di.json.decodeFromString(SeasonResponse.serializer(), json)
        val season = SeasonResponseMapper().map(response)
        assertEquals(2, season.races.size)
    }

    private val json = """
        {
          "MRData": {
            "xmlns": "http:\/\/ergast.com\/mrd\/1.5",
            "series": "f1",
            "url": "http://ergast.com/api/f1/2022.json",
            "limit": "30",
            "offset": "0",
            "total": "22",
            "RaceTable": {
              "season": "2022",
              "Races": [
                {
                  "season": "2022",
                  "round": "1",
                  "url": "http:\/\/en.wikipedia.org\/wiki\/2022_Bahrain_Grand_Prix",
                  "raceName": "Bahrain Grand Prix",
                  "Circuit": {
                    "circuitId": "bahrain",
                    "url": "http:\/\/en.wikipedia.org\/wiki\/Bahrain_International_Circuit",
                    "circuitName": "Bahrain International Circuit",
                    "Location": {
                      "lat": "26.0325",
                      "long": "50.5106",
                      "locality": "Sakhir",
                      "country": "Bahrain"
                    }
                  },
                  "date": "2022-03-20",
                  "time": "15:00:00Z",
                  "FirstPractice": {
                    "date": "2022-03-18",
                    "time": "12:00:00Z"
                  },
                  "SecondPractice": {
                    "date": "2022-03-18",
                    "time": "15:00:00Z"
                  },
                  "ThirdPractice": {
                    "date": "2022-03-19",
                    "time": "12:00:00Z"
                  },
                  "Qualifying": {
                    "date": "2022-03-19",
                    "time": "15:00:00Z"
                  }
                },
                {
                  "season": "2022",
                  "round": "21",
                  "url": "http:\/\/en.wikipedia.org\/wiki\/2022_Brazilian_Grand_Prix",
                  "raceName": "Brazilian Grand Prix",
                  "Circuit": {
                    "circuitId": "interlagos",
                    "url": "http:\/\/en.wikipedia.org\/wiki\/Aut%C3%B3dromo_Jos%C3%A9_Carlos_Pace",
                    "circuitName": "Autódromo José Carlos Pace",
                    "Location": {
                      "lat": "-23.7036",
                      "long": "-46.6997",
                      "locality": "São Paulo",
                      "country": "Brazil"
                    }
                  },
                  "date": "2022-11-13",
                  "time": "18:00:00Z",
                  "FirstPractice": {
                    "date": "2022-11-11",
                    "time": "15:30:00Z"
                  },
                  "Qualifying": {
                    "date": "2022-11-11",
                    "time": "19:00:00Z"
                  },
                  "SecondPractice": {
                    "date": "2022-11-12",
                    "time": "15:30:00Z"
                  },
                  "Sprint": {
                    "date": "2022-11-12",
                    "time": "19:30:00Z"
                  }
                }
              ]
            }
          }
        }
    """.trimIndent()
}
