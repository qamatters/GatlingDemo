package simulation

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class SampleAPI_atOnceUsersScenario extends Simulation  {

  var randomeSymbol = simulation.helper.listOfSymbols()

  //http conf
  val httpconf = http.baseUrl("https://abc.com")
    .header("", value = "")


  //Scenarios
  val responseTimeValidation =  scenario("validate queryTime parameter")
    .exec(http(" API Response Validation" )
      .get("/v1/abc")
      .queryParam("filter", "abc")
      .check(status is 200)
//      .check(jsonPath("$.metadata.query_time").is("1"))
    )
  //setup
  setUp(responseTimeValidation.inject
    (atOnceUsers( 50),
//    rampUsers(10) during (5 seconds),
//    nothingFor(4 seconds),
//    constantUsersPerSec(20) during (15 seconds),
//    nothingFor(4 seconds),
//    constantUsersPerSec(20) during (15 seconds) randomized,
//    nothingFor(4 seconds),
//    rampUsersPerSec(10) to 20 during (4 minutes),
//    nothingFor(4 seconds),
//    rampUsersPerSec(10) to 20 during (4 minutes) randomized,
//    heavisideUsers(1000) during (20 seconds)
  ))
    .protocols(httpconf)
}