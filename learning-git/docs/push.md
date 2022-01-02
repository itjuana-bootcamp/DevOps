git push
=========

The push command allows to send your changes (commits) to a remote repository
```
git push <remote> <branch>
```

There are some times when you want to reset a branch or overwrite the history
```
git push <remote> <branch> -f
```

Deleting a remove branch using push
```
git push <remote> :<branch>
```

Push from a local branch to a different branch
```
git push <remote> <local_branch>:<remote_branch>
```