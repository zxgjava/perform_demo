#!/bin/sh
cpuLog="log_cpuinfo.log"
if [ ! -f "$cpuLog" ]; then
    {
        echo ""
    } >> $cpuLog
fi


while true
do
    {
        date +"%Y-%m-%d %H:%M:%S"     #取当前日期和时间
        adb shell dumpsys cpuinfo | grep -E "com.pingan.pinganwifi|TOTAL"                         #要执行的命令
    } >> $cpuLog                    #输出到日志

sleep 10                               #等待10秒
done

#adb shell dumpsys cpuinfo | grep -E "com.pingan.pinganwifi|TOTAL"