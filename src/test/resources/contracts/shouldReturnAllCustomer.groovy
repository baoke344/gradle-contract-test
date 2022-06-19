package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.MediaType

import java.net.http.HttpHeaders

Contract.make{
    description "Should return all customer"
    request {
        url "/customer"
        method GET()
    }
    response {
        status 200
        headers {
            header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        }
        body ([[id : 1, name:"Jane"], [id: 2, name:"Bin"]])
    }
}

