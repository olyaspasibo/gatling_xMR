//package MRS

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class OpenMrs extends Simulation {

  // Configuration
  val httpConf = http
    .baseUrl("https://qa1-lsegxmr.com/mrs")
    

  // Scenario
  val scn = scenario("Open MRS")
    .exec(http("Open Main Page")
      .get("/")
    )
    

  // Load
  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))


}

