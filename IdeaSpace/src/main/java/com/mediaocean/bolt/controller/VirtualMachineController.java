package com.mediaocean.bolt.controller;

import com.mediaocean.bolt.service.vmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = { "/vm" })
public class VirtualMachineController {

    @Autowired
    private vmServiceImpl service;

    @GetMapping(value = "/start")
    public String startVMs() {
        return service.startVM();
    }

    @GetMapping(value = "/stop")
    public String stopVMs() {
        return service.stopVM();
    }

    @GetMapping(value = "/startAll")
    public String startAllVMs() {
        return service.startAllVMs();
    }

    @GetMapping(value = "/stopAll")
    public String stopAllVMs() {
        return service.stopAllVMs();
    }
}
