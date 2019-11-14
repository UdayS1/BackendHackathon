package com.mediaocean.bolt.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            return "STARTED";
        }

    }

    public List<String> instanceData(){
        List<String> active_vms=new ArrayList<>();
         List<WebElement> No_Instances;
        String[] Vms = {"NY-VPC-PRIS25", "NY-VPC-PRIS09",};
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\usawant\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");


        //ChromeDriver chromeDriver = new ChromeDriver(options);
        WebDriver d = new ChromeDriver(options);
        d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        d.manage().window().maximize();
        d.get("http://ny-vpc-pris03.na.rtdom.net:4494/grid/console");
        d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        List<WebElement> active = d.findElements(By.xpath("//p[@class=\"proxyid\"]"));

        int i = 0;

        for (i = 0; i < active.size(); i++) {

            String temp = active.get(i).getText();
            active_vms.add(temp.substring(12, 25));
            System.out.println(temp);
        }

        return active_vms;
//        int j = 0;
//        HashMap<String, Integer> Busy = new HashMap<>();
//        String busy = "//p[text()='id : http://%s:5568, OS : VISTA'] /parent::div//img[@class='busy']";
//        String sss;
//        int count=0;
//        System.out.println(active_vms.size());
//        for (int k=0;k<active_vms.size();k++){
//            count=0;
//            try {
//                sss = busy.replace("%s", active_vms.get(k));
//                if (d.findElements(By.xpath(sss)).size() != 0) {
//                    No_Instances = d.findElements(By.xpath(sss));
//                    count=No_Instances.size();
//                }
//                Busy.put(active_vms.get(k), count);
//                System.out.println("Name" + active_vms.get(k) + "No of Active Instances :" + count);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//        return Busy;
    }
    public String stopVM(String node_name){

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name+" -accepteula -s -u DDS-NA\\qaadmin -p qatest cmd /c \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\StopNode.bat");

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


     return "STOPPED";
    }
    public String cleanMemoryVM(String node_name){

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name+" -accepteula -s -u DDS-NA\\qaadmin -p qatest cmd /c \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\cleanup.bat");

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


        return "VM memory cleared";
    }

    public String restartVm(String node_name){
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/C", "cd \"C:\\PSTools\" && PsExec.exe \\\\"+node_name+" -accepteula -u DDS-NA\\qaadmin -p qatest -s -i 2 -d \\\\ny-vpc-sgrid.na.rtdom.net\\GRID_BINARIES\\restart.bat");


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


        return "VM memory cleared";

    }
}
