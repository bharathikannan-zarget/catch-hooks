package com.freshmarketer.catchhook;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/view")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ViewController {

    private final CatchHookService catchHookService;


    @GetMapping("/{url}")
    public ResponseEntity<Page<Requests>> viewRequests(@Valid  @PathVariable String url, Pageable pageable) {
        return ResponseEntity.ok(catchHookService.findAll(url, pageable));
    }

}
