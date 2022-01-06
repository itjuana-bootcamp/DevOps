git pull
========

Git pull does a couple of things at the same time, it will fetch the latest 
changes and it will also merge the remote changes locally
```
git pull <remote> <branch>
```

You can also use `--rebase` to do a merge `svn` style, this will pull the latest
changes and will place them bellow your current changes in order to have a clean
history and avoid creating a merge commit
```
git pull <remote> <branch> --rebase
```

You could also use `--squash` in order to clean the remote history and avoid
a merge commit as well
```
git pull <remote> <branch> --squash
```