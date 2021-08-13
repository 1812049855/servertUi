package com.fhec.context;

import com.fhec.config.ini.INISection;
import com.fhec.config.ini.INISectionNode;

public class FtpmodeConfig {
    public final static String GROUPNAME_SERVER_PGM_FTPMODE = "server_pgm_ftpmode";

    @INISection(name = GROUPNAME_SERVER_PGM_FTPMODE,isRequired = false)
    private ServerPgmFtpmode serverpgmftpmode;

    public ServerPgmFtpmode getServerpgmftpmode() {
        return serverpgmftpmode;
    }

    public void setServerpgmftpmode(ServerPgmFtpmode serverpgmftpmode) {
        this.serverpgmftpmode = serverpgmftpmode;
    }

    public static class ServerPgmFtpmode{
        public final static String NAME_SERVER_PGM_FTPMODE = "server_pgm_ftpmode";

        public String getServer_pgm_ftpmode() {
            return server_pgm_ftpmode;
        }

        public void setServer_pgm_ftpmode(String server_pgm_ftpmode) {
            this.server_pgm_ftpmode = server_pgm_ftpmode;
        }

        @INISectionNode(name = NAME_SERVER_PGM_FTPMODE,isRequired = false)
        private String server_pgm_ftpmode;
    }
}
