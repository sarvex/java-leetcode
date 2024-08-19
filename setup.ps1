Get-ChildItem -Filter *.md -Recurse | Remove-Item

Get-ChildItem -Filter *.java -Recurse | Rename-Item -NewName { $_.Directory.Name+'.java'}
Get-ChildItem -Filter *.java -Recurse | Move-Item -Destination { $_.Directory.Parent.FullName }
