package com.freshmarketer.catchhook;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JSONHookService implements CatchHookService {

    private final FileUtil fileUtil;

    private final RequestsRepository requestsRepository;


    /**
     * id
     * url
     * headers
     * query_string
     * form_values
     * raw_content
     * created_at
     *
     *
     * @param request
     * @param response
     */

    @Override
    public void handle(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestMethod = request.getMethod().toUpperCase(Locale.ROOT);
        String requestBody = fileUtil.readAll(request.getInputStream());
        String queryStr = request.getQueryString();

        //headers
        Map<String, Object> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String[] values = Collections.list(request.getHeaders(header)).toArray(new String[0]);
            headers.put(header, values);
        }

        Requests requests = new Requests();
        requests.setHeaders(headers);
        requests.setRequestMethod(requestMethod);
        requests.setFormValues(null);
        requests.setQueryString(queryStr);
        requests.setRawContent(requestBody);
        requests.setUrl(url);

        requestsRepository.save(requests);

    }

    @Override
    public Page<Requests> findAll(String url, Pageable pageable) {
        return requestsRepository.findAllByUrl(url, pageable);
    }

}
