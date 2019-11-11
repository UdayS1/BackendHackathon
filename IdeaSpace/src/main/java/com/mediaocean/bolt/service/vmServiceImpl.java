package com.mediaocean.bolt.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class vmServiceImpl {

    public String startAllVMs(){
       return "All VMs started";
    }

    public String stopAllVMs(){
     return "All VMs stoppped";
    }
    public String startVM(String node_name)
    {
        ProcessBuilder builder = new ProcessBuilder(    
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name +" -accepteula -u DDS-NA\\qaadmin -p qatest -s -i 2 -d \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\starttemp.bat");

        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
     return "VM started";
    }
    public String stopVM(String node_name){

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name +"-accepteula -s -u DDS-NA\\qaadmin -p qatest cmd /c \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\StopNode.bat");

        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }


     return "VM stopped";
    }
}
