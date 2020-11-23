//package logon_mrs

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class LogonSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("https://qa1-lsegxmr.com/mrs")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .warmUp("https://qa1-lsegxmr.com/mrs")
    .wsBaseUrl("https://qa1-lsegxmr.com/mrs")

 //val csvFeeder = csv("users.csv")

 //val logonstring = """{"user_id":"${username}","password":"${password}"}"""
 //val logonstring = """{"user_id":"ospasibo","password":"London1234!"}"""
 //val encodelogonstring = java.util.Base64.getEncoder.encode(logonstring.getBytes())


  val scn = scenario("Logon to MRS")
	//.feed(csvFeeder)
		.exec( session => session.set( "logonstring", """{"user_id":"ospasibo","password":"London1234!"}""" ))
		.exec( session => session.set( "encodelogonstring", java.util.Base64.getEncoder.encode("${logonstring}".getBytes())))
    .exec(http("Open Main Page")
      .get("/"))
    .exec(http("Login")
      .get("/").basicAuth("ospasibo", "London1234!")
			.formParam("_csrf", "3068e300-0aee-4d9b-9e16-5188ed3de652")
	    .formParam("username", "ospasibo")
		  .formParam("password", "London1234!")
		  .formParam("cognitoAsfData", "eyJwYXlsb2FkIjoie1wiY29udGV4dERhdGFcIjp7XCJVc2VyQWdlbnRcIjpcIk1vemlsbGEvNS4wICh" +
				"MaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKS" +
				"BDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNlwiLFwiRGV2aWNlSWRcIjpcImgyaTdqMmV5NmVnMjlhZjRqMHV5O" +
				"jE2MDUyNTU1OTA4NzZcIixcIkRldmljZUxhbmd1YWdlXCI6XCJydS1SVVwiLFwiRGV2aWNlRmluZ2VycHJpbnRcIjpcIk1vemlsbGEvNS4w" +
				"IChMaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2t" +
				"vKSBDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNnJ1LVJVXCIsXCJEZXZpY2VQbGF0Zm9ybVwiOlwiTWFjSW50ZW" +
				"xcIixcIkNsaWVudFRpbWV6b25lXCI6XCIwMDowMFwifSxcInVzZXJuYW1lXCI6XCJvc3Bhc2lib1wiLFwidXNlclBvb2xJZFwiOlwiXCIsX" +
				"CJ0aW1lc3RhbXBcIjpcIjE2MDU5NzYzMzcyMzdcIn0iLCJzaWduYXR1cmUiOiI4ZjRkMUpQYUFBQW9ZYW54TEY0bGNheDlPM3BlSW1jTGJX" +
				"YlpDekNzc09vPSIsInZlcnNpb24iOiJKUzIwMTcxMTE1In0=")
	    .formParam("signInSubmitButton", "Sign in")
			//header("authorization" , "Basic ${encodelogonstring}")
			.check(jsonPath("$..token").saveAs("token"))
			.check(bodyString.saveAs("Auth_Response")))
		.exec( session => {
			scala.tools.nsc.io.File("../user-files/resources/log.txt").appendAll(session("Auth_Response").as[String]+"\n")
			session}
		)
//     .exec(
//  	polling
//    	.every(5 seconds)
//    	.exec(http("HB").get("/heartbeat").header("authorization","Bearer ${token}"))
//)
//     	.exec(ws("1").connect("/"))
//	.exec(ws("2").connect("/"))
//	.exec(ws("3").connect("/"))
//	.exec(ws("4").connect("/"))
//	.exec(ws("5").connect("/"))
//	.exec(ws("6").connect("/"))
//        .exec(ws("7").connect("/"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
