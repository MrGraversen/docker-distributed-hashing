package io.graversen.distributed.hashing.worker.app.api;

import io.graversen.distributed.hashing.worker.app.model.HashingRequest;
import io.graversen.distributed.hashing.worker.app.model.HashingResult;
import io.graversen.distributed.hashing.worker.app.service.HashingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class HashingController
{
    private static final String SERVED_BY_HEADER = "X-Served-By";

    private final String instanceId;
    private final HashingService hashingService;

    @PostMapping("{algorithm}")
    public ResponseEntity<HashingResult> getHashValue(HttpServletResponse response, @PathVariable String algorithm, @RequestBody HashingRequest hashingRequest)
    {
        final HashingResult hashingResult = hashingService.computeHashingResult(algorithm, hashingRequest.getPlainText(), hashingRequest.getRounds());
        response.setHeader(SERVED_BY_HEADER, instanceId);

        return ResponseEntity.ok(hashingResult);
    }
}