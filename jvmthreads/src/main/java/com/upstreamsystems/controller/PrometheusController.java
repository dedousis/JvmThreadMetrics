package com.upstreamsystems.controller;

import com.sun.net.httpserver.HttpServer;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.util.Date;

@RestController
@RequestMapping("/prometheus")
public class PrometheusController {

    PrometheusMeterRegistry prometheusRegistry;

    @PostConstruct
    public void init() {
        prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        new JvmThreadMetrics().bindTo(prometheusRegistry);
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String scrape()  {

        return prometheusRegistry.scrape();
    }


    @RequestMapping("/prometheus")
    @ResponseStatus(HttpStatus.OK)
    public String prometheus() {
        return prometheusRegistry.scrape();

    }
}


