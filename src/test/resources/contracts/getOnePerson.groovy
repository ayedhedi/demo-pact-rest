import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a person with id"
    request{
        method GET()
        url("/persons/1") {}
    }
    response {
        body("{\"id\":1,\"name\":\"one\",\"age\":2}")
        status 200
    }
}