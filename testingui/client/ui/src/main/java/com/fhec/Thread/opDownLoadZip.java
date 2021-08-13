package com.fhec.Thread;

import com.fhec.views.OPDownloadView;
import com.fhec.views.Actions.OpDownLoadZipAction;
import com.fhec.views.Actions.OpRecipeAction;

public class opDownLoadZip implements Runnable{
	private OPDownloadView window;
	OpDownLoadZipAction bs;
	public opDownLoadZip(OPDownloadView window,OpDownLoadZipAction bs) {
		this.window=window;
		this.bs=bs;
	}
	@Override
	public void run() {
		startZip();
	}
	public void startZip() {
		boolean downLoadMesZip;
		try {
			downLoadMesZip = bs.downLoadOpZip();
			if (downLoadMesZip) {
				boolean downLoadMesRecipe = bs.downLoadOpRecipe();
				if (downLoadMesRecipe) {
					// 读取recipeFile文件
					OpRecipeAction opRecipeAction = new OpRecipeAction(this.window);
					opRecipeAction.opRecipeFile();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
