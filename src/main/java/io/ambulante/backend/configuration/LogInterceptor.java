package io.ambulante.backend.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final String TIMESTAMP_ATTRIBUTE = "internal-timestamp";
    private static final String UNAUTHENTICATED = "unauthenticated";

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        request.setAttribute(TIMESTAMP_ATTRIBUTE, System.currentTimeMillis());
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
                && request.getMethod().equals(HttpMethod.GET.name())) {
            logRequest(request);
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
        logResponse(request, (Long) request.getAttribute(TIMESTAMP_ATTRIBUTE), response.getStatus());
    }

    private static void logRequest(HttpServletRequest request) {
        log.info("Request {} {}{} - IP {} - User {}",
                 request.getMethod(),
                 request.getRequestURI(),
                 extractUriSuffix(request),
                 request.getRemoteAddr(),
                 UNAUTHENTICATED);
    }

    private static void logResponse(HttpServletRequest request, long requestStartTimestamp, int status) {
        var durationMillis = System.currentTimeMillis() - requestStartTimestamp;
        log.info("Response {} {}{} (Elapsed {} ms) - {} ({}) - IP {} - User {}",
                 request.getMethod(),
                 request.getRequestURI(),
                 extractUriSuffix(request),
                 durationMillis,
                 status,
                 Optional.ofNullable(HttpStatus.resolve(status))
                         .map(HttpStatus::getReasonPhrase)
                         .orElse("Unknown status code"), request
                         .getRemoteAddr(), UNAUTHENTICATED);
    }

    private static String extractUriSuffix(HttpServletRequest request) {
        return StringUtils.hasText(request.getQueryString()) ? "?" + request.getQueryString() : "";
    }
}
