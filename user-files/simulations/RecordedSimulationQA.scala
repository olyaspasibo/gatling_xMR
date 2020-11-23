
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulationQA extends Simulation {

	val httpProtocol = http
		.baseUrl("https://qa1-lsegxmr.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Mobile Safari/537.36")

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"origin" -> "https://xmr-dev-env01.auth.eu-west-2.amazoncognito.com",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

	val headers_2 = Map("Origin" -> "https://qa1-lsegxmr.com")

	val headers_3 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"content-type" -> "application/json",
		"product" -> "mrs",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

	val headers_4 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"origin" -> "https://qa1-lsegxmr.com",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site",
		"x-client-data" -> "CIy2yQEIorbJAQjEtskBCImSygEIqZ3KAQirx8oBCPbHygEI6cjKAQjc1coBCJiaywEIwZrLARiLwcoB")

	val headers_6 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"product" -> "mrs",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

	val headers_12 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"content-type" -> "application/json",
		"is_front_end" -> "true",
		"product" -> "mrs",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

    val uri1 = "https://xmr-dev-env01.auth.eu-west-2.amazoncognito.com/login"
    val uri3 = "https://fonts.googleapis.com/css"

	val scn = scenario("RecordedSimulationQA")
		.exec(http("request_0")
			.post(uri1 + "?client_id=5qk4k9a8dq1krnkrvije6scth2&redirect_uri=https%3A%2F%2Fqa1-lsegxmr.com%2Foauth2%2Fidpresponse&response_type=code&scope=openid&state=tVXlwdBstWoXebphKazCfTKjSxGGQMRuHRgldll5pIOaGLTw1Ikk0FFp8tbIRQHuWwL6UPE8OCt4yKsVcZ%2F4mibK4u80lxOZBVj6ru6xD06zlIKpB7rBLno9%2FtwK37yd5mvlitxTPJH6Tg7LOnwZOW7KiCkqpFoL8pp7TF82RtBkYObZgsIZhd9y2O1n0%2FIyJKQx5Ocg3MMJLVo%3D")
			.headers(headers_0)
			.formParam("_csrf", "9a3d54c3-cc0f-48fb-b30d-67d781adbfa3")
			.formParam("username", "ospasibo")
			.formParam("password", "London1234!")
			.formParam("cognitoAsfData", "eyJwYXlsb2FkIjoie1wiY29udGV4dERhdGFcIjp7XCJVc2VyQWdlbnRcIjpcIk1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNlwiLFwiRGV2aWNlSWRcIjpcImgyaTdqMmV5NmVnMjlhZjRqMHV5OjE2MDUyNTU1OTA4NzZcIixcIkRldmljZUxhbmd1YWdlXCI6XCJydS1SVVwiLFwiRGV2aWNlRmluZ2VycHJpbnRcIjpcIk1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNnJ1LVJVXCIsXCJEZXZpY2VQbGF0Zm9ybVwiOlwiTWFjSW50ZWxcIixcIkNsaWVudFRpbWV6b25lXCI6XCItMDE6MDBcIn0sXCJ1c2VybmFtZVwiOlwib3NwYXNpYm9cIixcInVzZXJQb29sSWRcIjpcIlwiLFwidGltZXN0YW1wXCI6XCIxNjA1NTI4OTUyMjcwXCJ9Iiwic2lnbmF0dXJlIjoiZHNqNXU2KzJSYVo3REhPMDNManZyMmpaWlVhalBKdk10RTlOU01vdVM3ST0iLCJ2ZXJzaW9uIjoiSlMyMDE3MTExNSJ9")
			.formParam("signInSubmitButton", "Sign in")
			.resources(http("request_1")
			.get("/mrs/meta_info/version.json")
			.headers(headers_1),
            http("request_2")
			.get(uri3 + "?family=Roboto+Mono:400,700|Roboto:400,300,300italic,400italic,500,500italic,700,700italic")
			.headers(headers_2),
            http("request_3")
			.get("/mrs/data/connection.json")
			.headers(headers_3)
			.check(status.is(404)),
            http("request_4")
			.get(uri3 + "?family=Roboto+Mono:400,700|Roboto:400,300,300italic,400italic,500,500italic,700,700italic")
			.headers(headers_4),
            http("request_5")
			.get("/mrs/manifest.json")
			.headers(headers_1),
            http("request_6")
			.get("/user_info")
			.headers(headers_6),
            http("request_7")
			.get("/api/refd/enums")
			.headers(headers_3),
            http("request_8")
			.get("/mrs/data/system.json")
			.headers(headers_3),
            http("request_9")
			.get("/api/config/configs/getAllUserProfileNames")
			.headers(headers_3),
            http("request_10")
			.get("/api/config/configs/getPref")
			.headers(headers_3),
            http("request_11")
			.get("/api/config/configs/widget")
			.headers(headers_3),
            http("request_12")
			.get("/api/config/configs/system")
			.headers(headers_12)))
		.pause(6)
		.exec(http("request_13")
			.get("/eventbus/info?t=1605528962623")
			.headers(headers_1))
		.pause(4)
		.exec(http("request_14")
			.get("/api/refd/instrument?key=L")
			.headers(headers_3)
			.resources(http("request_15")
			.get("/api/refd/instrument?key=LS")
			.headers(headers_3),
            http("request_16")
			.get("/api/refd/instrument?key=LSE")
			.headers(headers_3)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}