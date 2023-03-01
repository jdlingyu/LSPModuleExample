package com.example.xp;


import com.example.lspmoduleexample.BuildConfig;

import java.lang.reflect.Method;

import androidx.annotation.NonNull;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import io.github.libxposed.api.XposedContext;
import io.github.libxposed.api.XposedModule;
/**
 * @author YanLu
 * @since 2023/3/1
 */

public class MainHook extends XposedModule {
    private static final String TAG = "MainHook";
    /**
     * Instantiates a new Xposed module.<br/>
     * When the module is loaded into the target process, the constructor will be called.
     *
     * @param base  The base context provided by the framework, should not be used by the module
     * @param param Information about the process in which the module is loaded
     */
    public MainHook(@NonNull XposedContext base, @NonNull ModuleLoadedParam param) {
        super(base, param);
    }

    @Override
    public void onPackageLoaded(@NonNull PackageLoadedParam param) {
        super.onPackageLoaded(param);
        final String targetPackage = param.getPackageName();

        log(TAG + "enter -> " + targetPackage);


        if (targetPackage.equals(getAppPackage())) {
            XposedHelpers.findAndHookMethod(getMainActName(), param.getClassLoader(),
                    "isModuleActive", XC_MethodReplacement.returnConstant(true));

//            Class<?> cls = XposedHelpers.findClass(getMainActName(), param.getClassLoader());
//
//            Method method = XposedHelpers.findMethodExactIfExists(cls, "isModuleActive");
//            if (method != null) {
//                hookAfter(method, callback -> {
//
//                    log(TAG + " isModuleActive()");
//
//                    callback.setResult(true);
//
//                });
//            }

            return;
        }

        // other app

    }

    @Override
    public void onSystemServerLoaded(@NonNull SystemServerLoadedParam param) {
        super.onSystemServerLoaded(param);
        log(TAG + "on system server loaded.");
    }

    private String getAppPackage() {
        return BuildConfig.APPLICATION_ID;
    }

    public String getMainActName() {
        return "com.example.lspmoduleexample.MainActivity";
    }
}
