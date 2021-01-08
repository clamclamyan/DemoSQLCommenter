package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserRepository;
import io.opencensus.trace.samplers.Samplers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateUserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createUser")
    public String createUser() {
        return "createUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewUser(
            @RequestParam(value = "nameInput") String name,
            @RequestParam(value = "emailInput") String email) {

        // Start opencensus scope to append comments to mySQL query log
        io.opencensus.trace.Tracer tracer = io.opencensus.trace.Tracing.getTracer();
        try (io.opencensus.common.Scope ss = tracer.spanBuilder("DemoSpan").setSampler(Samplers.alwaysSample()).startScopedSpan()) {
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
        }

        return "userSaved";
    }
}
