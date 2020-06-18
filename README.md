# apkMultiChannelPackage
安卓多渠道打包

### 使用说明
* 将母包 apk 放在 PythonPackageTool 下，在info/channel.txt中写入渠道名（格式：项目名_渠道名）名称不要出现下划线。
* 执行命令  python apk.py
* 打包母包时需要引入 ApkJavaUtils/ChannelUtils.java 在需要使用渠道号的地方调用 getChannelId();
