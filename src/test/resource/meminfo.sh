#!/bin/sh
memLog="log_meminfo.log"
if [ ! -f "$memLog" ]; then
    {
        echo "YYYYMMDDHHmmss value Alloc Free"
    } >> $memLog
fi


while true
do
    {
        echo "`date +"%Y%m%d%H%M%S"` `adb shell dumpsys meminfo com.pingan.pinganwifi | grep TOTAL`"                       #要执行的命令
    } | awk '{print $1, $8-$9, $8, $9}' >> $memLog                    #输出到日志

sleep 10                               #等待10秒
done


#awk '{print $1,$8,$9}' log_meminfo_all.log
#echo "`date +'%Y%m%d%H%M%S'` `adb shell dumpsys meminfo com.pingan.pinganwifi | grep TOTAL`" | awk '{print $1,"\t"$8, "\t"$9}'