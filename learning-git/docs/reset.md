git reset
=========

Reset helps you on rolling back one or multiple commits or the entire branch history

This resets a commit without destroying the changes
```
git reset <commit> --soft
```

This command will destroy the history and the commit
```
git reset <commit> --hard
```

Passing `HEAD~Number` will reset the number of commit you tell it to
```
git reset HEAD~3 --hard
git reset HEAD~3 --soft
```