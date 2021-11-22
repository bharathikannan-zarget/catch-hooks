package com.freshmarketer.catchhook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/hook")
public class CatchHookController {

    CatchHookService catchHookService;

    @Autowired
    public CatchHookController(CatchHookService catchHookService) {
        this.catchHookService = catchHookService;
    }

    @RequestMapping(value = "/json/{url}", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PATCH,
    RequestMethod.POST, RequestMethod.PUT}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ack> catchHook(@Valid @PathVariable("url") String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
        catchHookService.handle(url, request, response);
        return ResponseEntity.ok(new Ack(200, "success"));
    }

}
