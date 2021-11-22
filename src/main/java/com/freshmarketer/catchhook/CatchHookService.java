package com.freshmarketer.catchhook;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CatchHookService {

    void handle(String url, HttpServletRequest request, HttpServletResponse response) throws IOException;

    Page<Requests> findAll(String url, Pageable pageable);

}
