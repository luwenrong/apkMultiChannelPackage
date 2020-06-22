# apkMultiChannelPackage
安卓多渠道打包
*仅支持V1打包方式后分包， 如果是v2或v1+v2 需要重新签名后再批量分包：*
```
apksigner sign --ks <keystore> --ks-key-alias <alias name> --v2-signing-enabled false --out <output name> <re-signed apk file>
```

或使用其他支持V2的方式

### 使用说明
* 将母包 apk 放在 PythonPackageTool 下，在info/channel.txt中写入渠道名。
* 执行命令  python apk.py
* 打包母包时需要引入 ApkJavaUtils/ChannelUtils.java 在需要使用渠道号的地方调用 getChannelId();
