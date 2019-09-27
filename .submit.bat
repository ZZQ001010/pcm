git checkout dev
git pull origin dev
git branch --set-upstream-to=origin/dev
git add .
set /p m="输入本次提交描述："
^
git commit -m "描述:%m%"
git push origin dev
git pull origin dev