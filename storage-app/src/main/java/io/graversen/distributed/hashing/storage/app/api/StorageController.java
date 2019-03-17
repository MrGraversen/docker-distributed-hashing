package io.graversen.distributed.hashing.storage.app.api;

import io.graversen.distributed.hashing.storage.app.model.HashingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController
{
    @PostMapping("{algorithm}")
    public ResponseEntity<Void> storeHashingResult(@RequestBody HashingResult hashingResult, @PathVariable String algorithm)
    {
        System.out.println(hashingResult);
        return ResponseEntity.ok().build();
    }
}
