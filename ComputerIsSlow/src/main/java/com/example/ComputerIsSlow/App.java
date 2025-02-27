package com.example.ComputerIsSlow;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void Timer_main(  )
    {
       
        // 創建 Timer 物件
        Timer timer = new Timer();

        // 創建 TimerTask 物件，這是實際要執行的任務
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	
            
                System.out.println("執行定時任務：" + System.currentTimeMillis());
                
                System.out.println( "Hello World!" );
                System.gc();
                System.out.println("垃圾回收已經被觸發!");
                try {
                    // 執行 Windows 的清理磁碟命令 (例如清理磁碟)
                    Process process = Runtime.getRuntime().exec("cmd /c chkdsk C: /f");
                    process.waitFor();
                    System.out.println("Windows 磁碟快取已清理！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    // 在 Windows 系統上執行重新整理桌面的命令
                    Runtime.getRuntime().exec("cmd /c explorer.exe /select,\"C:\\\"");
                    System.out.println("桌面已重新整理！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
                
            }
        };

        // 設置定時任務，從當前時間起，每隔 3 秒執行一次
        timer.scheduleAtFixedRate(task, 0, 1000);
        
    	String NUM[]= {"執行定時任務：" + 1,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！",
    			"執行定時任務：" + 2,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！",
    			"執行定時任務：" + 3,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！",
    			"執行定時任務：" + 4,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！",
    			"執行定時任務：" + 5,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！",
    			"執行定時任務：" +6,"Windows 磁碟快取已清理！","垃圾回收已經被觸發!","桌面已重新整理！","依此類推直到關閉整個程序視窗才算"};
        Window.main(NUM);
    }
}
