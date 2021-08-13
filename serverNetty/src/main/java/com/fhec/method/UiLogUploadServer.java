package com.fhec.method;

import java.io.File;

import javax.swing.JOptionPane;

import com.esotericsoftware.minlog.Log;
import com.fhec.context.EnvConFigConfig;
import com.fhec.entity.EntityVo;
import com.fhec.ftp.FtpClient;

import io.netty.channel.ChannelHandlerContext;


/**
 * uilog上传
 * @author Archer
 */
public class UiLogUploadServer {
    private EntityVo entityVo;

    private ChannelHandlerContext channelHandlerContext;
    public UiLogUploadServer(EntityVo entityVo,ChannelHandlerContext channelHandlerContext) {
        this.entityVo = entityVo;
        this.channelHandlerContext=channelHandlerContext;
    }

    public UiLogUploadServer() {
    }

    public  void UiuploadServer() throws Exception {
        EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
			
        //log
       FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
        //服务器
        String server_ui = envConFigConfig.getMainPath().getServer_dlog_path() + EntityVo.UI_message + File.separator + entityVo.getPaname();

        /* 判断路径是否存在 */
        ftp.doAction(new FtpClient.IAction() {
            @Override
            public void doAction(FtpClient ftpClient) {
                try {
                    Boolean ui = ftp.existDirectory("/"+ EntityVo.UI_message,entityVo.getPaname());
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
        String local_uiog_path = envConFigConfig.getMainPath().getLocal_dlog_path() +EntityVo.UI_message + File.separator + entityVo.getPaname();
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
                          //  ProgressBarUploadView.getText("");
                            ftp2.uploadFile(server_ui, fileList[finalI], new File(local_uiog_path + File.separatorChar + fileList[finalI]),entityVo,channelHandlerContext);
                         //   ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
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
