package com.fhec.views.Actions;

import static com.fhec.app.AppStart.pcname;

import java.io.File;

import javax.swing.JOptionPane;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.utils.FileUtils;
import com.fhec.views.ProgressBarUploadView;

/**
 * uilog上传
 * @author Archer
 */
public class UiLogUploadServer {
    public static void UiuploadServer() throws Exception {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

        //log
        FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
        //服务器
        String server_ui = envConFigConfig.getMainPath().getServer_dlog_path() + GlobalContext.UI_message + File.separator + pcname;

        /* 判断路径是否存在 */
        ftp.doAction(new FtpClient.IAction() {
            @Override
            public void doAction(FtpClient ftpClient) {
                try {
                    Boolean ui = ftp.existDirectory("/"+GlobalContext.UI_message, pcname);
                    System.out.println(ui);
                    //存在
                    if (!ui) {
                        ftp.createDirecroty(server_ui);
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //本地
        String local_uiog_path = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.UI_message + File.separator + pcname;
        //遍历文件夹
        String[] fileList = new File(local_uiog_path).list();
        for (int i = 0; i < fileList.length; i++) {
            int finalI = i;
            try {
                FtpClient ftp2 = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
                ftp2.doAction(new FtpClient.IAction() {
                    @Override
                    public void doAction(FtpClient ftpClient) {
                        try {
                            ProgressBarUploadView.getText("");
                            ftp2.uploadFile(server_ui, fileList[finalI], new File(local_uiog_path + File.separatorChar + fileList[finalI]));
                            ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
                            Log.info("上传" + fileList[finalI] + "文件成功");
                            Log.info("网络存在");
                        }catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
 
        }

    }
}
