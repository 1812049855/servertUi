package com.fhec.Thread;

import com.fhec.mainstatus.MainStatus;
import com.fhec.views.MESDownloadView;
import com.fhec.views.Actions.MesDownLoadZipAction;
import com.fhec.views.Actions.MesRecipeAction;

public class MesDownLoadZip implements Runnable{

	MesDownLoadZipAction bs;
	private MESDownloadView window;
	public MesDownLoadZip(MesDownLoadZipAction bs,MESDownloadView window) {
		this.bs=bs;
		this.window=window;
	}
	@Override
	public void run() {
		startDownLoad();
	}
	
	public void startDownLoad() {
		 try {
           boolean downLoadMesZip = bs.downLoadMesZip();
           if (downLoadMesZip) {
               boolean downLoadMesRecipe = bs.downLoadMesRecipe();
               if (downLoadMesRecipe) {
                   // 读取recipeFile文件
                   MesRecipeAction mesRecipeAction = new MesRecipeAction(this.window);
                   mesRecipeAction.mesRecipeFile();
               }
           }else {
               MainStatus.status1();
           }
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

}
