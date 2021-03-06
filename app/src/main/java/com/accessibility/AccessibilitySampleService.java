package com.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityEvent;

import com.accessibility.utils.AccessibilityLog;


@TargetApi(16)
public class AccessibilitySampleService extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        // 通过代码可以动态配置，但是可配置项少一点
//        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
//        accessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPE_WINDOWS_CHANGED
//                | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
//                | AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
//                | AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
//        accessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;
//        accessibilityServiceInfo.notificationTimeout = 0;
//        accessibilityServiceInfo.flags = AccessibilityServiceInfo.DEFAULT;
//        setServiceInfo(accessibilityServiceInfo);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // 此方法是在主线程中回调过来的，所以消息是阻塞执行的
        // 获取包名
        try{
//            String pkgName = event.getPackageName().toString();
            int eventType = event.getEventType();
            AccessibilityOperator.getInstance().updateEvent(this, event);
            AccessibilityLog.printLog("eventType: " + eventType);
//            AccessibilityLog.printLog("eventType: " + eventType + " pkgName: " + pkgName);
            switch (eventType) {
                case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                    break;
            }
        }catch (Exception e){

        }

    }

    @Override
    public void onInterrupt() {

    }
}
