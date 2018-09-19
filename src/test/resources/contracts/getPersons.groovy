import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return list of persons"
    request{
        method GET()
        url("/persons") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("[{\"id\":0,\"name\":\"stub\",\"age\":22}]")
        status 200
    }
}
