//package logon_mrs

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LogonSimulation_original extends Simulation {

  val httpProtocol = http
    .baseUrl("https://qa1-lsegxmr.com/mrs")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .warmUp("https://qa1-lsegxmr.com/mrs")
    .wsBaseUrl("https://qa1-lsegxmr.com/mrs")

 val csvfeed = csv("users.csv")
 val logonstring = """{"user_id":"${username}","password":"${password}"}"""
 val encodelogonstring = java.util.Base64.getEncoder.encode(logonstring.getBytes())

  val scn = scenario("Logon to MRS")
    .feed(csvfeed)
    .exec(http("Open Main Page")
      .get("/"))
    .exec(http("Login")
      .get("/")
			.header("authorization" , "Basic ${encodelogonstring}")
			.check(jsonPath("$..token").exists.saveAs("token")))
     .exec(
  	polling
    	.every(5 seconds)
    	.exec(http("HB").get("/heartbeat").header("authorization","Bearer ${token}"))
)
     	.exec(ws("1").connect("/"))
	.exec(ws("2").connect("/"))
	.exec(ws("3").connect("/"))
	.exec(ws("4").connect("/"))
	.exec(ws("5").connect("/"))
	.exec(ws("6").connect("/"))
        .exec(ws("7").connect("/"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
