//package mrsLogon
//package logon_mrs

//import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
//import scala.concurrent.duration._

class LogonToMrs extends Simulation {

  // Configuration
  val httpConf = http
    .baseUrl("https://qa1-lsegxmr.com/mrs")
    //.acceptHeader()

  val csvfeed = csv("users.csv")

  val logonstring = """{"user_id":"${username}","password":"${password}"}"""
  val encodelogonstring = java.util.Base64.getEncoder.encode(logonstring.getBytes())


  // Scenario
  val scn = scenario("Logon to MRS")
    .feed(csvfeed)
//    .exec{
//      session =>
//        println(session("logonstring").as[String])
//        session
//    }
//    .exec{
//      session =>
//        println(session("encodelogonstring").as[String])
//        session
//    }
    .exec(http("Open Main Page")
      .get("/"))
    .exec(http("Login")
      .get("/").header("authorization" , "Basic ${encodelogonstring}")
      .check(jsonPath("$..token").exists.saveAs("token")))

  // Load
  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))


}

