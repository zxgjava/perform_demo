#!/bin/sh
cpuLog="log_cpuinfo_all.log"
if [ ! -f "$cpuLog" ]; then
    {
        echo "  PID PR CPU% S  #THR     VSS     RSS PCY UID      Name"
    } >> $cpuLog
fi


while true
do
    {
        adb shell top -n 1| grep com.pingan.pinganwifi                         #要执行的命令
    } >> $cpuLog                    #输出到日志

sleep 10                               #等待10秒
done


#adb shell dumpsys cpuinfo | grep -E "com.pingan.pinganwifi|TOTAL"