
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Nes extends Simulation {

	val httpProtocol = http
		.baseUrl("https://qa1-lsegxmr.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Mobile Safari/537.36")

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"cache-control" -> "max-age=0",
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

	val headers_5 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"product" -> "mrs",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

	val headers_6 = Map(
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

	val scn = scenario("Nes")
		.exec(http("request_0:POST_https://xmr-dev-env01.auth.eu-west-2.amazoncognito.com/login?client_id=5qk4k9a8dq1krnkrvije6scth2&redirect_uri=https_3A_2F_2Fqa1-lsegxmr.com_2Foauth2_2Fidpresponse&response_type=code&scope=openid&state=_2B4TDVwqtujDGziIb4sa0hEZguFI82cRtvU7pxvMgzHHvvGMiY77PDmwW98P_2BHRESddhtLaxUZqdvF_2FE1vlnY_2FbuoeqpPaNgmM_2BlETwjilXeIAqN43WyBowMZJUlaojT6ITweH1wa8PSRI4oJUxB006CbxFsRis41fB6Z_2FhHyzXf1H9U_2BCVeTc6yCJfuDPsLe7iWRDSOwLWuD7Lc_3D")
			.post(uri1 + "?client_id=5qk4k9a8dq1krnkrvije6scth2&redirect_uri=https%3A%2F%2Fqa1-lsegxmr.com%2Foauth2%2Fidpresponse&response_type=code&scope=openid&state=%2B4TDVwqtujDGziIb4sa0hEZguFI82cRtvU7pxvMgzHHvvGMiY77PDmwW98P%2BHRESddhtLaxUZqdvF%2FE1vlnY%2FbuoeqpPaNgmM%2BlETwjilXeIAqN43WyBowMZJUlaojT6ITweH1wa8PSRI4oJUxB006CbxFsRis41fB6Z%2FhHyzXf1H9U%2BCVeTc6yCJfuDPsLe7iWRDSOwLWuD7Lc%3D")
			.headers(headers_0)
			.formParam("_csrf", "91d4914a-2d50-4371-9489-4d408c7fe895")
			.formParam("username", "ospasibo")
			.formParam("password", "London1234!")
			.formParam("cognitoAsfData", "eyJwYXlsb2FkIjoie1wiY29udGV4dERhdGFcIjp7XCJVc2VyQWdlbnRcIjpcIk1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNlwiLFwiRGV2aWNlSWRcIjpcImgyaTdqMmV5NmVnMjlhZjRqMHV5OjE2MDUyNTU1OTA4NzZcIixcIkRldmljZUxhbmd1YWdlXCI6XCJydS1SVVwiLFwiRGV2aWNlRmluZ2VycHJpbnRcIjpcIk1vemlsbGEvNS4wIChMaW51eDsgQW5kcm9pZCA2LjA7IE5leHVzIDUgQnVpbGQvTVJBNThOKSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvODYuMC40MjQwLjE5OCBNb2JpbGUgU2FmYXJpLzUzNy4zNnJ1LVJVXCIsXCJEZXZpY2VQbGF0Zm9ybVwiOlwiTWFjSW50ZWxcIixcIkNsaWVudFRpbWV6b25lXCI6XCIwMDowMFwifSxcInVzZXJuYW1lXCI6XCJvc3Bhc2lib1wiLFwidXNlclBvb2xJZFwiOlwiXCIsXCJ0aW1lc3RhbXBcIjpcIjE2MDU5NzY5MTY5NzVcIn0iLCJzaWduYXR1cmUiOiIySDdLZkJUVGFhNjdtYlg1aXE2dDM2UFRIK2lYV1UyWGRzaUdkVVlXL1pnPSIsInZlcnNpb24iOiJKUzIwMTcxMTE1In0=")
			.formParam("signInSubmitButton", "Sign in")
			.check(bodyString.saveAs("Auth_Response")))
		.exec( session => {
			scala.tools.nsc.io.File("../user-files/resources/log.txt").appendAll(session("Auth_Response").as[String]+"\n")
			session}
		)
		.pause(1)
		.exec(http("request_1:GET_https://qa1-lsegxmr.com/mrs/meta_info/version.json")
			.get("/mrs/meta_info/version.json")
			.headers(headers_1)
			.resources(http("request_2:GET_https://fonts.googleapis.com/css?family=Roboto_Mono:400_700_Roboto:400_300_300italic_400italic_500_500italic_700_700italic")
			.get(uri3 + "?family=Roboto+Mono:400,700|Roboto:400,300,300italic,400italic,500,500italic,700,700italic")
			.headers(headers_2)
			.check(bodyBytes.is(RawFileBody("/nes/0002_response.css"))),
            http("request_3:GET_https://qa1-lsegxmr.com/mrs/data/connection.json")
			.get("/mrs/data/connection.json")
			.headers(headers_3)
			.check(status.is(404))
			.check(bodyBytes.is(RawFileBody("/nes/0003_response.html"))),
            http("request_4:GET_https://qa1-lsegxmr.com/mrs/manifest.json")
			.get("/mrs/manifest.json")
			.headers(headers_1),
            http("request_5:GET_https://qa1-lsegxmr.com/user_info")
			.get("/user_info")
			.headers(headers_5),
            http("request_6:GET_https://qa1-lsegxmr.com/api/config/configs/system")
			.get("/api/config/configs/system")
			.headers(headers_6)
			.check(bodyBytes.is(RawFileBody("/nes/0006_response.json"))),
            http("request_7:GET_https://qa1-lsegxmr.com/api/config/configs/widget")
			.get("/api/config/configs/widget")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/nes/0007_response.json"))),
            http("request_8:GET_https://qa1-lsegxmr.com/api/config/configs/getAllUserProfileNames")
			.get("/api/config/configs/getAllUserProfileNames")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/nes/0008_response.json"))),
            http("request_9:GET_https://qa1-lsegxmr.com/api/config/configs/getPref")
			.get("/api/config/configs/getPref")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/nes/0009_response.json"))),
            http("request_10:GET_https://qa1-lsegxmr.com/api/refd/enums")
			.get("/api/refd/enums")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/nes/0010_response.json"))),
            http("request_11:GET_https://qa1-lsegxmr.com/mrs/data/system.json")
			.get("/mrs/data/system.json")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/nes/0011_response.json"))))
			.check(bodyBytes.is(RawFileBody("/Users/olgaspasibo/Downloads/gatling-charts-highcharts-bundle-3.4-2.1/user-files/resources/nes/0001_response.json"))))
		.pause(8)
		.exec(http("request_12:GET_https://qa1-lsegxmr.com/eventbus/info?t=1605976935200")
			.get("/eventbus/info?t=1605976935200")
			.headers(headers_1)
			.check(bodyBytes.is(RawFileBody("/Users/olgaspasibo/Downloads/gatling-charts-highcharts-bundle-3.4-2.1/user-files/resources/nes/0001_response.json"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}