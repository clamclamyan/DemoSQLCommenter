package com.example.demo.controllers;

import com.example.demo.entities.DemoUser;
import com.example.demo.services.UserRepository;
import io.opencensus.trace.samplers.Samplers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateUserController {
  @Autowired private UserRepository userRepository;

  @Value("${spring.cloud.gcp.sql.instance-connection-name}")
  private String instanceConnection;

  private String projectName;

  @PostConstruct
  public void init() {
    Matcher matcher = Pattern.compile("^(.*?)(?=:)").matcher(instanceConnection);
    matcher.find();
    projectName = matcher.group();
  }

  @RequestMapping("/createUser")
  public String createUser() {
    return "createUser";
  }

  @RequestMapping(params = "opencensus", value = "/add", method = RequestMethod.POST)
  public ModelAndView addNewUserOpenCensus(
      @RequestParam(value = "nameInput") String name,
      @RequestParam(value = "emailInput") String email) {

    String traceId;

    // Start opencensus scope to append comments to mySQL query log
    io.opencensus.trace.Tracer tracer = io.opencensus.trace.Tracing.getTracer();
    try (io.opencensus.common.Scope ss =
        tracer.spanBuilder("cyan-DemoSpan").setSampler(Samplers.alwaysSample()).startScopedSpan()) {
      DemoUser n = new DemoUser();
      n.setName(name);
      n.setEmail(email);
      userRepository.save(n);

      traceId = tracer.getCurrentSpan().getContext().getTraceId().toLowerBase16();
    }

    ModelAndView modelAndView = new ModelAndView("userSaved");
    modelAndView.addObject("projectName", projectName).addObject("traceId", traceId);
    return modelAndView;
  }

  @RequestMapping(params = "opentelemetry", value = "/add", method = RequestMethod.POST)
  @ResponseBody
  public String addNewUserOpenTelemetry(
      @RequestParam(value = "nameInput") String name,
      @RequestParam(value = "emailInput") String email) {
    System.out.println(name + ' ' + email + " TODO");
    return "opentelemetry";
  }
}
