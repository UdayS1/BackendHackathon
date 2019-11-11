package com.mediaocean.bolt.controller;

import com.mediaocean.bolt.service.vmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = { "/vm" })
public class VirtualMachineController {

    @Autowired
    private vmServiceImpl service;

    @GetMapping(value = "/start")
    public String startVMs(@RequestParam String nodeName) {
        return service.startVM(nodeName);
    }

    @GetMapping(value = "/stop")
    public String stopVMs(@RequestParam String nodeName) {
        return service.stopVM(nodeName);
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
