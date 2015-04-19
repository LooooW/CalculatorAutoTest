# CalculatorAutoTest

A simple sample for UIAutomator.

To Run:
    
    ant build
    adb push <path>\CalculatorAutoTest.jar  /data/local/tmp/
    adb shell uiautomator runtest CalculatorAutoTest.jar -c CalTest
    
    If you want remote debugging on Eclipse, you can try: "-e debug true"
    
Some difficulties while has been solved:
  
    To locate the sliding frame --- use the uiautomatorviewer.bat
    To find out some appliactions which allocated port --- netstat -aon | findstr <port>
    If use MonkeyRunner on Android Phone, you should open View Server
    
        adb shell service call window 3 --- Show result 
        adb shell service call window 1 i32 4939 --- Open
        adb shell service call window 2 i32 4939 --- Close
    
