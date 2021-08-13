package com.fhec.context;


/**
 * @author Archer.W
 * @date 2021/04/16 14:22
 **/
public class FtpmodeConfig  {

    private ServerPgmFtpmode serverpgmftpmode;

    public ServerPgmFtpmode getServerpgmftpmode() {
        return serverpgmftpmode;
    }

    public void setServerpgmftpmode(ServerPgmFtpmode serverpgmftpmode) {
        this.serverpgmftpmode = serverpgmftpmode;
    }

    public static class ServerPgmFtpmode {

        private String server_pgm_ftpmode;

        public String getServer_pgm_ftpmode() {
            return server_pgm_ftpmode;
        }

        public void setServer_pgm_ftpmode(String server_pgm_ftpmode) {
            this.server_pgm_ftpmode = server_pgm_ftpmode;
        }
    }
}
