@ECHO OFF

set "AllowExt=.jar"
for %%a in (%AllowExt%) do (
  forfiles /p %CD% /m *%%a /c "java -Xms16m -Xmx512m -jar @file"
)
