cd C:\Eclipse\workspace\ExcelVer1_POM_Sel_ELDT
set ProjectPath=C:\Eclipse\workspace\ExcelVer1_POM_Sel_ELDT
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testngELDT.xml