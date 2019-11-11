package com.mediaocean.bolt.service;

import org.springframework.stereotype.Service;

@Service
public class vmServiceImpl {

    public String startAllVMs(){
       return "All VMs started";
    }

    public String stopAllVMs(){
     return "All VMs stoppped";
    }
    public String startVM(){
     return "VM started";
    }
    public String stopVM(){
     return "VM stopped";
    }
}
