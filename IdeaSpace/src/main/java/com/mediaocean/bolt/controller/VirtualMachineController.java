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

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = { "/vm" })
public class VirtualMachineController {

    @Autowired
    private vmServiceImpl service;

    @GetMapping(value = "/instanceData")
    public List<String> initialInformation(){
        return service.instanceData();
    }
    @GetMapping(value = "/start")
    public String startVM(@RequestParam String nodeName) {
        return service.startVM(nodeName);
    }

    @GetMapping(value = "/restart")
    public String restartVM(@RequestParam String nodeName) {
        return service.restartVm(nodeName);
    }

    @GetMapping(value = "/stop")
    public String stopVM(@RequestParam String nodeName) {
        return service.stopVM(nodeName);
    }

    @GetMapping(value = "/cleanMemory")
    public String cleanMemoryVM(@RequestParam String nodeName) {
        return service.cleanMemoryVM(nodeName);
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
