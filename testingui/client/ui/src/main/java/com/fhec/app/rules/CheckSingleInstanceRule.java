package com.fhec.app.rules;

import com.fhec.app.IRule;
import com.fhec.context.GlobalContext;
import com.fhec.locker.FileLocker;

import javax.swing.*;

public class CheckSingleInstanceRule implements IRule {
    @Override
    public boolean doRule() throws Exception {
        FileLocker fileLocker = FileLocker.GetOrCreate(GlobalContext.Instance.getUiIconPath());
        if (!fileLocker.isValid()) {
            // UI已经启动
           throw new Exception("UI已经启动");
        }
        GlobalContext.Instance.setFileLocker(fileLocker);
        return true;
    }
}

