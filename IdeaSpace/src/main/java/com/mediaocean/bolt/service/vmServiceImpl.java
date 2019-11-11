package com.mediaocean.bolt.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class vmServiceImpl {
String all_vms="NY-VPC-PRIS02,NY-VPC-PRIS04,NY-VPC-PRIS07,NY-VPC-PRIS08,NY-VPC-PRIS09,NY-VPC-PRIS10,NY-VPC-PRIS11,NY-VPC-PRIS12,NY-VPC-PRIS13,NY-VPC-PRIS14,NY-VPC-PRIS15,NY-VPC-PRIS16,NY-VPC-PRIS17,NY-VPC-PRIS18,NY-VPC-PRIS23,NY-VPC-PRIS24,NY-VPC-PRIS25,NY-VPC-PRIS26,NY-VPC-PRIS27";
    public String startAllVMs(){
      /*  ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+all_vms +" -accepteula -u DDS-NA\\qaadmin -p qatest -s -i 2 -d \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\starttemp.bat");

        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
       return "All VMs started";
    }

    public String stopAllVMs()
    {
        /*ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+all_vms +"-accepteula -s -u DDS-NA\\qaadmin -p qatest cmd /c \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\StopNode.bat");

        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

     return "All VMs stoppped";
    }
    public String startVM(String node_name)
    {
        System.out.println(node_name);
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name+" -accepteula -u DDS-NA\\qaadmin -p qatest -s -i 2 -d \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\starttemp.bat");

        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
            return "VM started";
        } catch (Exception e) {
            e.printStackTrace();
            return "VM not started";
        }

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
