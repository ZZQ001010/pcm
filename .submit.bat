git checkout dev
git pull origin dev
git branch --set-upstream-to=origin/dev
git add .
set /p m="���뱾���ύ������"
^
git commit -m "����:%m%"
git push origin dev
git pull origin dev